// SettingServer Implementation

package Setting;

import io.grpc.stub.StreamObserver;

public class SettingService_Impl extends SettingServiceGrpc.SettingServiceImplBase {

         @Override
         public void setting(TempReadRequest request, StreamObserver<TempSetResponse> responseObserver) {
             double currentTemp = request.getTempReading();
             double newSetPoint = calculateNewSetPoint(currentTemp);
             TempSetResponse response = TempSetResponse.newBuilder()
                            .setNewSetPoint(newSetPoint)
                            .build();
                    responseObserver.onNext(response);
                    responseObserver.onCompleted();
                }

                private double calculateNewSetPoint(double currentTemp) {
                    return currentTemp + 2.0; // Increase the set point by 2 degrees
                }
            }
