package parking.strategy;

public class SubscriptionFee implements ParkingFeeStrategy {

    @Override
    public int calculateFee(int minutesParked) {
        return 0;
    }
}
