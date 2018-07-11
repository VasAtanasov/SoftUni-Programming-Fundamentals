package L10MethodsAndDebuggingExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex05FibonacciNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long n = Integer.parseInt(reader.readLine());
        System.out.println(fibonacci(n));
    }

    private static long fibonacci(long n) {
        int first = 1;
        int second = 1;
        for (int i = 0; i < n - 1; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}
