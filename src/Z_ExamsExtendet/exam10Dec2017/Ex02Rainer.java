package Z_ExamsExtendet.exam10Dec2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Ex02Rainer {
    private static BufferedReader reader;
    private static int[] initial;
    private static int[] numbers;
    private static int index;
    private static int steps;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        steps = 0;
    }

    public static void main(String[] args) throws IOException {
        getInput();

        while (true) {
            decrement();
            if (numbers[index] == 0) {
                break;
            }

            restoreZeroElements();

            index = Integer.parseInt(reader.readLine());
            steps++;
        }

        System.out.println(Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
        System.out.println(steps);

    }

    private static void restoreZeroElements() {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = numbers[i] == 0 ? initial[i] : numbers[i];
        }
    }

    private static void decrement() {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i]--;
        }
    }

    private static void getInput() throws IOException {
        initial = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        index = initial[initial.length - 1];
        numbers = new int[initial.length - 1];
        System.arraycopy(initial, 0, numbers, 0, numbers.length);
    }
}
