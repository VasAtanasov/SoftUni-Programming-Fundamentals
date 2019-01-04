package L06ConditionalAndLoopsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex13GameOfNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        int magicNumber = Integer.parseInt(reader.readLine());

        int combinationsCount = 0;
        boolean isMagicNumber = false;
        String output = "";

        for (int i = n; i <= m; i++) {
            for (int j = n; j <= m; j++) {
                if (i + j == magicNumber) {
                    isMagicNumber = true;
                    output = String.format("%d + %d = %d", i, j, i + j);
                }
                combinationsCount++;
            }
        }

        if (isMagicNumber) {
            System.out.println(String.format("Number found! %s", output));
        } else {
            System.out.println(String.format("%d combinations - neither equals %d", combinationsCount, magicNumber));
        }

    }
}
