package com.dp.blackhole.collectornode.persistent.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

import com.dp.blackhole.collectornode.persistent.ByteBufferMessageSet;
import com.dp.blackhole.collectornode.persistent.MessageSet;
import com.dp.blackhole.network.DelegationTypedWrappable;
import com.dp.blackhole.network.GenUtil;

public class FetchReply extends DelegationTypedWrappable {

    private ByteBuffer head;
    private ByteBuffer messagesBuf;
    
    private String partition;
    private MessageSet messages;
    private long offset;
    
    private int size;
    private int sent;
    
    private boolean complete;
    
    public FetchReply() {
        head = allocateHead();
    }
    
    public FetchReply(String partition, MessageSet messages, long offset) {
        this.partition = partition;
        this.offset = offset;
        this.messages = messages;
        this.size = messages.getSize();
        this.head = allocateHead();
        this.head.putInt(size);
        this.head.putLong(this.offset);
        GenUtil.writeString(partition, this.head);
        this.head.flip();
    }

    private ByteBuffer allocateHead() {
        return ByteBuffer.allocate((Integer.SIZE + Long.SIZE)/8 + GenUtil.getStringSize(partition));
    }
    
    @Override
    public final int getSize() {
        return size;
    }

    public long getOffset() {
        return offset;
    }

    public String getPartition() {
        return partition;
    }

    public MessageSet getMessageSet() {
        return messages;
    }
    
    @Override
    public int getType() {
        return DataMessageTypeFactory.FetchReply;
    }
    
    @Override
    public int write(GatheringByteChannel channel) throws IOException {
        int written = 0;
        if (head.hasRemaining()) {
          written = GenUtil.retryWrite(channel, head);
          if (!head.hasRemaining()) {
              return written;
          }
        }
        if (!head.hasRemaining()) {
            for (int i=0; i< 16; i++) {
                int num = (int) messages.write(channel, sent, size -sent);
                written += num;
                sent += num;
                if (num != 0) {
                    break;
                }
            }
        }
        
        if (sent >= size) {
            complete = true;
        }
        return written;
    }

    @Override
    public int read(ScatteringByteChannel channel) throws IOException {
        int read = 0;
        if (head.hasRemaining()) {
            int num = channel.read(head);
            if (num < 0) {
                throw new IOException("end-of-stream reached");
            }
            read += num;
            if (head.hasRemaining()) {
                return read;
            } else {
                head.flip();
                size = head.getInt();
                offset = head.getLong();
                partition = GenUtil.readString(head);
                messagesBuf = ByteBuffer.allocate(size);                
            }
        }
        
        if (!head.hasRemaining()) {
            int num = channel.read(messagesBuf);
            if (num < 0) {
                throw new IOException("end-of-stream reached");
            }
            read += num;
            if (!messagesBuf.hasRemaining()) {
                messagesBuf.flip();
                messages = new ByteBufferMessageSet(messagesBuf, offset);
                complete = true;
            }
        }
        return read;
    }

    @Override
    public boolean complete() {
        return complete;
    }
}