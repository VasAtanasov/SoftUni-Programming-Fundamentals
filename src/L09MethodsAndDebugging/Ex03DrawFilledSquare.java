package L09MethodsAndDebugging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex03DrawFilledSquare {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        printHeaderOrFooter(n);
        printMiddle(n);
        printHeaderOrFooter(n);


    }

    private static void printMiddle(int n) {
        for (int i = 0; i < n - 2; i++) {
            System.out.print("-");
            System.out.print(generateFrom("\\/", n - 1));
            System.out.println("-");
        }
    }

    private static void printHeaderOrFooter(int n) {
        System.out.println(generateFrom("-", 2 * n));
    }

    private static String generateFrom(String input, int times) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < times; i++) {
            builder.append(input);
        }
        return builder.toString();
    }
}
