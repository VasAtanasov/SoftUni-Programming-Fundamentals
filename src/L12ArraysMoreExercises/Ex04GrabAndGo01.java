package L12ArraysMoreExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex04GrabAndGo01 {
    private static long[] numbers;
    private static long number;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToLong(Integer::parseInt)
                .toArray();
        number = Long.parseLong(reader.readLine());
        int index = getIndex();

        if (index == - 1) {
            System.out.println("No occurrences were found!");
        } else {
            System.out.println(getSum(index));
        }

    }

    private static long getSum(int index) {
        long sum = 0;
        for (int i = 0; i < index; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    public static int getIndex() {
        for (int i = numbers.length - 1; i >= 0; i--) {
            if (numbers[i] == number) {
                return i;
            }
        }

        return - 1;
    }
}
