package L12ArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class Ex02RotateAndSum {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int timesRotate = Integer.parseInt(scanner.nextLine());

        int[] sum = new int[numbers.length];

        for (int i = 0; i < timesRotate; i++) {

            numbers = rotateIntArray(numbers);

            for (int j = 0; j < sum.length; j++) {
                sum[j] = sum[j] + numbers[j];
            }

        }

        printIntArray(sum);

    }

    private static int[] rotateIntArray(int[] numbers) {
        int lastNumber = numbers[numbers.length - 1];
        int[] rotated = new int[numbers.length];
        rotated[0] = lastNumber;
        System.arraycopy(numbers, 0, rotated, 1, numbers.length - 1);

        return rotated;
    }

    private static void printIntArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i == array.length - 1) {
                break;
            }
            System.out.print(" ");
        }
    }
}
