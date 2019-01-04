package Z_Exams.exam12Jun2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex01Numbers {
    private static long[] numbers;
    private static BufferedReader reader;
    private static List<Long> filtered;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToLong(Long::parseLong)
                .toArray();
        double average = getAverage();
        filterNumbers(average);
        sortFilteredNumbers();
        String output = getTopFiveNumbers();
        System.out.println(output);

    }

    private static String getTopFiveNumbers() {
        if (filtered.size() == 0) {
            return "No";
        }
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < Math.min(5, filtered.size()); i++) {
            output.append(filtered.get(i)).append(" ");
        }

        return output.toString().trim();
    }

    private static void sortFilteredNumbers() {
        for (int i = 0; i < filtered.size() - 1; i++) {
            for (int j = i + 1; j < filtered.size(); j++) {
                if (filtered.get(i) < filtered.get(j)) {
                    long temp = filtered.get(i);
                    filtered.set(i, filtered.get(j));
                    filtered.set(j, temp);
                }
            }
        }
    }

    private static void filterNumbers(double average) {
        filtered = new ArrayList<>();
        for (long number : numbers) {
            if (number > average) {
                filtered.add(number);
            }
        }
    }

    private static double getAverage() {
        double sum = 0;
        for (long number : numbers) {
            sum += number;
        }
        return sum / numbers.length;
    }
}
