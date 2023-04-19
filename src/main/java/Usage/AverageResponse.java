// Generated by the protocol buffer compiler.  DO NOT EDIT!
// Source: usage.proto

package Usage;

import com.google.protobuf.ByteString;

/**
 * <pre>
 *  Usage Service Definition
 * </pre>
 *
 * Protobuf type {@code SmartEnergy.AverageResponse}
 */
public class AverageResponse extends
        com.google.protobuf.GeneratedMessageV3 implements
        // @@protoc_insertion_point(message_implements: SmartEnergy.AverageResponse)
        AverageResponseOrBuilder{

    private static final long serialVersionUID = 0L;

    // Use AverageResponse.newBuilder() to construct.
    private AverageResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }
    private AverageResponse() {
        avgRes_ = "";
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
        return this.unknownFields;
    }
    private AverageResponse(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        this();
        if (extensionRegistry == null) {
            throw new java.lang.NullPointerException();
        }
        int mutable_bitField0_ = 0;
        com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                com.google.protobuf.UnknownFieldSet.newBuilder();
        try {
            boolean done = false;
            while (!done) {
                int tag = input.readTag();
                switch (tag) {
                    case 0:
                        done = true;
                        break;
                    case 10: {
                        java.lang.String s = input.readStringRequireUtf8();
                        avgRes_ = s;
                        break;
                    }
                    default: {
                        if (!parseUnknownFieldProto3(
                                input, unknownFields, extensionRegistry, tag)) {
                            done = true;
                        }
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
            this.unknownFields = unknownFields.build();
            makeExtensionsImmutable();
        }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
    getDescriptor() {
        return Usage.UsageImpl.internal_static_SmartEnergy_AverageResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
    internalGetFieldAccessorTable() {
        return Usage.UsageImpl.internal_static_SmartEnergy_AverageResponse_fieldAccessorTable
                .ensureFieldAccessorsInitialized(
                        Usage.AverageResponse.class, Usage.AverageResponse.Builder.class);
    }

    public static final int AVG_RES_FIELD_NUMBER = 1;
    private volatile java.lang.Object avgRes_;
    /**
     * <code> string avgRes = 1;</code>
     */
    public java.lang.String getAvgRes() {
        java.lang.Object ref = avgRes_;
        if (ref instanceof java.lang.String) {
            return (java.lang.String) ref;
        } else {
            com.google.protobuf.ByteString bs =
                    (com.google.protobuf.ByteString) ref;
            java.lang.String s = bs.toStringUtf8();
            avgRes_ = s;
            return s;
        }
    }

    /**
     * <code> string avgRes = 1;</code>
     */
    public com.google.protobuf.ByteString
    getAvgResBytes() {
        java.lang.Object ref = avgRes_;
        if (ref instanceof java.lang.String) {
            com.google.protobuf.ByteString b =
                    com.google.protobuf.ByteString.copyFromUtf8(
                            (java.lang.String) ref);
            avgRes_ = b;
            return b;
        } else {
            return (com.google.protobuf.ByteString) ref;
        }
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
        byte isInitialized = memoizedIsInitialized;
        if (isInitialized == 1) return true;
        if (isInitialized == 0) return false;
        memoizedIsInitialized = 1;
        return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
            throws java.io.IOException {
        if (!getAvgResBytes().isEmpty()) {
            com.google.protobuf.GeneratedMessageV3.writeString(output, 1, avgRes_);
        }
        unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
        int size = memoizedSize;
        if (size != -1) return size;
        size = 0;
        if (!getAvgResBytes().isEmpty()) {
            size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, avgRes_);
        }
        size += unknownFields.getSerializedSize();
        memoizedSize = size;
        return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Usage.AverageResponse)) {
            return super.equals(obj);
        }
        Usage.AverageResponse other = (Usage.AverageResponse) obj;

        boolean result = true;
        result = result && getAvgRes()
                .equals(other.getAvgRes());
        result = result && unknownFields.equals(other.unknownFields);
        return result;
    }

    @java.lang.Override
    public int hashCode() {
        if (memoizedHashCode != 0) {
            return memoizedHashCode;
        }
        int hash = 41;
        hash = (19 * hash) + getDescriptor().hashCode();
        hash = (37 * hash) + AVG_RES_FIELD_NUMBER;
        hash = (53 * hash) + getAvgRes().hashCode();
        hash = (29 * hash) + unknownFields.hashCode();
        memoizedHashCode = hash;
        return hash;
    }

    public static Usage.AverageResponse parseFrom(
            java.nio.ByteBuffer data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }
    public static Usage.AverageResponse parseFrom(
            java.nio.ByteBuffer data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Usage.AverageResponse parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }
    public static Usage.AverageResponse parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Usage.AverageResponse parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }
    public static Usage.AverageResponse parseFrom(
            byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Usage.AverageResponse parseFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }
    public static Usage.AverageResponse parseFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static Usage.AverageResponse parseDelimitedFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input);
    }
    public static Usage.AverageResponse parseDelimitedFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static Usage.AverageResponse parseFrom(
            com.google.protobuf.CodedInputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }
    public static Usage.AverageResponse parseFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(Usage.AverageResponse prototype) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
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
     * <pre>
     *  Usage Service Definition
     * </pre>
     *
     * Protobuf type {@code SmartEnergy.AverageResponse}
     */
    public static final class Builder extends
            com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
            // @@protoc_insertion_point(builder_implements:SmartEnergy.AverageResponse)
            Usage.AverageResponseOrBuilder {
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return Usage.UsageImpl.internal_static_SmartEnergy_AverageResponse_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return Usage.UsageImpl.internal_static_SmartEnergy_AverageResponse_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            Usage.AverageResponse.class, Usage.AverageResponse.Builder.class);
        }

        // Construct using Usage.AverageResponse.newBuilder()
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
        @java.lang.Override
        public Builder clear() {
            super.clear();
            avgRes_ = "";
            return this;
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
            return Usage.UsageImpl.internal_static_SmartEnergy_AverageResponse_descriptor;
        }

        @java.lang.Override
        public Usage.AverageResponse getDefaultInstanceForType() {
            return Usage.AverageResponse.getDefaultInstance();
        }

        @java.lang.Override
        public Usage.AverageResponse build() {
            Usage.AverageResponse result = buildPartial();
            if (!result.isInitialized()) {
                throw newUninitializedMessageException(result);
            }
            return result;
        }

        @java.lang.Override
        public Usage.AverageResponse buildPartial() {
            Usage.AverageResponse result = new Usage.AverageResponse(this);
            result.avgRes_ = avgRes_;
            onBuilt();
            return result;
        }

        @java.lang.Override
        public Builder clone() {
            return (Builder) super.clone();
        }
        @java.lang.Override
        public Builder setField(
                com.google.protobuf.Descriptors.FieldDescriptor field,
                java.lang.Object value) {
            return (Builder) super.setField(field, value);
        }
        @java.lang.Override
        public Builder clearField(
                com.google.protobuf.Descriptors.FieldDescriptor field) {
            return (Builder) super.clearField(field);
        }
        @java.lang.Override
        public Builder clearOneof(
                com.google.protobuf.Descriptors.OneofDescriptor oneof) {
            return (Builder) super.clearOneof(oneof);
        }
        @java.lang.Override
        public Builder setRepeatedField(
                com.google.protobuf.Descriptors.FieldDescriptor field,
                int index, java.lang.Object value) {
            return (Builder) super.setRepeatedField(field, index, value);
        }
        @java.lang.Override
        public Builder addRepeatedField(
                com.google.protobuf.Descriptors.FieldDescriptor field,
                java.lang.Object value) {
            return (Builder) super.addRepeatedField(field, value);
        }
        @java.lang.Override
        public Builder mergeFrom(com.google.protobuf.Message other) {
            if (other instanceof Usage.AverageResponse) {
                return mergeFrom((Usage.AverageResponse)other);
            } else {
                super.mergeFrom(other);
                return this;
            }
        }

        public Builder mergeFrom(Usage.AverageResponse other) {
            if (other == Usage.AverageResponse.getDefaultInstance()) return this;
            if (!other.getAvgRes().isEmpty()) {
                avgRes_ = other.avgRes_;
                onChanged();
            }
            this.mergeUnknownFields(other.unknownFields);
            onChanged();
            return this;
        }

        @java.lang.Override
        public final boolean isInitialized() {
            return true;
        }

        @java.lang.Override
        public Builder mergeFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            Usage.AverageResponse parsedMessage = null;
            try {
                parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                parsedMessage = (Usage.AverageResponse) e.getUnfinishedMessage();
                throw e.unwrapIOException();
            } finally {
                if (parsedMessage != null) {
                    mergeFrom(parsedMessage);
                }
            }
            return this;
        }

        private java.lang.Object avgRes_ = "";

        /**
         * <code> string avgRes = 1;</code>
         */
        public java.lang.String getAvgRes() {
            java.lang.Object ref = avgRes_;
            if (!(ref instanceof java.lang.String)) {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                avgRes_ = s;
                return s;
            } else {
                return (java.lang.String) ref;
            }
        }

        /**
         * <code> string avgRes = 1;</code>
         */
        public com.google.protobuf.ByteString
        getAvgResBytes() {
            java.lang.Object ref = avgRes_;
            if (ref instanceof String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                avgRes_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        /**
         * <code> string avgRes = 1;</code>
         */
        public Builder setAvgRes(
                java.lang.String value) {
            if (value == null) {
                throw new NullPointerException();
            }

            avgRes_ = value;
            onChanged();
            return this;
        }

        /**
         * <code> string avgRes = 1;</code>
         */
        public Builder clearAvgRes() {
            avgRes_ = getDefaultInstance().getAvgRes();
            onChanged();
            return this;
        }

        /**
         * <code> string avgRes = 1;</code>
         */
        public Builder setAvgResBytes(
                com.google.protobuf.ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            checkByteStringIsUtf8(value);
            avgRes_ = value;
            onChanged();
            return this;
        }
        @java.lang.Override
        public final Builder setUnknownFields(
                final com.google.protobuf.UnknownFieldSet unknownFields) {
            return super.setUnknownFieldsProto3(unknownFields);
        }

        @java.lang.Override
        public final Builder mergeUnknownFields(
                final com.google.protobuf.UnknownFieldSet unknownFields) {
            return super.mergeUnknownFields(unknownFields);
        }

        // @@protoc_insertion_point(builder_scope:SmartEnergy.AverageResponse)
    }

    // @@protoc_insertion_point(class_scope:SmartEnergy.AverageResponse)
    private static final Usage.AverageResponse DEFAULT_INSTANCE;
    static {
        DEFAULT_INSTANCE = new Usage.AverageResponse();
    }

    public static Usage.AverageResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<AverageResponse>
            PARSER = new com.google.protobuf.AbstractParser<AverageResponse>() {
        @java.lang.Override
        public AverageResponse parsePartialFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return new AverageResponse(input, extensionRegistry);
        }
    };

    public static com.google.protobuf.Parser<AverageResponse> parser() {
        return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<AverageResponse> getParserForType() {
        return PARSER;
    }

    @java.lang.Override
    public Usage.AverageResponse getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

}