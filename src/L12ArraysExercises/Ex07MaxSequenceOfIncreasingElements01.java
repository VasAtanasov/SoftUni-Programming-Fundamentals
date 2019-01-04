package L12ArraysExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Ex07MaxSequenceOfIncreasingElements01 {
    private static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int len = 1;
        int bestLen = 0;
        int index = 0;

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] < numbers[i + 1]) {
                len++;
                if (len > bestLen) {
                    bestLen = len;
                    index = i + 1;
                }
            } else {
                len = 1;
            }
        }

        int[] result = new int[bestLen];
        for (int i = 0; i < result.length; i++) {
            result[i] = numbers[index - bestLen + 1];
            index++;
        }

        System.out.println(Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }
}
