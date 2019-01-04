package L09MethodsAndDebugging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex09MultiplyEvensByOdds {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        int oddSum = 0;
        int evenSum = 0;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (Character.isDigit(ch)) {
                int digit = ch - 48;

                if (digit % 2 == 0) {
                    evenSum += digit;
                } else {
                    oddSum += digit;
                }
            }
        }

        System.out.println(oddSum * evenSum);
    }
}
