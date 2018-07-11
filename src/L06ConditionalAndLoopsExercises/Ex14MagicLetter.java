package L06ConditionalAndLoopsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex14MagicLetter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char c1 = reader.readLine().charAt(0);
        char c2 = reader.readLine().charAt(0);
        char c3 = reader.readLine().charAt(0);
        StringBuilder output = new StringBuilder();

        for (char i = c1; i <= c2; i++) {
            for (char j = c1; j <= c2; j++) {
                for (char k = c1; k <= c2; k++) {
                    if (i == c3 || j == c3 || k == c3) {
                        continue;
                    }
                    output.append(String.format("%c%c%c", i, j, k)).append(" ");
                }
            }
        }

        System.out.println(output.toString().trim());
    }
}
