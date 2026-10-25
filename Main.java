package parking;

import parking.context.ParkingSession;
import parking.strategy.DailyFlatFee;
import parking.strategy.FreeFirstThirtyMinutesFee;
import parking.strategy.HourlyFee;
import parking.strategy.SubscriptionFee;

public class Main {

    public static void main(String[] args) {
        // 1. Start with hourly pricing
        ParkingSession session = new ParkingSession("777 ABC 02", 80, new HourlyFee());
        print("Hourly", session);

        // 2. Same car, same time - switch strategy at runtime
        session.setFeeStrategy(new FreeFirstThirtyMinutesFee());
        print("Free first 30 min", session);

        session.setFeeStrategy(new DailyFlatFee());
        print("Daily flat", session);

        // 3. Extension: SubscriptionFee was added without touching any existing class
        session.setFeeStrategy(new SubscriptionFee());
        print("Subscription", session);

        // 4. A short visit shows the difference between strategies clearly
        System.out.println();
        ParkingSession shortVisit = new ParkingSession("123 XYZ 05", 25, new HourlyFee());
        print("Hourly", shortVisit);
        shortVisit.setFeeStrategy(new FreeFirstThirtyMinutesFee());
        print("Free first 30 min", shortVisit);
    }

    private static void print(String strategyName, ParkingSession session) {
        System.out.printf("%-12s | %3d min | %-18s -> %5d KZT%n",
                session.getPlateNumber(), session.getMinutesParked(),
                strategyName, session.calculateFee());
    }
}