package Z_ExamsExtendet.exam09May2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex01SplinterTrip {
    private static BufferedReader reader;
    private static final double FUEL_PER_MILE = 25.0;
    private static final double FUEL_PER_MILE_WINDS = 25.0 * 1.5;
    private static final double RESERVE = 1.05;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        double tripDistance = Double.parseDouble(reader.readLine());
        double tankCapacity = Double.parseDouble(reader.readLine());
        double milesInHeavyWinds = Double.parseDouble(reader.readLine());

        double fuelNeeded = calculateFuelNeeded(tripDistance, milesInHeavyWinds);

        System.out.println(String.format("Fuel needed: %.2fL", fuelNeeded));

        if (tankCapacity - fuelNeeded >= 0) {
            System.out.println(String.format("Enough with %.2fL to spare!", tankCapacity - fuelNeeded));
        } else {
            System.out.println(String.format("We need %.2fL more fuel.", fuelNeeded - tankCapacity));
        }

    }

    private static double calculateFuelNeeded(double tripDistance, double milesInHeavyWinds) {
        double consumptionHeavyWinds = milesInHeavyWinds * FUEL_PER_MILE_WINDS;
        double consumption = (tripDistance - milesInHeavyWinds) * FUEL_PER_MILE;
        return (consumption + consumptionHeavyWinds) * RESERVE;
    }
}
