package JmDNS;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

public class ServiceRegistration {

    public void run(int port, String service_type, String service_name) {

        // JmDNS Instance
        try {

            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            int service_port = port;
            String service_desc = "Testing integration of JmDNS with gRPC";

            ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name,  service_port, service_desc);

            // Register the service

            jmdns.registerService(serviceInfo);
            System.out.printf("Registering service with type: %s and name: %s on port %d ", service_type, service_name, service_port);
            Thread.sleep(10000);
            System.out.println("Service Registered");

            // All unregister services
            // jmdns.unregisterAllServices();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

