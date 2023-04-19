package JmDNS;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;

public class ServiceDiscovery {
    private static String service_type;
    private int port;
    private String host;

    public ServiceDiscovery() {
    }

    public static String getService_type() {
        return service_type;
    }

    public static void setService_type(String service_type) {
        ServiceDiscovery.service_type = service_type;
    }

    private static class MyServiceListener implements ServiceListener{

        private int port;
        private String host;
        private ServiceInfo serviceInfo;

        public void serviceAdded(ServiceEvent event) {
        }

        public void serviceRemoved(ServiceEvent event) {
        }

        public void serviceResolved(ServiceEvent event) {
            ServiceInfo serviceInfo = event.getInfo();
            this.setServiceInfo(serviceInfo);
            System.out.println("host " + serviceInfo.getHostAddress());
            System.out.println("port " + serviceInfo.getPort());
            this.setPort(serviceInfo.getPort());
            System.out.println("type " + serviceInfo.getType());
            System.out.println("name " + serviceInfo.getName());
            System.out.println("Computer name " + serviceInfo.getServer());
            System.out.println("desc/properties " + serviceInfo.getNiceTextString());

        }
        public int getPort() {
            return port;
        }

        public void setPort(int port) {
            this.port = port;
        }

        public ServiceInfo getServiceInfo() {
            return serviceInfo;
        }
        public void setServiceInfo(ServiceInfo serviceInfo) {
            this.serviceInfo = serviceInfo;
        }
    }

    public static ServiceInfo run(String service_type) throws InterruptedException {

        int port = 0;
        ServiceInfo serviceInfo = null;

        // Get an instance of JmDNS

        try {
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            MyServiceListener msl = new MyServiceListener();

            jmdns.addServiceListener(service_type, msl);

            Thread.sleep(10000);

            serviceInfo = msl.getServiceInfo();
            port = msl.getPort();
            System.out.println("This is the port retrieved from jmDNS: "+ port);
            jmdns.close();

        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return serviceInfo;
    }
}
