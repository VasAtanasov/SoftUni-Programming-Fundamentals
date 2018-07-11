package L06ConditionalAndLoopsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex12TestNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        int inputSum = Integer.parseInt(reader.readLine());
        int sum = 0;
        int combinationsCount = 0;

        for (int i = n; i > 0; i--) {
            for (int j = 1; j <= m; j++) {
                sum += (3 * (i * j));
                combinationsCount++;
                if (sum >= inputSum) {
                    System.out.println(String.format("%d combinations", combinationsCount));
                    System.out.println(String.format("Sum: %d >= %d", sum, inputSum));
                    return;
                }
            }
        }

        System.out.println(String.format("%d combinations", combinationsCount));
        System.out.println(String.format("Sum: %d",sum));

    }
}
