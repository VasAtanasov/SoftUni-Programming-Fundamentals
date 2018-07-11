package L10MethodsAndDebuggingExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Ex14FactorialTrailingZeroes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        BigInteger factorial = getFactorial(n);
        int count = countTrailingZeroes(factorial);

        System.out.println(count);
    }

    private static int countTrailingZeroes(BigInteger factorial) {
        int count = 0;
        while (true) {
            BigInteger digit = factorial.mod(BigInteger.TEN);
            if (digit.equals(BigInteger.ZERO)) {
                count++;
            } else {
                break;
            }
            factorial = factorial.divide(BigInteger.TEN);
        }
        return count;
    }

    private static BigInteger getFactorial(int n) {
        BigInteger factorial = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }
}
