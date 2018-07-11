package L12ArraysExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex10PairsByDifference01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int diff = Integer.parseInt(reader.readLine());
        int count = 0;

        for (int i = 0; i < numbers.length - 1; i++) {
            int firstNumber = numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                int nextNumber = numbers[j];
                if (Math.abs(firstNumber - nextNumber) == diff) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
