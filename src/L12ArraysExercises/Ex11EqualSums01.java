package L12ArraysExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex11EqualSums01 {
    private static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int index = - 1;

        for (int i = 0; i < numbers.length; i++) {
            int leftSum = getLeftSum(i);
            int rightSum = getRightSum(i);

            if (leftSum == rightSum) {
                index = i;
            }
        }

        if (index < 0) {
            System.out.println("no");
        } else {
            System.out.println(index);
        }
    }

    private static int getRightSum(int index) {
        int sum = 0;
        for (int i = index + 1; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    private static int getLeftSum(int index) {
        int sum = 0;
        for (int i = 0; i < index; i++) {
            sum += numbers[i];
        }
        return sum;
    }
}
