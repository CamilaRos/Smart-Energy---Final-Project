package Heater;

import Heater.HeaterServer;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import JmDNS.ServiceRegistration;
import Heater.HeaterServiceGrpc.HeaterServiceImplBase;
import Heater.TemperatureRequest;
import Heater.TemperatureResponse;

public class HeaterServer extends HeaterServiceImplBase {
    public static void main(String[] args) throws Exception {

        HeaterServer server1 = new HeaterServer();

        System.out.println("Starting gRPC Heater Service server... ");

        //Defining port
        int port = 8081;

        // JmDNS
        String service_type = "_Heater._tcp.local.";
        String service_name = "GrpcServer";
        ServiceRegistration ssr = new ServiceRegistration();
        ssr.run(port, service_type, service_name);

        // Build and start the server
        Server server = ServerBuilder.forPort(port)
                .addService(new HeaterService_Impl())
                .build();
        server.start();
        System.out.println("Server started, listening on " + port);

        // Shutdown
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Received Shutdown Request");
            server.shutdown();
            System.out.println("Successfully stopped the server");
        }));

        // Block main thread until shutdown
        server.awaitTermination();
    }

    @Override
    public void heater(TemperatureRequest request, StreamObserver<TemperatureResponse> responseObserver) {

        System.out.println("Heating system is shutting down...");

        // Build the response
        TemperatureResponse response = TemperatureResponse.newBuilder()
                .setHeatingOff("Heating system is shutting down")
                .build();

        // Send the response
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
