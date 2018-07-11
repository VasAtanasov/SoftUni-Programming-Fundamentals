package Z_ExamsExtendet.exam30Apr2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex03WormHole {
    private static BufferedReader reader;
    private static int[] numbers;
    private static int index;
    private static int steps;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        receiveInput();
        while (index != numbers.length) {
            int value = numbers[index];
            if (value != 0) {
                numbers[index] = 0;
                index = value;
            } else {
                index++;
                steps++;
            }
        }

        System.out.println(steps);

    }

    private static void receiveInput() throws IOException {
        numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
