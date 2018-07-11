package L12ArraysMoreExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex06Heist01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] prices = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        long earnings = 0L;
        long expenses = 0L;

        String input;
        while (! "Jail Time".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");
            String loot = tokens[0];
            int heistExpense = Integer.parseInt(tokens[1]);
            expenses += heistExpense;

            for (int i = 0; i < loot.length(); i++) {
                if (loot.charAt(i) == '%') {
                    earnings += prices[0];
                } else if (loot.charAt(i) == '$') {
                    earnings += prices[1];
                }
            }
        }

        long diff = earnings - expenses;

        if (diff >= 0) {
            System.out.println(String.format("Heists will continue. Total earnings: %d.", diff));
        } else {
            System.out.println(String.format("Have to find another job. Lost: %d.",Math.abs(diff)));
        }
    }
}
