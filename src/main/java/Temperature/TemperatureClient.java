package Temperature;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import JmDNS.ServiceDiscovery;
import javax.jmdns.ServiceInfo;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class TemperatureClient {
    private static TemperatureServiceGrpc.TemperatureServiceBlockingStub bStub;

    public static void main(String[] args) throws InterruptedException {

        // JmDNS
        ServiceInfo serviceInfo;
        String service_type = "_Temperature._tcp.local.";
        String service_name = "GrpcServer";
        serviceInfo = ServiceDiscovery.run(service_type);

        // Port & Host
        int port = 50052;
        String host = "localhost";

        // Build a channel
        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();

        // Create a new instance of TemperatureService
        TemperatureService_Impl temperatureService = new TemperatureService_Impl();

        // Call the server streaming method on the TemperatureService instance
        doServerStreamingCall(channel, temperatureService);

        System.out.println("Shutting down channel");
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    // Server Streaming Method
    private static void doServerStreamingCall(ManagedChannel channel, TemperatureService_Impl temperatureService) throws InterruptedException {
        System.out.println("Starting server streaming...");

        // Stream the responses
        CountDownLatch latch = new CountDownLatch(10); // 10 messages to be received
        final boolean[] printTemp = {false};
        for (int i = 0; i < 10; i++) {
            int tempStatus = i + 1;
            // Prepare the request
            TempStatusRequest request = TempStatusRequest.newBuilder()
                    .setTempStatus(tempStatus)
                    .build();
            temperatureService.temperature(request, new StreamObserver<TempStatusResponse>() {
                @Override
                public void onNext(TempStatusResponse response) {
                    // Print the temperature response
                    if (!printTemp[0]) {
                        System.out.println("Current indoor temperature:  " + response.getTempCurr() + " ºC");
                        printTemp[0] = true;
                    }
                }

                @Override
                // Handle errors
                public void onError(Throwable t) {
                    t.printStackTrace();
                    latch.countDown();
                }

                @Override
                // Complete the RPC
                public void onCompleted() {
                    latch.countDown();
                }
            });
        }
        latch.await();
    }
}
