package parking.strategy;

public class DailyFlatFee implements ParkingFeeStrategy {

    private static final int PRICE_PER_DAY = 3000;
    private static final int MINUTES_IN_DAY = 24 * 60;

    @Override
    public int calculateFee(int minutesParked) {
        int startedDays = (minutesParked + MINUTES_IN_DAY - 1) / MINUTES_IN_DAY;
        return startedDays * PRICE_PER_DAY;
    }
}
