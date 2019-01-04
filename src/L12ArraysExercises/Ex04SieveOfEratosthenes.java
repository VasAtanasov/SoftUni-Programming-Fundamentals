package L12ArraysExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex04SieveOfEratosthenes {
    private static boolean[] primes;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine()) + 1;
        if (n > 1) {
            primes = new boolean[n];
            Arrays.fill(primes, true);
            primes[0] = primes[1] = false;

            for (int i = 2; i < Math.sqrt(n); i++) {
                if (primes[i]) {
                    int index = (int) Math.pow(i, 2);
                    int times = 0;
                    while (index + i * times < n) {
                        int j = index + i * times;
                        primes[j] = false;
                        times++;
                    }
                }
            }

            StringBuilder output = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (primes[i]) {
                    output.append(i).append(" ");
                }
            }
            System.out.println(output.toString().trim());
        }
    }
}
