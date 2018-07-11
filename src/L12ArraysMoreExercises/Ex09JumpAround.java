package L12ArraysMoreExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex09JumpAround {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();

        long sum = 0;

        int currentIndex = 0;
        while (true) {

            if (canMoveRight(numbers.length - 1, numbers[currentIndex], currentIndex)) {
                sum += numbers[currentIndex];
                int steps = numbers[currentIndex];
                currentIndex += steps;
                continue;
            }

            if (canMoveLeft(numbers[currentIndex], currentIndex)) {
                sum += numbers[currentIndex];
                int steps = numbers[currentIndex];
                currentIndex -= steps;
                continue;
            }

            sum += numbers[currentIndex];
            System.out.println(sum);
            return;

        }

    }

    private static boolean canMoveLeft(int value, int currentIndex) {
        int nextIndex = currentIndex - value;
        return nextIndex >= 0;
    }

    private static boolean canMoveRight(int lastIndex, int value, int currentIndex) {
        int nextIndex = currentIndex + value;
        return nextIndex <= lastIndex;
    }
}
