// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: bridgempp.proto

package bridgempp.services.socket.protobuf;

/**
 * Protobuf type {@code bridgempp.MessageBody}
 */
public  final class MessageBody extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:bridgempp.MessageBody)
    MessageBodyOrBuilder {
  // Use MessageBody.newBuilder() to construct.
  private MessageBody(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private MessageBody() {
    messageType_ = 0;
    contents_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private MessageBody(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 8: {
            int rawValue = input.readEnum();

            messageType_ = rawValue;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            contents_ = s;
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return bridgempp.services.socket.protobuf.BridgeProtoBuf.internal_static_bridgempp_MessageBody_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return bridgempp.services.socket.protobuf.BridgeProtoBuf.internal_static_bridgempp_MessageBody_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            bridgempp.services.socket.protobuf.MessageBody.class, bridgempp.services.socket.protobuf.MessageBody.Builder.class);
  }

  public static final int MESSAGETYPE_FIELD_NUMBER = 1;
  private int messageType_;
  /**
   * <code>optional .bridgempp.MessageType messageType = 1;</code>
   */
  public int getMessageTypeValue() {
    return messageType_;
  }
  /**
   * <code>optional .bridgempp.MessageType messageType = 1;</code>
   */
  public bridgempp.services.socket.protobuf.MessageType getMessageType() {
    bridgempp.services.socket.protobuf.MessageType result = bridgempp.services.socket.protobuf.MessageType.valueOf(messageType_);
    return result == null ? bridgempp.services.socket.protobuf.MessageType.UNRECOGNIZED : result;
  }

  public static final int CONTENTS_FIELD_NUMBER = 2;
  private volatile java.lang.Object contents_;
  /**
   * <code>optional string contents = 2;</code>
   */
  public java.lang.String getContents() {
    java.lang.Object ref = contents_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      contents_ = s;
      return s;
    }
  }
  /**
   * <code>optional string contents = 2;</code>
   */
  public com.google.protobuf.ByteString
      getContentsBytes() {
    java.lang.Object ref = contents_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      contents_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (messageType_ != bridgempp.services.socket.protobuf.MessageType.PLAIN_TEXT.getNumber()) {
      output.writeEnum(1, messageType_);
    }
    if (!getContentsBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, contents_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (messageType_ != bridgempp.services.socket.protobuf.MessageType.PLAIN_TEXT.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(1, messageType_);
    }
    if (!getContentsBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, contents_);
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof bridgempp.services.socket.protobuf.MessageBody)) {
      return super.equals(obj);
    }
    bridgempp.services.socket.protobuf.MessageBody other = (bridgempp.services.socket.protobuf.MessageBody) obj;

    boolean result = true;
    result = result && messageType_ == other.messageType_;
    result = result && getContents()
        .equals(other.getContents());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptorForType().hashCode();
    hash = (37 * hash) + MESSAGETYPE_FIELD_NUMBER;
    hash = (53 * hash) + messageType_;
    hash = (37 * hash) + CONTENTS_FIELD_NUMBER;
    hash = (53 * hash) + getContents().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static bridgempp.services.socket.protobuf.MessageBody parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static bridgempp.services.socket.protobuf.MessageBody parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static bridgempp.services.socket.protobuf.MessageBody parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static bridgempp.services.socket.protobuf.MessageBody parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static bridgempp.services.socket.protobuf.MessageBody parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static bridgempp.services.socket.protobuf.MessageBody parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static bridgempp.services.socket.protobuf.MessageBody parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static bridgempp.services.socket.protobuf.MessageBody parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static bridgempp.services.socket.protobuf.MessageBody parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static bridgempp.services.socket.protobuf.MessageBody parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(bridgempp.services.socket.protobuf.MessageBody prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code bridgempp.MessageBody}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:bridgempp.MessageBody)
      bridgempp.services.socket.protobuf.MessageBodyOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return bridgempp.services.socket.protobuf.BridgeProtoBuf.internal_static_bridgempp_MessageBody_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return bridgempp.services.socket.protobuf.BridgeProtoBuf.internal_static_bridgempp_MessageBody_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              bridgempp.services.socket.protobuf.MessageBody.class, bridgempp.services.socket.protobuf.MessageBody.Builder.class);
    }

    // Construct using bridgempp.services.socket.protobuf.MessageBody.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      messageType_ = 0;

      contents_ = "";

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return bridgempp.services.socket.protobuf.BridgeProtoBuf.internal_static_bridgempp_MessageBody_descriptor;
    }

    public bridgempp.services.socket.protobuf.MessageBody getDefaultInstanceForType() {
      return bridgempp.services.socket.protobuf.MessageBody.getDefaultInstance();
    }

    public bridgempp.services.socket.protobuf.MessageBody build() {
      bridgempp.services.socket.protobuf.MessageBody result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public bridgempp.services.socket.protobuf.MessageBody buildPartial() {
      bridgempp.services.socket.protobuf.MessageBody result = new bridgempp.services.socket.protobuf.MessageBody(this);
      result.messageType_ = messageType_;
      result.contents_ = contents_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof bridgempp.services.socket.protobuf.MessageBody) {
        return mergeFrom((bridgempp.services.socket.protobuf.MessageBody)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(bridgempp.services.socket.protobuf.MessageBody other) {
      if (other == bridgempp.services.socket.protobuf.MessageBody.getDefaultInstance()) return this;
      if (other.messageType_ != 0) {
        setMessageTypeValue(other.getMessageTypeValue());
      }
      if (!other.getContents().isEmpty()) {
        contents_ = other.contents_;
        onChanged();
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      bridgempp.services.socket.protobuf.MessageBody parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (bridgempp.services.socket.protobuf.MessageBody) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int messageType_ = 0;
    /**
     * <code>optional .bridgempp.MessageType messageType = 1;</code>
     */
    public int getMessageTypeValue() {
      return messageType_;
    }
    /**
     * <code>optional .bridgempp.MessageType messageType = 1;</code>
     */
    public Builder setMessageTypeValue(int value) {
      messageType_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional .bridgempp.MessageType messageType = 1;</code>
     */
    public bridgempp.services.socket.protobuf.MessageType getMessageType() {
      bridgempp.services.socket.protobuf.MessageType result = bridgempp.services.socket.protobuf.MessageType.valueOf(messageType_);
      return result == null ? bridgempp.services.socket.protobuf.MessageType.UNRECOGNIZED : result;
    }
    /**
     * <code>optional .bridgempp.MessageType messageType = 1;</code>
     */
    public Builder setMessageType(bridgempp.services.socket.protobuf.MessageType value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      messageType_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>optional .bridgempp.MessageType messageType = 1;</code>
     */
    public Builder clearMessageType() {
      
      messageType_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object contents_ = "";
    /**
     * <code>optional string contents = 2;</code>
     */
    public java.lang.String getContents() {
      java.lang.Object ref = contents_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        contents_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string contents = 2;</code>
     */
    public com.google.protobuf.ByteString
        getContentsBytes() {
      java.lang.Object ref = contents_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        contents_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string contents = 2;</code>
     */
    public Builder setContents(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      contents_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string contents = 2;</code>
     */
    public Builder clearContents() {
      
      contents_ = getDefaultInstance().getContents();
      onChanged();
      return this;
    }
    /**
     * <code>optional string contents = 2;</code>
     */
    public Builder setContentsBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      contents_ = value;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:bridgempp.MessageBody)
  }

  // @@protoc_insertion_point(class_scope:bridgempp.MessageBody)
  private static final bridgempp.services.socket.protobuf.MessageBody DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new bridgempp.services.socket.protobuf.MessageBody();
  }

  public static bridgempp.services.socket.protobuf.MessageBody getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<MessageBody>
      PARSER = new com.google.protobuf.AbstractParser<MessageBody>() {
    public MessageBody parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new MessageBody(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<MessageBody> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<MessageBody> getParserForType() {
    return PARSER;
  }

  public bridgempp.services.socket.protobuf.MessageBody getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

