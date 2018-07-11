package L11Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex02ReverseAnArrayOfIntegers01 {
    private static int[] numbers;
    private static int n;
    private static BufferedReader reader;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(reader.readLine());
        numbers = new int[n];
        fillArrayReversed();
        printArray();
    }

    private static void fillArrayReversed() throws IOException {
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(reader.readLine());
            numbers[n - 1 - i] = number;
        }
    }

    private static void printArray() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(numbers[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
