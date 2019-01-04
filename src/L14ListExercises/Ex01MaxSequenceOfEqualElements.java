package L14ListExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex01MaxSequenceOfEqualElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int bestStart = 0;
        int bestLength = 1;
        int length = 1;

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i - 1] == numbers[i]) {
                length++;
            } else {
                if (length > bestLength) {
                    bestLength = length;
                    bestStart = i - length;
                }
                length = 1;
            }

            if (i == numbers.length - 1 && length > bestLength) {
                bestLength = length;
                bestStart = numbers.length - length;
            }
        }

        StringBuilder output = new StringBuilder();
        for (int i = bestStart; i < bestStart + bestLength; i++) {
            output.append(numbers[i]).append(" ");
        }
        System.out.println(output.toString().trim());

    }
}
