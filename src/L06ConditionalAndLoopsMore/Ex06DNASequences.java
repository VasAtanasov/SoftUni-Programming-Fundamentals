package L06ConditionalAndLoopsMore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Ex06DNASequences {
    private static List<String> letters = Arrays.asList("", "A", "C", "G", "T");

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int matchSum = Integer.parseInt(reader.readLine());
        StringBuilder output = new StringBuilder();
        int count = 0;

        StringBuilder combination = new StringBuilder();
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                for (int k = 1; k <= 4; k++) {
                    int sum = i + j + k;
                    combination.append("X")
                            .append(String.format("%s%s%s", letters.get(i), letters.get(j), letters.get(k)))
                            .append("X");

                    if (sum >= matchSum) {
                        combination.setCharAt(0, 'O');
                        combination.setCharAt(4, 'O');
                    }

                    count++;
                    if (count % 4 == 0) {
                        combination.append(System.lineSeparator());
                    } else {
                        combination.append(" ");
                    }
                    output.append(combination);
                    combination = new StringBuilder();
                }
            }
        }

        System.out.println(output);
    }
}
