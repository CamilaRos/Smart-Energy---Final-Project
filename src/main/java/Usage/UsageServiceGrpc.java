package Usage;

import Usage.UsageServiceGrpc;
import Usage.AverageRequest;
import Usage.AverageResponse;
import com.google.protobuf.Descriptors;
import io.grpc.MethodDescriptor;
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
 *  <pre>
 * Usage Service Definition
 * </pre>
 */

@javax.annotation.Generated(
        value = "by gRPC proto compiler (version 1.15.0)",
        comments = "Source: usage.proto")

public abstract class UsageServiceGrpc {

    private UsageServiceGrpc() {}
    public static final String SERVICE_NAME = "SmartEnergy.UsageService";

    // Static method descriptors that strictly reflect the proto.

    private static volatile io.grpc.MethodDescriptor<Usage.AverageRequest,
            Usage.AverageResponse> getUsageMethod;

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "Usage",
            requestType = Usage.AverageRequest.class,
            responseType = Usage.AverageResponse.class,
            methodType = MethodDescriptor.MethodType.BIDI_STREAMING)
    public static io.grpc.MethodDescriptor<Usage.AverageRequest,
            Usage.AverageResponse> getUsageMethod() {
        io.grpc.MethodDescriptor<Usage.AverageRequest, Usage.AverageResponse> getUsageMethod;
        if ((getUsageMethod = UsageServiceGrpc.getUsageMethod) == null) {
            synchronized (UsageServiceGrpc.class) {
                if ((getUsageMethod = UsageServiceGrpc.getUsageMethod) == null) {
                    UsageServiceGrpc.getUsageMethod = getUsageMethod =
                            io.grpc.MethodDescriptor.<Usage.AverageRequest, Usage.AverageResponse>newBuilder()
                                    .setType(MethodDescriptor.MethodType.BIDI_STREAMING)
                                    .setFullMethodName(generateFullMethodName(
                                            "SmartEnergy.UsageService", "Usage"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            Usage.AverageRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            Usage.AverageResponse.getDefaultInstance()))
                                    .setSchemaDescriptor(new UsageServiceGrpc.UsageServiceMethodDescriptorSupplier("Usage"))
                                    .build();
                }
            }
        }
        return getUsageMethod;
    }

    /**
     * Creates a new async stub that supports all call types for the service
     */
    public static UsageServiceGrpc.UsageServiceStub newStub(io.grpc.Channel channel) {
        return new UsageServiceGrpc.UsageServiceStub(channel);
    }

    /**
     * Creates a new blocking-style stub that supports unary and streaming output calls on the service
     */
    public static UsageServiceGrpc.UsageServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
        return new UsageServiceGrpc.UsageServiceBlockingStub(channel);
    }

    /**
     * Creates a new ListenableFuture-style stub that supports unary calls on the service
     */
    public static UsageServiceGrpc.UsageServiceFutureStub newFutureStub(io.grpc.Channel channel) {
        return new UsageServiceGrpc.UsageServiceFutureStub(channel);
    }

    /**
     *  <pre>
     * Usage Service Definition
     * </pre>
     */
    public static abstract class UsageImplBase implements io.grpc.BindableService{

    /**
     * <pre>
     * Bi-directional Streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<Usage.AverageRequest> avgReq(
            io.grpc.stub.StreamObserver<Usage.AverageResponse> responseObserver) {
        return asyncUnimplementedStreamingCall(getUsageMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
        return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                .addMethod(
                        getUsageMethod(),
                        asyncClientStreamingCall(
                                new UsageServiceGrpc.MethodHandlers<
                                        AverageRequest,
                                        AverageResponse>(
                                        this, METHODID_USAGE)))
                .build();
    }

    public void setUsage(AverageRequest request, StreamObserver<AverageResponse> responseObserver) {
    }

        public abstract StreamObserver<AverageRequest> average(StreamObserver<AverageResponse> responseObserver);

        // Implement the bidirectional stream RPC method
    public abstract StreamObserver<AverageRequest> usage(StreamObserver<AverageResponse> responseObserver);
}

/**
 *  <pre>
 * Usage Service Definition
 * </pre>
 */
public static final class UsageServiceStub extends io.grpc.stub.AbstractStub<UsageServiceGrpc.UsageServiceStub> {
    private UsageServiceStub(io.grpc.Channel channel) {
        super(channel);
    }

    private UsageServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
        super(channel, callOptions);
    }

    @java.lang.Override
    protected UsageServiceGrpc.UsageServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
        return new UsageServiceGrpc.UsageServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Bi-directional Streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<Usage.AverageRequest> avgReq(
            io.grpc.stub.StreamObserver<Usage.AverageResponse> responseObserver) {
        return asyncClientStreamingCall(
                getChannel().newCall(getUsageMethod(), getCallOptions()), responseObserver);
    }

    public StreamObserver<AverageRequest> usage(StreamObserver<AverageResponse> responseObserver) {
        return asyncBidiStreamingCall(
                getChannel().newCall(getUsageMethod(), getCallOptions()), responseObserver);
    }

    public StreamObserver<AverageRequest> average(StreamObserver<AverageResponse> responseObserver) {
        return new StreamObserver<AverageRequest>() {
            @Override
            public void onNext(AverageRequest request) {
                // Handle the incoming request
            }

            @Override
            public void onError(Throwable t) {
                // Handle any errors
            }

            @Override
            public void onCompleted() {
                // Handle the completion of the stream
                responseObserver.onCompleted();
            }
        };
    }
}

/**
 *  <pre>
 * Usage Service Definition
 * </pre>
 */
public static final class UsageServiceBlockingStub extends io.grpc.stub.AbstractStub<UsageServiceGrpc.UsageServiceBlockingStub> {
    private UsageServiceBlockingStub(io.grpc.Channel channel) {
        super(channel);
    }

    private UsageServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
        super(channel, callOptions);
    }

    @java.lang.Override
    protected UsageServiceGrpc.UsageServiceBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
        return new UsageServiceGrpc.UsageServiceBlockingStub(channel, callOptions);
    }

    public static AverageResponse usage(AverageRequest request) {
        return UsageServiceBlockingStub.usage(request);
    }
}

/**
 *  <pre>
 * Usage Service Definition
 * </pre>
 */
public static final class UsageServiceFutureStub extends io.grpc.stub.AbstractStub<UsageServiceGrpc.UsageServiceFutureStub> {
    private UsageServiceFutureStub(io.grpc.Channel channel) {
        super(channel);
    }

    private UsageServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
        super(channel, callOptions);
    }

    @java.lang.Override
    protected UsageServiceGrpc.UsageServiceFutureStub build(io.grpc.Channel channel,
                                                            io.grpc.CallOptions callOptions) {
        return new UsageServiceGrpc.UsageServiceFutureStub(channel, callOptions);
    }
}

    private static final int METHODID_USAGE = 0;

private static final class MethodHandlers<Req, Resp> implements
        io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
        io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
        io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
        io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UsageServiceGrpc.UsageImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UsageServiceGrpc.UsageImplBase serviceImpl, int methodId) {
        this.serviceImpl = serviceImpl;
        this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
        switch (methodId) {
            case METHODID_USAGE:
                serviceImpl.setUsage((Usage.AverageRequest) request,
                        (io.grpc.stub.StreamObserver<AverageResponse>) responseObserver);
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
            case METHODID_USAGE:
                return (io.grpc.stub.StreamObserver<Req>) serviceImpl.usage((io.grpc.stub.StreamObserver<AverageResponse>) responseObserver);
            default:
                throw new AssertionError();
        }
    }
}

private static abstract class UsageServiceBaseDescriptorSupplier
        implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UsageServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
        return Usage.UsageImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
        return getFileDescriptor().findServiceByName("UsageService");
    }
}

private static final class UsageServiceFileDescriptorSupplier
        extends UsageServiceGrpc.UsageServiceBaseDescriptorSupplier {
    UsageServiceFileDescriptorSupplier() {}
}

private static final class UsageServiceMethodDescriptorSupplier
        extends UsageServiceGrpc.UsageServiceBaseDescriptorSupplier
        implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UsageServiceMethodDescriptorSupplier(String methodName) {
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
            synchronized (UsageServiceGrpc.class) {
                result = serviceDescriptor;
                if (result == null) {
                    serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                            .setSchemaDescriptor(new UsageServiceGrpc.UsageServiceFileDescriptorSupplier())
                            .addMethod(getUsageMethod())
                            .build();
                }
            }
        }
        return result;
    }
}