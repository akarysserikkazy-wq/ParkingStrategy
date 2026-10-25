## Assignment #5 — Strategy pattern
### Student: Serikkazy Akarys
### Group: SE-2514

# Parking Fee Calculator - Strategy Pattern (Java)

## Idea
A car stays in a parking lot for some time. The fee can be calculated in several
interchangeable ways (hourly, free first 30 minutes, daily flat, subscription).
The way is chosen at runtime, so each algorithm lives in its own class.

## Structure
- Strategy Interface: ParkingFeeStrategy
- Concrete Strategies: HourlyFee, FreeFirstThirtyMinutesFee, DailyFlatFee, SubscriptionFee
- Context: ParkingSession
- Client: Main


### Clean Code Requirements
#### 1. Elimination of conditional/branching logic in favor of polymorphism: 

ParkingSession.calculateFee() is a single line: feeStrategy.calculateFee(minutesParked). There is no if/switch on the strategy type; the choice of behavior is made by the object that was passed in by the Client.

#### 2. Meaningful, intention-revealing names for each strategy:

FreeFirstThirtyMinutesFee and DailyFlatFee tell what the algorithm does without reading the code. Constants such as PRICE_PER_HOUR and MINUTES_IN_DAY replace magic numbers.

#### 3. Single Responsibility: each strategy does exactly one algorithm, nothing else

Each strategy has one reason to change: its own pricing rule. ParkingSession only stores the visit data and delegates; Main only selects strategies.

#### 4. Context remains algorithm-agnostic (no knowledge of concrete strategy internals):

ParkingSession depends on the ParkingFeeStrategy abstraction, not on concrete classes. It does not import any concrete strategy.

#### 5. Easy extensibility demonstrated (adding a new strategy without touching existing classes):

SubscriptionFee was added as a 4th strategy without modifying ParkingSession, the interface, or any other strategy. New pricing = new class.
