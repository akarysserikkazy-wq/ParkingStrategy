package parking.strategy;

public interface ParkingFeeStrategy {

    /**
     * @param minutesParked how long the car stayed, in minutes (>= 0)
     * @return fee in tenge
     */
    int calculateFee(int minutesParked);
}
