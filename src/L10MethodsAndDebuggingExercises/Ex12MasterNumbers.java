package L10MethodsAndDebuggingExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex12MasterNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        long number = Long.parseLong(input);
        for (long i = 1; i < number; i++) {
            if (isPalindrome(i) && isEvenDigit(i) && isDivisibleBySeven(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean isEvenDigit(long number) {
        while (number > 0) {
            long digit = number % 10;
            if (digit % 2 == 0) {
                return true;
            }
            number /= 10;
        }
        return false;
    }

    private static boolean isDivisibleBySeven(long number) {
        long sum = 0;
        while (number > 0) {
            sum += (number % 10);
            number /= 10;
        }
        return sum % 7 == 0;
    }

    private static boolean isPalindrome(String input) {
        StringBuilder reversed = new StringBuilder(input).reverse();
        return reversed.toString().equals(input);
    }

    private static boolean isPalindrome(long number) {
        long originalNumber = number;
        StringBuilder reversedString = new StringBuilder();
        while (number > 0) {
            long digit = number % 10;
            reversedString.append(digit);
            number /= 10;
        }
        long reversed = Long.parseLong(reversedString.toString());
        return originalNumber == reversed;
    }
}
