// Generated by the protocol buffer compiler.  DO NOT EDIT!
// Source: temperature.proto

package Temperature;

import io.grpc.ServerBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.Descriptors;

/**
 *  <pre>
 *   Temperature Service Definition
  * </pre>
 *
 * Protobuf type {@code SmartEnergy.TempStatusResponse}
 */

public final class TempStatusResponse extends
        com.google.protobuf.GeneratedMessageV3 implements
        TempStatusResponseOrBuilder {
    private static final long serialVersionUID = 0L;

    // Use TempStatusResponse.newBuilder() to construct.
    private TempStatusResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }
    private TempStatusResponse() {
        tempCurr_ = 0D;
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
        return this.unknownFields;
    }
    private TempStatusResponse(
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
                    case 9: {
                        tempCurr_  = input.readDouble();
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
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return Temperature.TemperatureServiceImpl.internal_static_SmartEnergy_TempStatusResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return TemperatureServiceImpl.internal_static_SmartEnergy_TempStatusResponse_fieldAccessorTable
                .ensureFieldAccessorsInitialized(
                        Temperature.TempStatusResponse.class, Temperature.TempStatusResponse.Builder.class);
    }

    public static final int TEMP_CURR_FIELD_NUMBER = 1;
    private double tempCurr_;

    /**
     * <code> double tempCurr = 1; </code>
     */
    public double getTempCurr() {
        return tempCurr_ ;
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
        if (tempCurr_ != 0D) {
            output.writeDouble(1, tempCurr_ );
        }
        unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
        int size = memoizedSize;
        if (size != -1) return size;
        size = 0;
        if (tempCurr_ != 0D) {
            size += com.google.protobuf.CodedOutputStream
                    .computeDoubleSize(1, tempCurr_ );
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
        if (!(obj instanceof Temperature.TempStatusResponse)) {
            return super.equals(obj);
        }
        Temperature.TempStatusResponse other = (Temperature.TempStatusResponse) obj;
        boolean result = true;
        result = result && (
                java.lang.Double.doubleToLongBits(getTempCurr())
                        == java.lang.Double.doubleToLongBits(
                        other.getTempCurr()));
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
        hash = (37 * hash) + TEMP_CURR_FIELD_NUMBER;
        hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                java.lang.Double.doubleToLongBits(getTempCurr()));
        hash = (29 * hash) + unknownFields.hashCode();
        memoizedHashCode = hash;
        return hash;
    }

    public static Temperature.TempStatusResponse parseFrom(
            java.nio.ByteBuffer data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }
    public static Temperature.TempStatusResponse parseFrom(
            java.nio.ByteBuffer data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Temperature.TempStatusResponse parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }
    public static Temperature.TempStatusResponse parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Temperature.TempStatusResponse parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }
    public static Temperature.TempStatusResponse parseFrom(
            byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Temperature.TempStatusResponse parseFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }
    public static Temperature.TempStatusResponse parseFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static Temperature.TempStatusResponse parseDelimitedFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input);
    }
    public static Temperature.TempStatusResponse parseDelimitedFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static Temperature.TempStatusResponse parseFrom(
            com.google.protobuf.CodedInputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }
    public static Temperature.TempStatusResponse parseFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() {
        return newBuilder();
    }
    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(Temperature.TempStatusResponse prototype) {
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

    @Override
    public double tempCurr() {
        return 0;
    }

    /**
     * Protobuf type {@code SmartEnergy.TempStatusResponse}
     */
    public static final class Builder extends
            com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
            // @@protoc_insertion_point(builder_implements:SmartEnergy.TempStatusResponse)
            TempStatusResponseOrBuilder {
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return TemperatureServiceImpl.internal_static_SmartEnergy_TempStatusResponse_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return TemperatureServiceImpl.internal_static_SmartEnergy_TempStatusResponse_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(Temperature.TempStatusResponse.class, Temperature.TempStatusResponse.Builder.class);
        }

        // Construct using Temperature.TempStatusResponse.newBuilder()
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
            tempCurr_  = 0D;
            return this;
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
            return Temperature.TemperatureServiceImpl.internal_static_SmartEnergy_TempStatusResponse_descriptor;
        }

        @java.lang.Override
        public Temperature.TempStatusResponse getDefaultInstanceForType() {
            return Temperature.TempStatusResponse.getDefaultInstance();
        }

        @java.lang.Override
        public Temperature.TempStatusResponse build() {
            Temperature.TempStatusResponse result = buildPartial();
            if (!result.isInitialized()) {
                throw newUninitializedMessageException(result);
            }
            return result;
        }

        @java.lang.Override
        public Temperature.TempStatusResponse buildPartial() {
            Temperature.TempStatusResponse result = new Temperature.TempStatusResponse(this);
            result. tempCurr_=  tempCurr_;
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
            if (other instanceof Temperature.TempStatusResponse) {
                return mergeFrom((Temperature.TempStatusResponse)other);
            } else {
                super.mergeFrom(other);
                return this;
            }
        }

        public Builder mergeFrom(Temperature.TempStatusResponse other) {
            if (other == Temperature.TempStatusResponse.getDefaultInstance()) return this;
            if (other.getTempCurr() != 0D) {
                setTempCurr(other.getTempCurr());
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
            Temperature.TempStatusResponse parsedMessage = null;
            try {
                parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                parsedMessage = (Temperature.TempStatusResponse) e.getUnfinishedMessage();
                throw e.unwrapIOException();
            } finally {
                if (parsedMessage != null) {
                    mergeFrom(parsedMessage);
                }
            }
            return this;
        }

        private double tempCurr_ ;

        /**
         * <code> double tempCurr = 1; </code>
         */
        public double getTempCurr() {
            return tempCurr_ ;
        }
        /**
         * <code> double tempCurr = 1; </code>
         */
        public Builder setTempCurr(double value) {
            tempCurr_ = value;
            onChanged();
            return this;
        }

        /**
         * <code> double tempCurr = 1; </code>
         */
        public Builder clearTempCurr() {
            tempCurr_  = 0D;
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

        @Override
        public double tempCurr() {
            return 0;
        }
        // @@protoc_insertion_point(builder_scope:SmartEnergy.TempStatusResponse)
    }

    // @@protoc_insertion_point(class_scope:SmartEnergy.TempStatusResponse)
    private static final Temperature.TempStatusResponse DEFAULT_INSTANCE;
    static {
        DEFAULT_INSTANCE = new Temperature.TempStatusResponse();
    }

    public static Temperature.TempStatusResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<TempStatusResponse>
            PARSER = new com.google.protobuf.AbstractParser<TempStatusResponse>() {
        @java.lang.Override
        public TempStatusResponse parsePartialFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return new TempStatusResponse(input, extensionRegistry);
        }
    };

    public static com.google.protobuf.Parser<TempStatusResponse> parser() {
        return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<TempStatusResponse> getParserForType() {
        return PARSER;
    }

    @java.lang.Override
    public Temperature.TempStatusResponse getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}

