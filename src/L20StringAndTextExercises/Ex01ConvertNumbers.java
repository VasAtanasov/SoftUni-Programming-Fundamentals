package L20StringAndTextExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Ex01ConvertNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BigInteger[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(BigInteger::new)
                .toArray(BigInteger[]::new);

        System.out.println(baseConverter(numbers[1], numbers[0]));

    }

    private static String baseConverter(BigInteger decNumber, BigInteger base) {
        String digits = "0123456789ABCDEF";

        Deque<Integer> numbers = new ArrayDeque<>();

        while (decNumber.compareTo(BigInteger.ZERO) > 0) {
            int number = decNumber.mod(base).intValue();
            numbers.addLast(number);
            decNumber = decNumber.divide(base);
        }

        StringBuilder newString = new StringBuilder();
        while (! numbers.isEmpty()) {
            char digit = digits.charAt(numbers.removeLast());
            newString.append(digit);
        }

        return newString.toString();
    }

}
