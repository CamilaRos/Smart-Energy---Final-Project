package Usage;

import JmDNS.ServiceDiscovery;
import Usage.AverageRequest;
import Usage.UsageServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import javax.jmdns.ServiceInfo;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class UsageClient {
    private static UsageServiceGrpc.UsageServiceStub asyncStub;

    public static void main(String[] args) throws InterruptedException {

        // JmDNS
        ServiceInfo serviceInfo;
        String service_type = "_UsageService._tcp.local.";
        String service_name = "GrpcServer";
        serviceInfo = ServiceDiscovery.run(service_type);

        // Port & Host
        int port = 50052;
        String host = "localhost";

        // Build a channel
        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();

        // Stub
        asyncStub = UsageServiceGrpc.newStub(channel);

        // Call the bidirectional streaming method
        doBidirectionalCall();

        System.out.println("Shutting down channel");
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    // Bidirectional Streaming Method
    private static void doBidirectionalCall() {
        System.out.println("Starting bidirectional streaming...");
        CountDownLatch latch = new CountDownLatch(1);

        StreamObserver<AverageRequest> requestObserver = asyncStub.average(new StreamObserver<AverageResponse>() {
            @Override
            public void onNext(AverageResponse response) {
                System.out.println("Response from server: " + response.getAvgRes());
            }

            @Override
            // Handle errors
            public void onError(Throwable t) {
                if (t instanceof StatusRuntimeException && ((StatusRuntimeException) t).getStatus().equals(Status.CANCELLED)) {
                    System.out.println("RPC call was cancelled");
                } else {
                    t.printStackTrace();
                }
                latch.countDown();
            }

            @Override
            // Complete the RPC
            public void onCompleted() {
                latch.countDown();
            }
        });

        // Send random usage data for 10 days
        double totalUsage = 0;
        for (int i = 1; i <= 10; i++) {
            double usage = Math.random() * 100;
            requestObserver.onNext(AverageRequest.newBuilder().setAvgReq(usage).build());
            totalUsage += usage;
            System.out.println("Day " + i + " usage: " + String.format("%.2f", usage) + "%");
        }
        System.out.println("Total usage: " + String.format("%.2f", totalUsage) + "%");
        requestObserver.onCompleted();

        // Wait for the RPC to complete
        try {
            latch.await(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
