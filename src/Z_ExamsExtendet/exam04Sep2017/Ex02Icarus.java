package Z_ExamsExtendet.exam04Sep2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Ex02Icarus {
    private static BufferedReader reader;
    private static int[] numbers;
    private static int icarusPower;
    private static int index;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        icarusPower = 1;
    }

    public static void main(String[] args) throws IOException {
        readInput();

        String input;
        while (! "Supernova".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            int steps = Integer.parseInt(tokens[1]);

            switch (command) {
                case "left":
                    moveLeft(steps);
                    break;
                case "right":
                    moveRight(steps);
                    break;
            }
        }

        printResult();

    }

    private static void printResult() {
        System.out.println(Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));
    }

    private static void moveRight(int steps) {
        while (steps-- > 0) {
            index++;
            if (index >= numbers.length) {
                index = 0;
                incrementPower();
            }

            damageCell();
        }
    }

    private static void moveLeft(int steps) {
        while (steps-- > 0) {
            index--;
            if (index < 0) {
                index = numbers.length - 1;
                incrementPower();
            }

            damageCell();
        }
    }

    private static void incrementPower() {
        icarusPower++;
    }

    private static void damageCell() {
        numbers[index] -= icarusPower;
    }

    private static void readInput() throws IOException {
        numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        index = Integer.parseInt(reader.readLine());
    }
}
