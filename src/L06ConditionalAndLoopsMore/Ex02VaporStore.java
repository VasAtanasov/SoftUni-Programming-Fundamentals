package L06ConditionalAndLoopsMore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Ex02VaporStore {
    private static LinkedHashMap<String, Double> prices = new LinkedHashMap<String, Double>() {{
        put("OutFall 4", 39.99);
        put("CS: OG", 15.99);
        put("Zplinter Zell", 19.99);
        put("Honored 2", 59.99);
        put("RoverWatch", 29.99);
        put("RoverWatch Origins Edition", 39.99);
    }};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double money = Double.parseDouble(reader.readLine());
        double totalSpent = 0;

        String input;
        while (! "Game Time".equals(input = reader.readLine())) {
            if (! prices.containsKey(input)) {
                System.out.println("Not Found");
                continue;
            }

            double price = prices.get(input);

            if (money - price < 0) {
                System.out.println("Too Expensive");
                continue;
            }

            money -= price;
            totalSpent += price;
            System.out.println(String.format("Bought %s", input));

            if (money == 0) {
                System.out.println("Out of money!");
                return;
            }
        }

        System.out.println(String.format("Total spent: $%.2f. Remaining: $%.2f", totalSpent, money));
    }
}
