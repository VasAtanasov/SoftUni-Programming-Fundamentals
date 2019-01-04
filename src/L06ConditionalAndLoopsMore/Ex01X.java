package L06ConditionalAndLoopsMore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex01X {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n / 2; i++) {
            System.out.print(generateFrom(" ", i));
            System.out.print("x");
            System.out.print(generateFrom(" ", n - 2 - i * 2));
            System.out.println("x");
        }

        System.out.print(generateFrom(" ", n / 2));
        System.out.println("x");

        for (int i = n / 2 -1; i >= 0; i--) {
            System.out.print(generateFrom(" ", i));
            System.out.print("x");
            System.out.print(generateFrom(" ", n - 2 - i * 2));
            System.out.println("x");
        }

    }

    private static String generateFrom(String input, int times) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < times; i++) {
            builder.append(input);
        }
        return builder.toString();
    }

}
