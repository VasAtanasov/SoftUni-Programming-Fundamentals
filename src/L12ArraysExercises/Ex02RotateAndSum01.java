package L12ArraysExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex02RotateAndSum01 {
    private static int[] numbers;
    private static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        result = new int[numbers.length];
        int times = Integer.parseInt(reader.readLine());

        for (int i = 0; i < times; i++) {
            rotateToRight();
            sumArrays();
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

    private static void sumArrays() {
        for (int i = 0; i < numbers.length; i++) {
            result[i] += numbers[i];
        }
    }

    private static void rotateToRight() {
        int lastElement = numbers[numbers.length - 1];
        for (int j = numbers.length - 1; j >= 1; j--) {
            numbers[j] = numbers[j - 1];
        }
        numbers[0] = lastElement;
    }
}
