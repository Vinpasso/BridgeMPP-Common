// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: bridgempp.proto

package bridgempp.services.socket.protobuf;

public interface MessageBodyOrBuilder extends
    // @@protoc_insertion_point(interface_extends:bridgempp.MessageBody)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional .bridgempp.MessageType messageType = 1;</code>
   */
  int getMessageTypeValue();
  /**
   * <code>optional .bridgempp.MessageType messageType = 1;</code>
   */
  bridgempp.services.socket.protobuf.MessageType getMessageType();

  /**
   * <code>optional string contents = 2;</code>
   */
  java.lang.String getContents();
  /**
   * <code>optional string contents = 2;</code>
   */
  com.google.protobuf.ByteString
      getContentsBytes();
}