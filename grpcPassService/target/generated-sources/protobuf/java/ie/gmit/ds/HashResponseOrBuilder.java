// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: PasswordService.proto

package ie.gmit.ds;

public interface HashResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ie.gmit.ds.HashResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 userId = 1;</code>
   */
  int getUserId();

  /**
   * <code>bytes expectedHash = 2;</code>
   */
  com.google.protobuf.ByteString getExpectedHash();

  /**
   * <code>bytes salt = 3;</code>
   */
  com.google.protobuf.ByteString getSalt();
}
