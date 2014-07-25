// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: RemoveConf.proto

package com.dp.blackhole.protocol.control;

public final class RemoveConfPB {
  private RemoveConfPB() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public static final class RemoveConf extends
      com.google.protobuf.GeneratedMessage {
    // Use RemoveConf.newBuilder() to construct.
    private RemoveConf() {
      initFields();
    }
    private RemoveConf(boolean noInit) {}
    
    private static final RemoveConf defaultInstance;
    public static RemoveConf getDefaultInstance() {
      return defaultInstance;
    }
    
    public RemoveConf getDefaultInstanceForType() {
      return defaultInstance;
    }
    
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dp.blackhole.protocol.control.RemoveConfPB.internal_static_blackhole_RemoveConf_descriptor;
    }
    
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dp.blackhole.protocol.control.RemoveConfPB.internal_static_blackhole_RemoveConf_fieldAccessorTable;
    }
    
    // required string topic = 1;
    public static final int TOPIC_FIELD_NUMBER = 1;
    private boolean hasTopic;
    private java.lang.String topic_ = "";
    public boolean hasTopic() { return hasTopic; }
    public java.lang.String getTopic() { return topic_; }
    
    // repeated string agent_servers = 2;
    public static final int AGENT_SERVERS_FIELD_NUMBER = 2;
    private java.util.List<java.lang.String> agentServers_ =
      java.util.Collections.emptyList();
    public java.util.List<java.lang.String> getAgentServersList() {
      return agentServers_;
    }
    public int getAgentServersCount() { return agentServers_.size(); }
    public java.lang.String getAgentServers(int index) {
      return agentServers_.get(index);
    }
    
    private void initFields() {
    }
    public final boolean isInitialized() {
      if (!hasTopic) return false;
      return true;
    }
    
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (hasTopic()) {
        output.writeString(1, getTopic());
      }
      for (java.lang.String element : getAgentServersList()) {
        output.writeString(2, element);
      }
      getUnknownFields().writeTo(output);
    }
    
    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;
    
      size = 0;
      if (hasTopic()) {
        size += com.google.protobuf.CodedOutputStream
          .computeStringSize(1, getTopic());
      }
      {
        int dataSize = 0;
        for (java.lang.String element : getAgentServersList()) {
          dataSize += com.google.protobuf.CodedOutputStream
            .computeStringSizeNoTag(element);
        }
        size += dataSize;
        size += 1 * getAgentServersList().size();
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }
    
    public static com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    public static com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    
    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }
    
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> {
      private com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf result;
      
      // Construct using com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf.newBuilder()
      private Builder() {}
      
      private static Builder create() {
        Builder builder = new Builder();
        builder.result = new com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf();
        return builder;
      }
      
      protected com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf internalGetResult() {
        return result;
      }
      
      public Builder clear() {
        if (result == null) {
          throw new IllegalStateException(
            "Cannot call clear() after build().");
        }
        result = new com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf();
        return this;
      }
      
      public Builder clone() {
        return create().mergeFrom(result);
      }
      
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf.getDescriptor();
      }
      
      public com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf getDefaultInstanceForType() {
        return com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf.getDefaultInstance();
      }
      
      public boolean isInitialized() {
        return result.isInitialized();
      }
      public com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf build() {
        if (result != null && !isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return buildPartial();
      }
      
      private com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf buildParsed()
          throws com.google.protobuf.InvalidProtocolBufferException {
        if (!isInitialized()) {
          throw newUninitializedMessageException(
            result).asInvalidProtocolBufferException();
        }
        return buildPartial();
      }
      
      public com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf buildPartial() {
        if (result == null) {
          throw new IllegalStateException(
            "build() has already been called on this Builder.");
        }
        if (result.agentServers_ != java.util.Collections.EMPTY_LIST) {
          result.agentServers_ =
            java.util.Collections.unmodifiableList(result.agentServers_);
        }
        com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf returnMe = result;
        result = null;
        return returnMe;
      }
      
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf) {
          return mergeFrom((com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }
      
      public Builder mergeFrom(com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf other) {
        if (other == com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf.getDefaultInstance()) return this;
        if (other.hasTopic()) {
          setTopic(other.getTopic());
        }
        if (!other.agentServers_.isEmpty()) {
          if (result.agentServers_.isEmpty()) {
            result.agentServers_ = new java.util.ArrayList<java.lang.String>();
          }
          result.agentServers_.addAll(other.agentServers_);
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }
      
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder(
            this.getUnknownFields());
        while (true) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              this.setUnknownFields(unknownFields.build());
              return this;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                this.setUnknownFields(unknownFields.build());
                return this;
              }
              break;
            }
            case 10: {
              setTopic(input.readString());
              break;
            }
            case 18: {
              addAgentServers(input.readString());
              break;
            }
          }
        }
      }
      
      
      // required string topic = 1;
      public boolean hasTopic() {
        return result.hasTopic();
      }
      public java.lang.String getTopic() {
        return result.getTopic();
      }
      public Builder setTopic(java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  result.hasTopic = true;
        result.topic_ = value;
        return this;
      }
      public Builder clearTopic() {
        result.hasTopic = false;
        result.topic_ = getDefaultInstance().getTopic();
        return this;
      }
      
      // repeated string agent_servers = 2;
      public java.util.List<java.lang.String> getAgentServersList() {
        return java.util.Collections.unmodifiableList(result.agentServers_);
      }
      public int getAgentServersCount() {
        return result.getAgentServersCount();
      }
      public java.lang.String getAgentServers(int index) {
        return result.getAgentServers(index);
      }
      public Builder setAgentServers(int index, java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  result.agentServers_.set(index, value);
        return this;
      }
      public Builder addAgentServers(java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  if (result.agentServers_.isEmpty()) {
          result.agentServers_ = new java.util.ArrayList<java.lang.String>();
        }
        result.agentServers_.add(value);
        return this;
      }
      public Builder addAllAgentServers(
          java.lang.Iterable<? extends java.lang.String> values) {
        if (result.agentServers_.isEmpty()) {
          result.agentServers_ = new java.util.ArrayList<java.lang.String>();
        }
        super.addAll(values, result.agentServers_);
        return this;
      }
      public Builder clearAgentServers() {
        result.agentServers_ = java.util.Collections.emptyList();
        return this;
      }
      
      // @@protoc_insertion_point(builder_scope:blackhole.RemoveConf)
    }
    
    static {
      defaultInstance = new RemoveConf(true);
      com.dp.blackhole.protocol.control.RemoveConfPB.internalForceInit();
      defaultInstance.initFields();
    }
    
    // @@protoc_insertion_point(class_scope:blackhole.RemoveConf)
  }
  
  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_blackhole_RemoveConf_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_blackhole_RemoveConf_fieldAccessorTable;
  
  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\020RemoveConf.proto\022\tblackhole\"2\n\nRemoveC" +
      "onf\022\r\n\005topic\030\001 \002(\t\022\025\n\ragent_servers\030\002 \003(" +
      "\tB1\n!com.dp.blackhole.protocol.controlB\014" +
      "RemoveConfPB"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_blackhole_RemoveConf_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_blackhole_RemoveConf_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_blackhole_RemoveConf_descriptor,
              new java.lang.String[] { "Topic", "AgentServers", },
              com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf.class,
              com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf.Builder.class);
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }
  
  public static void internalForceInit() {}
  
  // @@protoc_insertion_point(outer_class_scope)
}
