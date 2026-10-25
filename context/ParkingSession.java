package parking.context;

import parking.strategy.ParkingFeeStrategy;

import java.util.Objects;

public class ParkingSession {

    private final String plateNumber;
    private final int minutesParked;
    private ParkingFeeStrategy feeStrategy;

    public ParkingSession(String plateNumber, int minutesParked, ParkingFeeStrategy feeStrategy) {
        if (minutesParked < 0) {
            throw new IllegalArgumentException("minutesParked must be >= 0");
        }
        this.plateNumber = plateNumber;
        this.minutesParked = minutesParked;
        this.feeStrategy = Objects.requireNonNull(feeStrategy, "feeStrategy");
    }

    public void setFeeStrategy(ParkingFeeStrategy feeStrategy) {
        this.feeStrategy = Objects.requireNonNull(feeStrategy, "feeStrategy");
    }

    public int calculateFee() {
        return feeStrategy.calculateFee(minutesParked);
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public int getMinutesParked() {
        return minutesParked;
    }
}
