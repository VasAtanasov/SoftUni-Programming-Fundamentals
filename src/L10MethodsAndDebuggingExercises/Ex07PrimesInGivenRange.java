package L10MethodsAndDebuggingExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex07PrimesInGivenRange {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long start = Long.parseLong(reader.readLine());
        long end = Long.parseLong(reader.readLine());
        String primes = getPrimeList(start, end);
        System.out.println(primes);

    }

    private static String getPrimeList(long start, long end) {
        StringBuilder output = new StringBuilder();
        for (long i = start; i <= end; i++) {
            if (isPrime(i)) {
                output.append(i).append(", ");
            }
        }
        return output.toString().substring(0, output.length() - 2);
    }

    private static boolean isPrime(long n) {
        if (n == 0 || n == 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
