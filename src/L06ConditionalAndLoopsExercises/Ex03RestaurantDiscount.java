package L06ConditionalAndLoopsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex03RestaurantDiscount {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double discount = 1.0;
        double packagePrice = 0;
        double hallPrice = 0;
        String hallType;

        int peopleCount = Integer.parseInt(reader.readLine());
        String packageType = reader.readLine();

        if (peopleCount > 120) {
            System.out.println("We do not have an appropriate hall.");
            return;
        }

        if (peopleCount <= 50) {
            hallPrice = 2500.0;
            hallType = "Small Hall";
        } else if (peopleCount <= 100) {
            hallPrice = 5000.0;
            hallType = "Terrace";
        } else {
            hallPrice = 7500.0;
            hallType = "Great Hall";
        }

        switch (packageType) {
            case "Normal":
                discount = 0.95;
                packagePrice = 500.0;
                break;
            case "Gold":
                discount = 0.9;
                packagePrice = 750.0;
                break;
            case "Platinum":
                discount = 0.85;
                packagePrice = 1000.0;
                break;
        }

        double totalCost = (hallPrice + packagePrice) * discount;
        double pricePerPerson = totalCost / peopleCount;

        System.out.println(String.format("We can offer you the %s", hallType));
        System.out.println(String.format("The price per person is %.2f$", pricePerPerson));

    }
}
