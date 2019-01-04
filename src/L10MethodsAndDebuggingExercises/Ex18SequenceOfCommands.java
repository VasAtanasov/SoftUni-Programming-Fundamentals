package L10MethodsAndDebuggingExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Ex18SequenceOfCommands {
    private static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String input;
        while (! "stop".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            int index;
            int value;

            switch (command) {
                case "add":
                    index = Integer.parseInt(tokens[1]) - 1;
                    value = Integer.parseInt(tokens[2]);
                    numbers[index] = numbers[index] + value;
                    break;
                case "subtract":
                    index = Integer.parseInt(tokens[1]) - 1;
                    value = Integer.parseInt(tokens[2]);
                    numbers[index] = numbers[index] - value;
                    break;
                case "multiply":
                    index = Integer.parseInt(tokens[1]) - 1;
                    value = Integer.parseInt(tokens[2]);
                    numbers[index] = numbers[index] * value;
                    break;
                case "lshift":
                    leftShift();
                    break;
                case "rshift":
                    rightShift();
                    break;
            }

            System.out.println(Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.joining(" ")));

        }
    }

    private static void rightShift() {
        int lastNumber = numbers[numbers.length - 1];
        for (int i = numbers.length - 1; i > 0; i--) {
            numbers[i] = numbers[i - 1];
        }
        numbers[0] = lastNumber;
    }

    private static void leftShift() {
        int firstNumber = numbers[0];
        for (int i = 0; i < numbers.length - 1; i++) {
            numbers[i] = numbers[i + 1];
        }
        numbers[numbers.length - 1] = firstNumber;
    }
}
