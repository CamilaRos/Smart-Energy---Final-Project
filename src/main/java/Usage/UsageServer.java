package Usage;

import Setting.SettingServer;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import JmDNS.ServiceRegistration;
import java.io.IOException;

public class UsageServer {
    public static void main(String[] args) throws IOException, InterruptedException {

        SettingServer server4 = new SettingServer();

        System.out.println("Starting gRPC Usage Service server...");

        //Defining port
        int port = 50052;

        // JmDNS
        String service_type = "_Usage._tcp.local.";
        String service_name = "GrpcServer";
        ServiceRegistration ssr = new ServiceRegistration();
        ssr.run(port, service_type, service_name);

        // Build and start the server
        try {
        Server server = ServerBuilder.forPort(port)
                //Implementing the interface
                .addService(new UsageService_Impl())
                .build();
        server.start();
        System.out.println("Server started, listening on " + port);
        // Wait for the server to shut down
        server.awaitTermination();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}