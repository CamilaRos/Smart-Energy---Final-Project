import java.util.concurrent.TimeUnit;
import javax.jmdns.ServiceInfo;
import javax.swing.JOptionPane;
import Heater.HeaterServiceGrpc;
import Heater.TemperatureRequest;
import Heater.TemperatureResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import JmDNS.ServiceDiscovery;

public class HeaterClient {
    private static HeaterServiceGrpc.HeaterServiceBlockingStub bStub;

    public static void main(String[] args) throws InterruptedException {

        // JmDNS
        ServiceInfo serviceInfo;
        String service_type = "_HeaterService._tcp.local.";
        String service_name = "GrpcServer";
        serviceInfo = ServiceDiscovery.run(service_type);

        // Port & Host
        int port = 8081;
        String host = "localhost";

        // Build a channel
        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();

        // Stub
        bStub = HeaterServiceGrpc.newBlockingStub(channel);

        try {
            // Set a deadline of 10 seconds for the RPC call
            TemperatureResponse response = bStub.withDeadlineAfter(10, TimeUnit.SECONDS)
                    .heater(TemperatureRequest.getDefaultInstance());
            // Print the response
            JOptionPane.showMessageDialog(null, response.getHeatingOff());
        } catch (StatusRuntimeException e) {
            if (e.getStatus().getCode() == Status.DEADLINE_EXCEEDED.getCode()) {
                // Handling of Deadline Exceeded errors:
                System.out.println("RPC call timed out");
            } else {
                // Handling of other errors:
                System.out.println("Error: " + e.getStatus());
            }
        }

        System.out.println("Shutting down channel");
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }
}
