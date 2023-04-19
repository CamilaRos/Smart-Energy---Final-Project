package Setting;

import Temperature.TempStatusRequest;
import Temperature.TempStatusResponse;
import Temperature.TemperatureServiceGrpc;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Setting Service Definition
 * </pre>
 */
@javax.annotation.Generated(
        value = "by gRPC proto compiler (version 1.15.0)",
        comments = "Source: setting.proto")

public final class SettingServiceGrpc {

    private SettingServiceGrpc() {}
    public static final String SERVICE_NAME = "SmartEnergy.SettingService";

    // Static method descriptors that strictly reflect the proto.
    private static volatile io.grpc.MethodDescriptor<Setting.TempReadRequest,
            Setting.TempSetResponse> getSettingMethod;

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "Setting",
            requestType = Setting.TempReadRequest.class,
            responseType = Setting.TempSetResponse.class,
            methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
    public static io.grpc.MethodDescriptor<Setting.TempReadRequest,
            Setting.TempSetResponse> getSettingMethod() {
        io.grpc.MethodDescriptor<Setting.TempReadRequest, Setting.TempSetResponse> getSettingMethod;
        if ((getSettingMethod = SettingServiceGrpc.getSettingMethod) == null) {
            synchronized (SettingServiceGrpc.class) {
                if ((getSettingMethod = SettingServiceGrpc.getSettingMethod) == null) {
                    SettingServiceGrpc.getSettingMethod = getSettingMethod =
                            io.grpc.MethodDescriptor.<Setting.TempReadRequest, Setting.TempSetResponse>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
                                    .setFullMethodName(generateFullMethodName(
                                            "SmartEnergy.SettingService", "Setting"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            Setting.TempReadRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            Setting.TempSetResponse.getDefaultInstance()))
                                    .setSchemaDescriptor(new SettingServiceMethodDescriptorSupplier("Setting"))
                                    .build();
                }
            }
        }
        return getSettingMethod;
    }
    /**
     * Creates a new async stub that supports all call types for the service
     */
    public static SettingServiceStub newStub(io.grpc.Channel channel) {
        return new SettingServiceStub(channel);
    }

    /**
     * Creates a new blocking-style stub that supports unary and streaming output calls on the service
     */
    public static SettingServiceBlockingStub newBlockingStub(
            io.grpc.Channel channel) {
        return new SettingServiceBlockingStub(channel);
    }

    /**
     * Creates a new ListenableFuture-style stub that supports unary calls on the service
     */
    public static SettingServiceFutureStub newFutureStub(
            io.grpc.Channel channel) {
        return new SettingServiceFutureStub(channel);
    }

    /**
     *  <pre>
     * Setting Service Definition
     * </pre>
     */
    public static abstract class SettingServiceImplBase implements io.grpc.BindableService {

        /**
         * <pre>
         * Client Streaming
         * </pre>
         */
        public io.grpc.stub.StreamObserver<Setting.TempReadRequest> tempReading(
                io.grpc.stub.StreamObserver<Setting.TempSetResponse> responseObserver) {
            return asyncUnimplementedStreamingCall(getSettingMethod(), responseObserver);
        }

        @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            getSettingMethod(),
                            asyncClientStreamingCall(
                                    new MethodHandlers<
                                            Setting.TempReadRequest,
                                            Setting.TempSetResponse>(
                                            this, METHODID_SETTING)))
                    .build();
        }

        public void setting(TempReadRequest request, StreamObserver<TempSetResponse> responseObserver) {
            double currentTemp = request.getTempReading();
            double newSetPoint = calculateNewSetPoint(currentTemp);
            TempSetResponse response = TempSetResponse.newBuilder()
                    .setNewSetPoint(newSetPoint)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        // Calculate the setpoint
        private double calculateNewSetPoint(double currentTemp) {
            return currentTemp + 2.0;
        }
    }

    /**
     *  <pre>
     * Setting Service Definition
     * </pre>
     */
    public static final class SettingServiceStub extends io.grpc.stub.AbstractStub<SettingServiceStub> {
        private SettingServiceStub(io.grpc.Channel channel) {
            super(channel);
        }

        private SettingServiceStub(io.grpc.Channel channel,
                                 io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected SettingServiceStub build(io.grpc.Channel channel,
                                         io.grpc.CallOptions callOptions) {
            return new SettingServiceStub(channel, callOptions);
        }

        /**
         * <pre>
         * Client Streaming
         * </pre>
         */
        public io.grpc.stub.StreamObserver<Setting.TempReadRequest> tempReading(
                io.grpc.stub.StreamObserver<Setting.TempSetResponse> responseObserver) {
            return asyncClientStreamingCall(
                    getChannel().newCall(getSettingMethod(), getCallOptions()), responseObserver);
        }

        public StreamObserver<TempReadRequest>setting(StreamObserver<TempSetResponse> tempSetResponseStreamObserver) {
            return new StreamObserver<TempReadRequest>() {
                @Override
                public void onNext(TempReadRequest tempReadRequest) {
                    double currentTemp = tempReadRequest.getTempReading();
                    double newSetPoint = calculateNewSetPoint(currentTemp);
                    TempSetResponse response = TempSetResponse.newBuilder()
                            .setNewSetPoint(newSetPoint)
                            .build();
                    tempSetResponseStreamObserver.onNext(response);
                }

                private double calculateNewSetPoint(double currentTemp) {
                    // Add 2 degrees to the current temperature to get the new set point
                    return currentTemp + 2.0;
                }

                @Override
                public void onError(Throwable throwable) {
                    // Handle error
                }

                @Override
                public void onCompleted() {
                    tempSetResponseStreamObserver.onCompleted();
                }
            };
        }
    }

    /**
     * <pre>
     * Setting Service Definition
     * </pre>
     */
    public static final class SettingServiceBlockingStub extends io.grpc.stub.AbstractStub<SettingServiceBlockingStub> {
        private SettingServiceBlockingStub(io.grpc.Channel channel) {
            super(channel);
        }

        private SettingServiceBlockingStub(io.grpc.Channel channel,
                                         io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected SettingServiceBlockingStub build(io.grpc.Channel channel,
                                                 io.grpc.CallOptions callOptions) {
            return new SettingServiceBlockingStub(channel, callOptions);
        }

        public TempSetResponse setting(TempReadRequest request) {
            try {
                SettingServiceGrpc.SettingServiceBlockingStub blockingStub =
                        SettingServiceGrpc.newBlockingStub(getChannel());
                return blockingStub.setting(request);
            } catch (StatusRuntimeException e) {
                // Handle the exception here
                System.err.println("RPC failed: " + e.getStatus());
                return null;
            }
        }
    }

    /**
     *  <pre>
     * Setting Service Definition
     * </pre>
     */
    public static final class SettingServiceFutureStub extends io.grpc.stub.AbstractStub<SettingServiceFutureStub> {
        private SettingServiceFutureStub(io.grpc.Channel channel) {
            super(channel);
        }

        private SettingServiceFutureStub(io.grpc.Channel channel,
                                       io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected SettingServiceFutureStub build(io.grpc.Channel channel,
                                               io.grpc.CallOptions callOptions) {
            return new SettingServiceFutureStub(channel, callOptions);
        }
    }

    private static final int METHODID_SETTING = 0;

    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final SettingServiceImplBase serviceImpl;
        private final int methodId;

        MethodHandlers(SettingServiceImplBase serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_SETTING:
                    serviceImpl.setting((Setting.TempReadRequest) request,
                            (io.grpc.stub.StreamObserver<TempSetResponse>) responseObserver);
                    break;
                default:
                    throw new AssertionError();
            }
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public io.grpc.stub.StreamObserver<Req> invoke(
                io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                default:
                    throw new AssertionError();
            }
        }
    }

    private static abstract class SettingServiceBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
        SettingServiceBaseDescriptorSupplier() {}

        @java.lang.Override
        public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
            return Setting.SettingServiceImpl.getDescriptor();
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("SettingService");
        }
    }

    private static final class SettingServiceFileDescriptorSupplier
            extends SettingServiceBaseDescriptorSupplier {
        SettingServiceFileDescriptorSupplier() {}
    }

    private static final class SettingServiceMethodDescriptorSupplier
            extends SettingServiceBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
        private final String methodName;

        SettingServiceMethodDescriptorSupplier(String methodName) {
            this.methodName = methodName;
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
            return getServiceDescriptor().findMethodByName(methodName);
        }
    }

    private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

    public static io.grpc.ServiceDescriptor getServiceDescriptor() {
        io.grpc.ServiceDescriptor result = serviceDescriptor;
        if (result == null) {
            synchronized (SettingServiceGrpc.class) {
                result = serviceDescriptor;
                if (result == null) {
                    serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                            .setSchemaDescriptor(new SettingServiceFileDescriptorSupplier())
                            .addMethod(getSettingMethod())
                            .build();
                }
            }
        }
        return result;
    }
}


