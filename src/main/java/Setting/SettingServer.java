package Setting;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import Setting.SettingServiceGrpc.SettingServiceImplBase;
import JmDNS.ServiceRegistration;

public class SettingServer extends SettingServiceImplBase {

    public static void main(String[] args) {

        SettingServer server3 = new SettingServer();

        System.out.println("Starting gRPC SettingService server...");

        //Defining Port
        int port = 50053;

        // JmDNS
        String service_type = "_Setting._tcp.local.";
        String service_name =  "GrpcServer";
        ServiceRegistration ssr = new ServiceRegistration();
        ssr.run(port, service_type, service_name);

        // Build and start the server
        try {
            Server server = ServerBuilder.forPort(port)
                    //Implementing the interface
                    .addService(new SettingService_Impl())
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