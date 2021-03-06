package com.dp.blackhole.protocol.data;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.util.List;

import com.dp.blackhole.network.DelegationTypedWrappable;
import com.dp.blackhole.network.GenUtil;
import com.dp.blackhole.storage.MessageSet;

public class MultiFetchReply extends DelegationTypedWrappable {

    final ByteBuffer sizeBuffer = ByteBuffer.allocate(Integer.SIZE/8);
    private ByteBuffer contentBuffer = null;
    private List<String> partitionList;
    private List<MessageSet> messagesList;
    private List<Long> offsetList;
    private int size;
    private int index;
    private boolean complete;
    private FetchReply currentReply;
    
    public MultiFetchReply() {}
    
    /**
     * 
     * @param partitionList
     * @param messagesList The callers should guarantee messagesList not null themselves.
     * @param offsetList
     */
    public MultiFetchReply(List<String> partitionList, List<MessageSet> messagesList, List<Long> offsetList) {
        this.partitionList = partitionList;
        this.messagesList = messagesList;
        this.offsetList = offsetList;
        for (MessageSet set : messagesList) {
            size += set.getSize();
        }
        this.sizeBuffer.putInt(size);
        this.sizeBuffer.flip();
    }
    
    @Override
    public int getType() {
        return DataMessageTypeFactory.MultiFetchReply;
    }
    
    @Override
    public int getSize() {
        return size;
    }

    public List<String> getPartitionList() {
        return partitionList;
    }

    public List<MessageSet> getMessagesList() {
        return messagesList;
    }

    public List<Long> getOffsetList() {
        return offsetList;
    }

    @Override
    public int write(GatheringByteChannel channel) throws IOException {
        int written = 0;
        if (sizeBuffer.hasRemaining()) {
            written = GenUtil.retryWrite(channel, sizeBuffer);
            if (!sizeBuffer.hasRemaining()) {
                return written;
            }
        }
        if (!sizeBuffer.hasRemaining()) {
            if (currentReply == null) {
                if (messagesList.size() == 0) {
                    throw new IOException("MessageSet list empty!");
                }
                currentReply = new FetchReply(partitionList.get(0), messagesList.get(0), offsetList.get(0));
            }
            written += currentReply.write(channel);
            if (currentReply.complete()) {
                index++;
                if (index == messagesList.size()) {
                    complete = true;
                } else {
                    currentReply = new FetchReply(partitionList.get(index), messagesList.get(index), offsetList.get(index));
                }
            }
        }
        return written;
    }

    @Override
    public int read(ScatteringByteChannel channel) throws IOException {
        int read = 0;
        if (sizeBuffer.hasRemaining()) {
            int num = channel.read(sizeBuffer);
            if (num < 0) {
                throw new IOException("end-of-stream reached");
            }
            read += num;
            if (sizeBuffer.hasRemaining()) {
                return read;
            } else {
                sizeBuffer.flip();
                size = sizeBuffer.getInt();
                contentBuffer = ByteBuffer.allocate(size);                
            }
        }
        
        if (!sizeBuffer.hasRemaining()) {
            int num = channel.read(contentBuffer);
            if (num < 0) {
                throw new IOException("end-of-stream reached");
            }
            read += num;
            if (!contentBuffer.hasRemaining()) {
                contentBuffer.flip();
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
