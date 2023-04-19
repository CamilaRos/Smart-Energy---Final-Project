package Temperature;

import JmDNS.ServiceRegistration;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class TemperatureServer extends TemperatureServiceGrpc.TemperatureServiceImplBase {
    public static void main(String[] args) throws Exception {

        TemperatureServer server2 = new TemperatureServer ();

        System.out.println("Starting gRPC Temperature Service server...");

        //Defining port
        int port = 50052;

        // JmDNS
        String service_type = "_Temperature._tcp.local.";
        String service_name = "GrpcServer";
        ServiceRegistration ssr = new ServiceRegistration();
        ssr.run(port, service_type, service_name);

        // Build and start the server
        try {
            Server server = ServerBuilder.forPort(port)
                    // Add an instance of TemperatureService to the server
                    .addService(new TemperatureService_Impl())
                    .build()
                    .start();
            System.out.println("Server started, listening on " + port);
            // Wait for the server to shut down
            server.awaitTermination();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
