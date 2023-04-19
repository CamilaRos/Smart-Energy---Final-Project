package SmartEnergyGUI;

import Heater.HeaterServiceGrpc;
import Heater.TemperatureRequest;
import Heater.TemperatureResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import Setting.SettingServiceGrpc;
import Setting.TempReadRequest;
import Setting.TempSetResponse;
import Temperature.TempStatusRequest;
import Temperature.TempStatusResponse;
import Temperature.TemperatureServiceGrpc;
import Usage.AverageRequest;
import Usage.AverageResponse;
import Usage.UsageServiceGrpc;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ServicePanel extends JPanel implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JTextField service2Entry;
    private JTextField service3Entry;
    private JTextField service4Entry;
    private JTextField service4Reply;

    private final List<JTextField> entryFields;
    private final List<JTextField> replyFields;

    public ServicePanel(String serviceName, String buttonLabel, List<JTextField> entryFields, List<JTextField> replyFields) {
        /*
         * Creates a new instance of the ServicePanel for the given service
         */
        this.entryFields = entryFields;
        this.replyFields = replyFields;

        setBorder(BorderFactory.createTitledBorder(serviceName));
        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton button = new JButton(buttonLabel);
        button.addActionListener(this);
        buttonPanel.add(button);
        add(buttonPanel, BorderLayout.SOUTH);

        JPanel outputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel outputLabel = new JLabel("Result:");
        JTextField outputField = new JTextField(10);
        outputField.setEditable(false);
        outputPanel.add(outputLabel);
        outputPanel.add(outputField);
        replyFields.add(outputField);
        add(outputPanel, BorderLayout.CENTER);

        if (serviceName.equals("Heater Service")) {
        } else if (serviceName.equals("Temperature Service")) {
            service2Entry = new JTextField(10);
            JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel inputLabel = new JLabel("Enter value:");
            inputPanel.add(inputLabel);
            inputPanel.add(service2Entry);
            entryFields.add(service2Entry);
            add(inputPanel, BorderLayout.NORTH);
        } else if (serviceName.equals("Setting Service")) {
            service3Entry = new JTextField(10);
            JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel inputLabel = new JLabel("Enter value:");
            inputPanel.add(inputLabel);
            inputPanel.add(service3Entry);
            entryFields.add(service3Entry);
            add(inputPanel, BorderLayout.NORTH);
        } else if (serviceName.equals("Usage Service")) {
            service4Entry = new JTextField(10);
            JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel inputLabel = new JLabel("Enter value:");
            inputPanel.add(inputLabel);
            inputPanel.add(service4Entry);
            entryFields.add(service4Entry);
            add(inputPanel, BorderLayout.NORTH);
            service4Reply = outputField;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*
         * Handles the events triggered by the buttons
         */
        JButton button = (JButton) e.getSource();
        String label = button.getActionCommand();

        if (label.equals("Invoke Heater Service")) {
            System.out.println("Heater service to be invoked ...");

            // Create a new thread to invoke the service
            new Thread(() -> {
                // Heater Service Definition
                ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
                HeaterServiceGrpc.HeaterServiceBlockingStub blockingStub = HeaterServiceGrpc.newBlockingStub(channel);

                // Prepare the request message
                TemperatureRequest request = TemperatureRequest.newBuilder().build();

                // Invoke the service and retrieve the response
                TemperatureResponse response = blockingStub.heater(request);

                // Update the UI with the response
                SwingUtilities.invokeLater(() -> {
                    replyFields.get(0).setText(response.getHeatingOff());
                });

                // Shutdown the channel
                channel.shutdown();
            }).start();

        } else if (label.equals("Invoke Temperature Service")) {
            System.out.println("Temperature service to be invoked ...");

            // Create a new thread to invoke the service
            new Thread(() -> {
                // Temperature Service Definition
                ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
                TemperatureServiceGrpc.TemperatureServiceBlockingStub blockingStub = TemperatureServiceGrpc.newBlockingStub(channel);

                // Prepare the request message
                TempStatusRequest request = TempStatusRequest.newBuilder().setTempStatus(0).build();

                // Invoke the service and retrieve the response
                TempStatusResponse response = blockingStub.temperature(request);

                // Update the UI with the response
                SwingUtilities.invokeLater(() -> {
                    replyFields.get(1).setText(String.valueOf(response.getTempCurr()));
                });

                // Shutdown the channel
                channel.shutdown();
            }).start();

        } else if (label.equals("Invoke Setting Service")) {
            System.out.println("Setting service to be invoked ...");

            // Create a new thread to invoke the service
            new Thread(() -> {
                // Setting Service Definition
                ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();
                SettingServiceGrpc.SettingServiceBlockingStub blockingStub = SettingServiceGrpc.newBlockingStub(channel);

                // Prepare the request message
                JTextField service3Entry = entryFields.get(2);
                TempReadRequest request = TempReadRequest.newBuilder().setTempReading(Double.parseDouble(service3Entry.getText())).build();

                // Invoke the service and retrieve the response
                TempSetResponse response = blockingStub.setting(request);

                // Update the UI with the response
                SwingUtilities.invokeLater(() -> {
                    assert response != null;
                    replyFields.get(2).setText(String.valueOf(response.getNewSetPoint()));
                });

                // Shutdown the channel
                channel.shutdown();
            }).start();

        } else if (label.equals("Stream Usage Service")) {
            System.out.println("Streaming usage data ...");

            // Create a new thread to stream the data
            new Thread(() -> {
                // Usage Service Definition
                ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50054).usePlaintext().build();
                UsageServiceGrpc.UsageServiceStub asyncStub = UsageServiceGrpc.newStub(channel);

                // Prepare the request message and stream the data
                StreamObserver<AverageResponse> responseObserver = new StreamObserver<AverageResponse>() {
                    @Override
                    public void onNext(AverageResponse response) {
                        SwingUtilities.invokeLater(() -> {
                            service4Reply.setText(response.getAvgRes());
                        });
                    }

                    @Override
                    public void onError(Throwable t) {
                        System.err.println(t.getMessage());
                    }
                    @Override
                    public void onCompleted() {
                        System.out.println("Server has completed sending the data");
                    }
                };
                StreamObserver<AverageRequest> requestObserver = asyncStub.usage(responseObserver);

                // Continuously send the usage data
                while (true) {
                    try {
                        double usage = Double.parseDouble(service4Entry.getText());
                        requestObserver.onNext(AverageRequest.newBuilder().setAvgReq(usage).build());
                        Thread.sleep(1000);
                    } catch (NumberFormatException ex) {
                        requestObserver.onError(ex);
                        break;
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                        requestObserver.onCompleted();
                        break;
                    }
                }

                // Finish streaming
                requestObserver.onCompleted();

                // Shutdown the channel
                channel.shutdown();
            }).start();
        }
    }
}