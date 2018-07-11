package L06ConditionalAndLoopsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex01ChooseDrink {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        switch (input) {
            case "Athlete":
                System.out.println("Water");
                break;
            case "Businessman":
            case "Businesswoman":
                System.out.println("Coffee");
                break;
            case "SoftUni Student":
                System.out.println("Beer");
                break;
            default:
                System.out.println("Tea");

        }
    }
}
