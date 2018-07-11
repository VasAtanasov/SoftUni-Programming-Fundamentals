package L10MethodsAndDebuggingExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex04NumberInReverseOrder {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        boolean isNegative = false;
        if (input.contains("-")) {
            isNegative = true;
            input = input.replace("-", "");
        }

        String reversedNumber = getReversed(input);
        if (isNegative) {
            reversedNumber = "-" + reversedNumber;
        }

        System.out.println(reversedNumber);

    }

    private static String getReversed(String input) {
        return new StringBuilder(input).reverse().toString();
    }
}
