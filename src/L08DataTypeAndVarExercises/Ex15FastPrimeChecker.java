package L08DataTypeAndVarExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex15FastPrimeChecker {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        for (int i = 2; i <= number; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            System.out.println(String.format("%d -> %s", i, refactor(isPrime)));
        }

    }

    private static String refactor(boolean isPrime) {
        StringBuilder sb = new StringBuilder(String.valueOf(isPrime));
        String firstLetter = String.valueOf(sb.charAt(0)).toUpperCase();
        sb.setCharAt(0, firstLetter.charAt(0));
        return sb.toString();
    }
}
