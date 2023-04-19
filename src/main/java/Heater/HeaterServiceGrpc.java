package Heater;

import io.grpc.stub.StreamObserver;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;


/**
 * <pre>
 * Heater Service Definition
 * </pre>
 */

@javax.annotation.Generated(
        value = "by gRPC proto compiler",
        comments = "Source: heater.proto")

public final class HeaterServiceGrpc {

    private HeaterServiceGrpc() {}

    public static final String SERVICE_NAME = "SmartEnergy.HeaterService";

    // Static method descriptors that strictly reflect the proto.
    private static volatile io.grpc.MethodDescriptor<Heater.TemperatureRequest,
            Heater.TemperatureResponse> getHeaterMethod;

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "Heater",
            requestType = Heater.TemperatureRequest.class,
            responseType = Heater.TemperatureResponse.class,
            methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<Heater.TemperatureRequest,
            Heater.TemperatureResponse> getHeaterMethod() {
        io.grpc.MethodDescriptor<Heater.TemperatureRequest, Heater.TemperatureResponse> getHeaterMethod;
        if ((getHeaterMethod = HeaterServiceGrpc.getHeaterMethod) == null) {
            synchronized (HeaterServiceGrpc.class) {
                if ((getHeaterMethod = HeaterServiceGrpc.getHeaterMethod) == null) {
                    HeaterServiceGrpc.getHeaterMethod = getHeaterMethod =
                            io.grpc.MethodDescriptor.<Heater.TemperatureRequest, Heater.TemperatureResponse>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                                    .setFullMethodName(generateFullMethodName(
                                            "SmartEnergy.HeaterService", "Heater"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            Heater.TemperatureRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            Heater.TemperatureResponse.getDefaultInstance()))
                                    .setSchemaDescriptor(new HeaterServiceMethodDescriptorSupplier("Heater"))
                                    .build();
                    }
                }
            }
            return getHeaterMethod;
        }

        /**
         * Creates a new async stub that supports all call types for the service
         */
        public static HeaterServiceStub newStub(io.grpc.Channel channel) {
            return new HeaterServiceStub(channel);
        }

        /**
         * Creates a new blocking-style stub that supports unary and streaming output calls on the service
         */
        public static HeaterServiceBlockingStub newBlockingStub(
                io.grpc.Channel channel) {
            return new HeaterServiceBlockingStub(channel);
        }

        /**
         * Creates a new ListenableFuture-style stub that supports unary calls on the service
         */
        public static HeaterServiceFutureStub newFutureStub(
                io.grpc.Channel channel) {
            return new HeaterServiceFutureStub(channel);
        }

        /**
         * <pre>
         *  Heater Service Definition
         * </pre>
         */
        public static abstract class HeaterServiceImplBase implements io.grpc.BindableService {

            /**
             * <pre>
             * Unary
             * </pre>
             */
            public void heater(Heater.TemperatureRequest request,
                                       io.grpc.stub.StreamObserver<Heater.TemperatureResponse> responseObserver) {
                asyncUnimplementedUnaryCall(getHeaterMethod(), responseObserver);
            }

            @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
                return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                        .addMethod(
                                getHeaterMethod(),
                                asyncUnaryCall(new MethodHandlers<
                                                Heater.TemperatureRequest,
                                                Heater.TemperatureResponse>(
                                                this, METHODID_HEATER)))
                        .build();
            }
        }
            // HeaterServer Implementation

        /**
         * <pre>
         *  Heater Service Definition
         * </pre>
         */
        public static final class HeaterServiceStub extends io.grpc.stub.AbstractStub<HeaterServiceStub> {
            private HeaterServiceStub(io.grpc.Channel channel) {
                super(channel);
            }

            private HeaterServiceStub(io.grpc.Channel channel,
                                      io.grpc.CallOptions callOptions) {
                super(channel, callOptions);
            }

            @java.lang.Override
            protected HeaterServiceStub build(io.grpc.Channel channel,
                                              io.grpc.CallOptions callOptions) {
                return new HeaterServiceStub(channel, callOptions);
            }

            /**
             * <pre>
             * Unary
             * </pre>
             */
            public void turnOn(Heater.TemperatureRequest request,
                               io.grpc.stub.StreamObserver<Heater.TemperatureResponse> responseObserver) {
                asyncUnaryCall(
                        getChannel().newCall(getHeaterMethod(), getCallOptions()), request, responseObserver);
            }
        }

    /**
     * <pre>
     *  Heater Service Definition
     * </pre>
     */
    public static final class HeaterServiceBlockingStub extends io.grpc.stub.AbstractStub<HeaterServiceBlockingStub> {
        private HeaterServiceBlockingStub(io.grpc.Channel channel) {
            super(channel);
        }

        private HeaterServiceBlockingStub(io.grpc.Channel channel,
                                          io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected HeaterServiceBlockingStub build(io.grpc.Channel channel,
                                                  io.grpc.CallOptions callOptions) {
            return new HeaterServiceBlockingStub(channel, callOptions);
        }

        /**
         * <pre>
         * Unary
         * </pre>
         */
        public TemperatureResponse heater(TemperatureRequest request) {
            return blockingUnaryCall(
                    getChannel(), getHeaterMethod(), getCallOptions(), request);
        }
    }

    /**
     * <pre>
     *  Heater Service Definition
     * </pre>
     */
    public static final class HeaterServiceFutureStub extends io.grpc.stub.AbstractStub<HeaterServiceFutureStub> {
        private HeaterServiceFutureStub(io.grpc.Channel channel) {
            super(channel);
        }

        private HeaterServiceFutureStub(io.grpc.Channel channel,
                                        io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected HeaterServiceFutureStub build(io.grpc.Channel channel,
                                                io.grpc.CallOptions callOptions) {
            return new HeaterServiceFutureStub(channel, callOptions);
        }

        /**
         * <pre>
         * Unary
         * </pre>
         */
        public com.google.common.util.concurrent.ListenableFuture<Heater.TemperatureResponse> HeaterService(
                Heater.TemperatureRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(getHeaterMethod(), getCallOptions()), request);
        }
    }

    private static final int METHODID_HEATER = 0;

    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final HeaterServiceImplBase serviceImpl;
        private final int methodId;

        MethodHandlers(HeaterServiceImplBase serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_HEATER:
                    serviceImpl.heater((Heater.TemperatureRequest) request,
                            (io.grpc.stub.StreamObserver<TemperatureResponse>) responseObserver);
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

    private static abstract class HeaterServiceImplBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
        HeaterServiceImplBaseDescriptorSupplier() {}

        @java.lang.Override
        public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
            return Heater.HeaterServiceImpl.getDescriptor();
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("Heater");
        }
    }

    private static final class HeaterServiceFileDescriptorSupplier
            extends HeaterServiceImplBaseDescriptorSupplier {
        HeaterServiceFileDescriptorSupplier() {}
    }

    private static final class HeaterServiceMethodDescriptorSupplier
            extends HeaterServiceImplBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
        private final String methodName;

        HeaterServiceMethodDescriptorSupplier(String methodName) {
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
            synchronized (HeaterServiceGrpc.class) {
                result = serviceDescriptor;
                if (result == null) {
                    serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                            .setSchemaDescriptor(new HeaterServiceFileDescriptorSupplier())
                            .addMethod(getHeaterMethod())
                            .build();
                }
            }
        }
        return result;
    }
}
