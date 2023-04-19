package Temperature;

import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;

/**
 * <pre>
 * Temperature Service Definition
 * </pre>
 */
@javax.annotation.Generated(
        value = "by gRPC proto compiler (version 1.15.0)",
        comments = "Source: temperature.proto")

public final class TemperatureServiceGrpc {

    private TemperatureServiceGrpc() {}

    public static final String SERVICE_NAME = "SmartEnergy.TemperatureService";

    // Static method descriptors that strictly reflect the proto.
    private static volatile io.grpc.MethodDescriptor<Temperature.TempStatusRequest,
            Temperature.TempStatusResponse> getTemperatureMethod;

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "Temperature",
            requestType = Temperature.TempStatusRequest.class,
            responseType = Temperature.TempStatusResponse.class,
            methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
    public static io.grpc.MethodDescriptor<Temperature.TempStatusRequest,
            Temperature.TempStatusResponse> getTemperatureMethod() {
        io.grpc.MethodDescriptor<Temperature.TempStatusRequest, Temperature.TempStatusResponse> getTemperatureMethod;
        if ((getTemperatureMethod = TemperatureServiceGrpc.getTemperatureMethod) == null) {
            synchronized (TemperatureServiceGrpc.class) {
                if ((getTemperatureMethod = TemperatureServiceGrpc.getTemperatureMethod) == null) {
                    TemperatureServiceGrpc.getTemperatureMethod = getTemperatureMethod =
                            io.grpc.MethodDescriptor.<Temperature.TempStatusRequest, Temperature.TempStatusResponse>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
                                    .setFullMethodName(generateFullMethodName(
                                            "SmartEnergy.TemperatureService", "Temperature"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            Temperature.TempStatusRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            Temperature.TempStatusResponse.getDefaultInstance()))
                                    .setSchemaDescriptor(new TemperatureServiceBlockingStub.TemperatureServiceMethodDescriptorSupplier("Temperature"))
                                    .build();
                }
            }
        }
        return getTemperatureMethod;
    }

    /**
     * Creates a new async stub that supports all call types for the service
     */
    public static TemperatureServiceStub newStub(io.grpc.Channel channel) {
        return new TemperatureServiceStub(channel);
    }

    /**
     * Creates a new blocking-style stub that supports unary and streaming output calls on the service
     */
    public static TemperatureServiceBlockingStub newBlockingStub(
            io.grpc.Channel channel) {
        return new TemperatureServiceBlockingStub(channel);
    }

    /**
     * Creates a new ListenableFuture-style stub that supports unary calls on the service
     */
    public static TemperatureServiceBlockingStub.TemperatureServiceFutureStub newFutureStub(
            io.grpc.Channel channel) {
        return new TemperatureServiceBlockingStub.TemperatureServiceFutureStub(channel);
    }

    /**
     * <pre>
     * Temperature Service Definition
     * </pre>
     */

    public static abstract class TemperatureServiceImplBase implements io.grpc.BindableService {

        /**
         * <pre>
         * Server Stream
         * </pre>
         */

        // temperature Method
        public void temperature(Temperature.TempStatusRequest request,
                                     io.grpc.stub.StreamObserver<Temperature.TempStatusResponse> responseObserver) {
            Temperature.TempStatusResponse response = Temperature.TempStatusResponse.newBuilder()
                    // Replace with the current temperature
                    .setTempCurr(20.0)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
        return io.grpc.ServerServiceDefinition.builder(TemperatureServiceBlockingStub.getServiceDescriptor())
                .addMethod(
                        getTemperatureMethod(),
                        asyncServerStreamingCall(
                                new TemperatureServiceBlockingStub.MethodHandlers<
                                                                        TempStatusRequest,
                                                                        TempStatusResponse>(
                                        this, TemperatureServiceBlockingStub.METHODID_TEMPERATURE)))
                .build();
    }
}

    /**
     * <pre>
     * Temperature Service Definition
     * </pre>
     */
    public static final class TemperatureServiceStub extends io.grpc.stub.AbstractStub<TemperatureServiceStub> {
        private TemperatureServiceStub(io.grpc.Channel channel) {
            super(channel);
        }

        private TemperatureServiceStub(io.grpc.Channel channel,
                                  io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected TemperatureServiceStub build(io.grpc.Channel channel,
                                          io.grpc.CallOptions callOptions) {
            return new TemperatureServiceStub(channel, callOptions);
        }

        /**
         * <pre>
         * Server Stream
         * </pre>
         */
        public void temperature(TempStatusRequest request, StreamObserver<TempStatusResponse> responseObserver) {
            asyncServerStreamingCall(getChannel().newCall(getTemperatureMethod(), getCallOptions()), request, responseObserver);
        }
    }

    /**
     * <pre>
     * Temperature Service Definition
     * </pre>
     */
    public static final class TemperatureServiceBlockingStub extends io.grpc.stub.AbstractStub<TemperatureServiceBlockingStub> {
        private TemperatureServiceBlockingStub(io.grpc.Channel channel) {
            super(channel);
        }

        private TemperatureServiceBlockingStub(io.grpc.Channel channel,
                                          io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected TemperatureServiceBlockingStub build(io.grpc.Channel channel,
                                                  io.grpc.CallOptions callOptions) {
            return new TemperatureServiceBlockingStub(channel, callOptions);
        }

        /**
         * <pre>
         * Server Stream
         * </pre>
         */
        public TempStatusResponse temperature(TempStatusRequest request) {
            try {
                TemperatureServiceBlockingStub blockingStub =
                        TemperatureServiceGrpc.newBlockingStub(getChannel());

                return blockingStub.temperature(request);
            } catch (StatusRuntimeException e) {
                // Handle the exception here
                System.err.println("RPC failed: " + e.getStatus());
                return null;
            }
        }

        /**
     * <pre>
     * Temperature Service Definition
     * </pre>
     */
    public static final class TemperatureServiceFutureStub extends io.grpc.stub.AbstractStub<TemperatureServiceFutureStub> {
        private TemperatureServiceFutureStub(io.grpc.Channel channel) {
            super(channel);
        }

        private TemperatureServiceFutureStub(io.grpc.Channel channel,
                                        io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected TemperatureServiceFutureStub build(io.grpc.Channel channel,
                                                io.grpc.CallOptions callOptions) {
            return new TemperatureServiceFutureStub(channel, callOptions);
        }
    }

    private static final int METHODID_TEMPERATURE = 0;

    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final TemperatureServiceImplBase serviceImpl;
        private final int methodId;

        MethodHandlers(TemperatureServiceImplBase serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_TEMPERATURE:
                    serviceImpl.temperature((Temperature.TempStatusRequest) request,
                            (io.grpc.stub.StreamObserver<Temperature.TempStatusResponse>) responseObserver);
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

    private static abstract class TemperatureServiceBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
        TemperatureServiceBaseDescriptorSupplier() {}

        @java.lang.Override
        public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
            return Temperature.TemperatureServiceImpl.getDescriptor();
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("Temperature");
        }
    }

    private static final class TemperatureServiceFileDescriptorSupplier
            extends TemperatureServiceBaseDescriptorSupplier {
        TemperatureServiceFileDescriptorSupplier() {}
    }

    private static final class TemperatureServiceMethodDescriptorSupplier
            extends TemperatureServiceBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
        private final String methodName;

        TemperatureServiceMethodDescriptorSupplier(String methodName) {
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
            synchronized (TemperatureServiceGrpc.class) {
                result = serviceDescriptor;
                if (result == null) {
                    serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                            .setSchemaDescriptor(new TemperatureServiceFileDescriptorSupplier())
                            .addMethod(getTemperatureMethod())
                            .build();
                }
            }
        }
        return result;
         }
    }
}