// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: PasswordService.proto

package ie.gmit.ds;

public final class PasswordServiceOuterClass {
  private PasswordServiceOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ie_gmit_ds_HashRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ie_gmit_ds_HashRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ie_gmit_ds_HashResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ie_gmit_ds_HashResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ie_gmit_ds_ValidateRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ie_gmit_ds_ValidateRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ie_gmit_ds_ValidateResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ie_gmit_ds_ValidateResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\025PasswordService.proto\022\nie.gmit.ds\"/\n\013H" +
      "ashRequest\022\016\n\006userId\030\001 \001(\005\022\020\n\010password\030\002" +
      " \001(\t\"B\n\014HashResponse\022\016\n\006userId\030\001 \001(\005\022\024\n\014" +
      "expectedHash\030\002 \001(\014\022\014\n\004salt\030\003 \001(\014\"G\n\017Vali" +
      "dateRequest\022\020\n\010password\030\001 \001(\t\022\024\n\014expecte" +
      "dHash\030\002 \001(\014\022\014\n\004salt\030\003 \001(\014\")\n\020ValidateRes" +
      "ponse\022\025\n\rvalidPassword\030\001 \001(\0102\223\001\n\017Passwor" +
      "dService\0229\n\004Hash\022\027.ie.gmit.ds.HashReques" +
      "t\032\030.ie.gmit.ds.HashResponse\022E\n\010Validate\022" +
      "\033.ie.gmit.ds.ValidateRequest\032\034.ie.gmit.d" +
      "s.ValidateResponseB\016\n\nie.gmit.dsP\001b\006prot" +
      "o3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_ie_gmit_ds_HashRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ie_gmit_ds_HashRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ie_gmit_ds_HashRequest_descriptor,
        new java.lang.String[] { "UserId", "Password", });
    internal_static_ie_gmit_ds_HashResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_ie_gmit_ds_HashResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ie_gmit_ds_HashResponse_descriptor,
        new java.lang.String[] { "UserId", "ExpectedHash", "Salt", });
    internal_static_ie_gmit_ds_ValidateRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_ie_gmit_ds_ValidateRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ie_gmit_ds_ValidateRequest_descriptor,
        new java.lang.String[] { "Password", "ExpectedHash", "Salt", });
    internal_static_ie_gmit_ds_ValidateResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_ie_gmit_ds_ValidateResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ie_gmit_ds_ValidateResponse_descriptor,
        new java.lang.String[] { "ValidPassword", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}