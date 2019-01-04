package L12ArraysExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex03FoldAndSum01 {
    private static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] result = new int[numbers.length/2];

        int k = numbers.length / 4;

        for (int i = 0; i < k; i++) {
            result[i] = numbers[k - 1 - i] + numbers[k + i];
            result[i + k] = numbers[numbers.length - 1 - i] + numbers[2 * k + i];
        }

        printArray(result);
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i == array.length - 1) {
                break;
            }
            System.out.print(" ");
        }
    }
}
