// UsageServer Implementation

package Usage;

import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class UsageService_Impl extends UsageServiceGrpc.UsageImplBase {

    private final List<Double> readings = new ArrayList<>();

    @Override
    public StreamObserver<AverageRequest> average(StreamObserver<AverageResponse> responseObserver) {
        return new StreamObserver<AverageRequest>() {
            @Override
            public void onNext(AverageRequest request) {
                readings.add(request.getAvgReq());
            }

            @Override
            public void onError(Throwable t) {
                Logger.getLogger(UsageService_Impl.class.getName()).warning("Average failed with error " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                double sum = 0;
                for (double r : readings) {
                    sum += r;
                }
                double avg = sum / readings.size();
                AverageResponse response = AverageResponse.newBuilder().setAvgRes(String.valueOf(avg)).build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public StreamObserver<AverageRequest> usage(StreamObserver<AverageResponse> responseObserver) {
        return null;
    }
}
