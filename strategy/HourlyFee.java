package parking.strategy;

public class HourlyFee implements ParkingFeeStrategy {

    private static final int PRICE_PER_HOUR = 500;
    private static final int MINUTES_IN_HOUR = 60;

    @Override
    public int calculateFee(int minutesParked) {
        int startedHours = (minutesParked + MINUTES_IN_HOUR - 1) / MINUTES_IN_HOUR;
        return startedHours * PRICE_PER_HOUR;
    }
}