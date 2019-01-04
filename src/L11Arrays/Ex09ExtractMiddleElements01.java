package L11Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex09ExtractMiddleElements01 {
    private static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int length = numbers.length;

        if (length == 1) {
            System.out.println(numbers[0]);
        } else if (length % 2 == 0) {
            System.out.println(String.format("{ %d, %d }", numbers[length / 2 - 1], numbers[length / 2]));
        } else {
            System.out.println(String.format("{ %d, %d, %d }", numbers[length / 2 - 1], numbers[length / 2], numbers[length / 2 + 1]));
        }
    }
}
