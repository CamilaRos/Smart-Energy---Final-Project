package Setting;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.jmdns.ServiceInfo;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import Setting.SettingServiceGrpc.SettingServiceStub;
import JmDNS.ServiceDiscovery;
import Setting.SettingServiceGrpc;
import Setting.TempReadRequest;

public class SettingClient {
    public static void main(String[] args) throws InterruptedException {

        // JmDNS
        String service_type = "_SettingService._tcp.local.";
        String service_name = "GrpcServer";
        ServiceInfo serviceInfo = ServiceDiscovery.run(service_type);

        // Port & Host
        int port = 50053;
        String host = "localhost";

        // Build a channel
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress(host, port)
                .usePlaintext()
                .build();
        doClientStreamingCall(channel);

        System.out.println("Shutting down channel");
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    // Client Streaming Method
    private static void doClientStreamingCall(ManagedChannel channel) {
        SettingServiceStub asyncClient = SettingServiceGrpc.newStub(channel);
        CountDownLatch latch = new CountDownLatch(1);
        StreamObserver<TempReadRequest> requestObserver = asyncClient.setting(new StreamObserver<TempSetResponse>() {
            @Override
            public void onNext(TempSetResponse value) {
                double newSetPoint = value.getNewSetPoint();
                double newSetPointCelsius = (newSetPoint - 32) * 5 / 9; // Convert Fahrenheit to Celsius
                System.out.println("Received a response from the server.");
                System.out.println("The new temperature set point is: " + String.format("%.2f", newSetPointCelsius) + " °C");
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
                System.out.println("Server has completed sending data.");
                latch.countDown();
            }
        });

        // Generate random temperature
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            double reading = random.nextDouble() * 100.0; // Generate random temperature reading between 0 and 100
            double readingCelsius = (reading - 32) * 5 / 9; // Convert Fahrenheit to Celsius
            System.out.println("Sending temperature reading " + String.format("%.2f", readingCelsius) + " °C to server...");
            requestObserver.onNext(TempReadRequest.newBuilder()
                    .setTempReading(reading)
                    .build());
        }
        requestObserver.onCompleted();

        // Wait for the RPC to complete
        try {
            latch.await(3, TimeUnit.SECONDS);
            // Handle other errors
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
