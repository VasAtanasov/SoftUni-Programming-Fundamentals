package L06ConditionalAndLoopsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Ex08CaloriesCounter {
    private static LinkedHashMap<String, Integer> calories = new LinkedHashMap<String, Integer>() {{
        put("cheese", 500);
        put("tomato sauce", 150);
        put("salami", 600);
        put("pepper", 50);
    }};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        int totalCalories = 0;

        for (int i = 0; i < count; i++) {
            String ingredient = reader.readLine().toLowerCase();
            if (calories.containsKey(ingredient)) {
                totalCalories += calories.get(ingredient);
            }
        }

        System.out.println(String.format("Total calories: %d", totalCalories));
    }
}
