package L06ConditionalAndLoopsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Ex02ChooseDrink2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, Double> prices = new LinkedHashMap<String, Double>() {{
            put("Water", 0.7);
            put("Coffee", 1.0);
            put("Beer", 1.7);
            put("Tea", 1.2);
        }};

        String input = reader.readLine();
        int amount = Integer.parseInt(reader.readLine());
        switch (input) {
            case "Athlete":
                System.out.println(String.format("The %s has to pay %.2f.", input, prices.get("Water") * amount));
                break;
            case "Businessman":
            case "Businesswoman":
                System.out.println(String.format("The %s has to pay %.2f.", input, prices.get("Coffee") * amount));
                break;
            case "SoftUni Student":
                System.out.println(String.format("The %s has to pay %.2f.", input, prices.get("Beer") * amount));
                break;
            default:
                System.out.println(String.format("The %s has to pay %.2f.", input, prices.get("Tea") * amount));


        }
    }
}
