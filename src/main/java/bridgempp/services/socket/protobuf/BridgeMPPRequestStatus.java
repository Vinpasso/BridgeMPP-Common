// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: bridgempp.proto

package bridgempp.services.socket.protobuf;

/**
 * Protobuf type {@code bridgempp.BridgeMPPRequestStatus}
 */
public  final class BridgeMPPRequestStatus extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:bridgempp.BridgeMPPRequestStatus)
    BridgeMPPRequestStatusOrBuilder {
  // Use BridgeMPPRequestStatus.newBuilder() to construct.
  private BridgeMPPRequestStatus(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private BridgeMPPRequestStatus() {
    requestStatus_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private BridgeMPPRequestStatus(
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

            requestStatus_ = rawValue;
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
    return bridgempp.services.socket.protobuf.BridgeProtoBuf.internal_static_bridgempp_BridgeMPPRequestStatus_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return bridgempp.services.socket.protobuf.BridgeProtoBuf.internal_static_bridgempp_BridgeMPPRequestStatus_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            bridgempp.services.socket.protobuf.BridgeMPPRequestStatus.class, bridgempp.services.socket.protobuf.BridgeMPPRequestStatus.Builder.class);
  }

  public static final int REQUESTSTATUS_FIELD_NUMBER = 1;
  private int requestStatus_;
  /**
   * <code>optional .bridgempp.RequestStatus requestStatus = 1;</code>
   */
  public int getRequestStatusValue() {
    return requestStatus_;
  }
  /**
   * <code>optional .bridgempp.RequestStatus requestStatus = 1;</code>
   */
  public bridgempp.services.socket.protobuf.RequestStatus getRequestStatus() {
    bridgempp.services.socket.protobuf.RequestStatus result = bridgempp.services.socket.protobuf.RequestStatus.valueOf(requestStatus_);
    return result == null ? bridgempp.services.socket.protobuf.RequestStatus.UNRECOGNIZED : result;
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
    if (requestStatus_ != bridgempp.services.socket.protobuf.RequestStatus.SUCCESS.getNumber()) {
      output.writeEnum(1, requestStatus_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (requestStatus_ != bridgempp.services.socket.protobuf.RequestStatus.SUCCESS.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(1, requestStatus_);
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
    if (!(obj instanceof bridgempp.services.socket.protobuf.BridgeMPPRequestStatus)) {
      return super.equals(obj);
    }
    bridgempp.services.socket.protobuf.BridgeMPPRequestStatus other = (bridgempp.services.socket.protobuf.BridgeMPPRequestStatus) obj;

    boolean result = true;
    result = result && requestStatus_ == other.requestStatus_;
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptorForType().hashCode();
    hash = (37 * hash) + REQUESTSTATUS_FIELD_NUMBER;
    hash = (53 * hash) + requestStatus_;
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static bridgempp.services.socket.protobuf.BridgeMPPRequestStatus parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static bridgempp.services.socket.protobuf.BridgeMPPRequestStatus parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static bridgempp.services.socket.protobuf.BridgeMPPRequestStatus parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static bridgempp.services.socket.protobuf.BridgeMPPRequestStatus parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static bridgempp.services.socket.protobuf.BridgeMPPRequestStatus parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static bridgempp.services.socket.protobuf.BridgeMPPRequestStatus parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static bridgempp.services.socket.protobuf.BridgeMPPRequestStatus parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static bridgempp.services.socket.protobuf.BridgeMPPRequestStatus parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static bridgempp.services.socket.protobuf.BridgeMPPRequestStatus parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static bridgempp.services.socket.protobuf.BridgeMPPRequestStatus parseFrom(
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
  public static Builder newBuilder(bridgempp.services.socket.protobuf.BridgeMPPRequestStatus prototype) {
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
   * Protobuf type {@code bridgempp.BridgeMPPRequestStatus}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:bridgempp.BridgeMPPRequestStatus)
      bridgempp.services.socket.protobuf.BridgeMPPRequestStatusOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return bridgempp.services.socket.protobuf.BridgeProtoBuf.internal_static_bridgempp_BridgeMPPRequestStatus_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return bridgempp.services.socket.protobuf.BridgeProtoBuf.internal_static_bridgempp_BridgeMPPRequestStatus_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              bridgempp.services.socket.protobuf.BridgeMPPRequestStatus.class, bridgempp.services.socket.protobuf.BridgeMPPRequestStatus.Builder.class);
    }

    // Construct using bridgempp.services.socket.protobuf.BridgeMPPRequestStatus.newBuilder()
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
      requestStatus_ = 0;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return bridgempp.services.socket.protobuf.BridgeProtoBuf.internal_static_bridgempp_BridgeMPPRequestStatus_descriptor;
    }

    public bridgempp.services.socket.protobuf.BridgeMPPRequestStatus getDefaultInstanceForType() {
      return bridgempp.services.socket.protobuf.BridgeMPPRequestStatus.getDefaultInstance();
    }

    public bridgempp.services.socket.protobuf.BridgeMPPRequestStatus build() {
      bridgempp.services.socket.protobuf.BridgeMPPRequestStatus result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public bridgempp.services.socket.protobuf.BridgeMPPRequestStatus buildPartial() {
      bridgempp.services.socket.protobuf.BridgeMPPRequestStatus result = new bridgempp.services.socket.protobuf.BridgeMPPRequestStatus(this);
      result.requestStatus_ = requestStatus_;
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
      if (other instanceof bridgempp.services.socket.protobuf.BridgeMPPRequestStatus) {
        return mergeFrom((bridgempp.services.socket.protobuf.BridgeMPPRequestStatus)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(bridgempp.services.socket.protobuf.BridgeMPPRequestStatus other) {
      if (other == bridgempp.services.socket.protobuf.BridgeMPPRequestStatus.getDefaultInstance()) return this;
      if (other.requestStatus_ != 0) {
        setRequestStatusValue(other.getRequestStatusValue());
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
      bridgempp.services.socket.protobuf.BridgeMPPRequestStatus parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (bridgempp.services.socket.protobuf.BridgeMPPRequestStatus) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int requestStatus_ = 0;
    /**
     * <code>optional .bridgempp.RequestStatus requestStatus = 1;</code>
     */
    public int getRequestStatusValue() {
      return requestStatus_;
    }
    /**
     * <code>optional .bridgempp.RequestStatus requestStatus = 1;</code>
     */
    public Builder setRequestStatusValue(int value) {
      requestStatus_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional .bridgempp.RequestStatus requestStatus = 1;</code>
     */
    public bridgempp.services.socket.protobuf.RequestStatus getRequestStatus() {
      bridgempp.services.socket.protobuf.RequestStatus result = bridgempp.services.socket.protobuf.RequestStatus.valueOf(requestStatus_);
      return result == null ? bridgempp.services.socket.protobuf.RequestStatus.UNRECOGNIZED : result;
    }
    /**
     * <code>optional .bridgempp.RequestStatus requestStatus = 1;</code>
     */
    public Builder setRequestStatus(bridgempp.services.socket.protobuf.RequestStatus value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      requestStatus_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>optional .bridgempp.RequestStatus requestStatus = 1;</code>
     */
    public Builder clearRequestStatus() {
      
      requestStatus_ = 0;
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


    // @@protoc_insertion_point(builder_scope:bridgempp.BridgeMPPRequestStatus)
  }

  // @@protoc_insertion_point(class_scope:bridgempp.BridgeMPPRequestStatus)
  private static final bridgempp.services.socket.protobuf.BridgeMPPRequestStatus DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new bridgempp.services.socket.protobuf.BridgeMPPRequestStatus();
  }

  public static bridgempp.services.socket.protobuf.BridgeMPPRequestStatus getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<BridgeMPPRequestStatus>
      PARSER = new com.google.protobuf.AbstractParser<BridgeMPPRequestStatus>() {
    public BridgeMPPRequestStatus parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new BridgeMPPRequestStatus(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<BridgeMPPRequestStatus> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<BridgeMPPRequestStatus> getParserForType() {
    return PARSER;
  }

  public bridgempp.services.socket.protobuf.BridgeMPPRequestStatus getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
