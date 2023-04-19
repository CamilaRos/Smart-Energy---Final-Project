// HeaterServer Implementation

package Heater;

import io.grpc.stub.StreamObserver;

public class HeaterService_Impl extends HeaterServiceGrpc.HeaterServiceImplBase {

    @Override
    public void heater(TemperatureRequest request, StreamObserver<TemperatureResponse> responseObserver) {
        double currentTemp = 25.0;
        double newTemp = currentTemp + 1.0;
        String message = generateReplyMessage(newTemp);
        TemperatureResponse response = TemperatureResponse.newBuilder().setHeatingOff(message).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    private static String generateReplyMessage(double temperature) {
        String message = "";
        if (temperature < 16) {
            message = "The temperature is too low, turning on the heater.";
        } else if (temperature > 24) {
            message = "The temperature is too high, turning off the heater.";
        } else {
            message = "The temperature is within the comfortable range.";
        }
        return message;
    }
}

