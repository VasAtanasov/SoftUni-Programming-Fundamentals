package L11Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex04TripleSum01 {
    private static BufferedReader reader;
    private static int[] numbers;
    private static int counter;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        counter = 0;
//        numbers = new int[] {1, 1, 1, 1};
//        numbers = new int[] {4, 2, 8, 6};
//        numbers = new int[] {2, 7, 5, 0};
//        numbers = new int[] {3, 1, 5, 6, 1, 2};
    }

    public static void main(String[] args) throws IOException {
        numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int a = numbers[i];
                int b = numbers[j];
                int c = a + b;
                if (anyMatch(c)) {
                    System.out.println(String.format("%d + %d == %d", a, b, c));
                    counter++;
                }
            }
        }

        if (counter == 0) {
            System.out.println("No");
        }
    }

    private static boolean anyMatch(int c) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == c) {
                return true;
            }
        }
        return false;
    }
}
