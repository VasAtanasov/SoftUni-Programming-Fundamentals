package L11Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex03LastKNumbersSumsSequence01 {
    private static BufferedReader reader;
    private static long[] numbers;
    private static int n;
    private static int k;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(reader.readLine());
        k = Integer.parseInt(reader.readLine());
        initializeArray();
        printArray();
    }

    private static void initializeArray() {
        numbers = new long[n];
        numbers[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = Math.max(0, i - k); j <= i - 1; j++) {
                numbers[i] += numbers[j];
            }
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
