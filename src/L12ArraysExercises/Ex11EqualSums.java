package L12ArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class Ex11EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        if (input.length == 1) {
            System.out.println("0");
            return;
        }

        input = insertZeroes(input);
        boolean isIndex = false;

        for (int i = 1; i < input.length - 1; i++) {

            int leftSum = sumLeft(input, i);
            int rightSum = sumRight(input, i);
            if (rightSum == leftSum) {
                System.out.println(i - 1);
                isIndex = true;
            }
        }

        if (!isIndex) {
            System.out.println("no");
        }
    }

    private static int[] insertZeroes(int[] input) {
        int[] newArray = new int[input.length + 2];
        newArray[0] = 0;
        System.arraycopy(input, 0, newArray, 1, input.length);
        newArray[newArray.length - 1] = 0;
        return newArray;
    }

    private static int sumLeft(int[] input, int i) {
        int sumLeft = 0;
        for (int j = i - 1; j >= 0; j--) {
            sumLeft += input[j];
        }
        return sumLeft;
    }

    private static int sumRight(int[] input, int i) {
        int sumRight = 0;
        for (int j = i + 1; j < input.length; j++) {
            sumRight += input[j];
        }
        return sumRight;
    }
}
