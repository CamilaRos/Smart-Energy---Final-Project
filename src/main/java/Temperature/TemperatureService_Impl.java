// TemperatureServer Implementation

package Temperature;

import io.grpc.stub.StreamObserver;

public class TemperatureService_Impl extends TemperatureServiceGrpc.TemperatureServiceImplBase {

    @Override
    public void temperature(TempStatusRequest request, StreamObserver<TempStatusResponse> responseObserver) {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                double temperature = getIndoorTemperature(request.getTempStatus());
                TempStatusResponse response = TempStatusResponse.newBuilder()
                        .setTempCurr(temperature)
                        .build();
                responseObserver.onNext(response);
                Thread.sleep(1000L); // Sleep for 1 second before sending next update
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            responseObserver.onCompleted();
        }
    }

    // Setting 10 different indoor temperatures
    private double getIndoorTemperature(int tempStatus) {
        double temperature;
        switch (tempStatus) {
            case 1:
                temperature = 18.0;
                break;
            case 2:
                temperature = 18.5;
                break;
            case 3:
                temperature = 19.0;
                break;
            case 4:
                temperature = 19.5;
                break;
            case 5:
                temperature = 20.0;
                break;
            case 6:
                temperature = 20.5;
                break;
            case 7:
                temperature = 21.0;
                break;
            case 8:
                temperature = 21.5;
                break;
            case 9:
                temperature = 22.0;
                break;
            case 10:
                temperature = 22.5;
                break;
            default:
                temperature = 23.0;
                break;
        }
        return temperature;
    }
}
