package L12ArraysMoreExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex09JumpAround01 {
    private static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sum = 0;
        int currentIndex = 0;
        while (true) {
            int value = numbers[currentIndex];
            sum += value;
            if (canMoveRight(currentIndex + value)) {
                currentIndex = currentIndex + value;
            } else if (canMoveLeft(currentIndex - value)) {
                currentIndex = currentIndex - value;
            } else {
                System.out.println(sum);
                return;
            }
        }
    }

    private static boolean canMoveLeft(int nextIndex) {
        return nextIndex >= 0;
    }

    private static boolean canMoveRight(int nextIndex) {
        return nextIndex < numbers.length;
    }
}
