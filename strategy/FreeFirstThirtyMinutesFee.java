package parking.strategy;

public class FreeFirstThirtyMinutesFee implements ParkingFeeStrategy {

    private static final int FREE_MINUTES = 30;
    private static final int PRICE_PER_HOUR = 500;
    private static final int MINUTES_IN_HOUR = 60;

    @Override
    public int calculateFee(int minutesParked) {
        int payableMinutes = Math.max(0, minutesParked - FREE_MINUTES);
        int startedHours = (payableMinutes + MINUTES_IN_HOUR - 1) / MINUTES_IN_HOUR;
        return startedHours * PRICE_PER_HOUR;
    }
}