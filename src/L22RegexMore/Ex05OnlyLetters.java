package L22RegexMore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex05OnlyLetters {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        String[] tokens = Arrays.stream(input.split("[0-9]+"))
                .filter(s -> ! s.isEmpty())
                .toArray(String[]::new);

        processBeginning(input, tokens);
        processEnd(input, tokens);

        for (int i = 1; i < tokens.length; i++) {
            tokens[i] = String.format("%c%s", tokens[i].charAt(0), tokens[i]);
        }

        System.out.println(String.join("", tokens));

    }

    private static void processEnd(String input, String[] tokens) {
        int index = input.lastIndexOf(tokens[tokens.length - 1]);
        if (index >= 0) {
            tokens[tokens.length - 1] = input.substring(index);
        }
    }

    private static void processBeginning(String input, String[] tokens) {
        if (Character.isDigit(input.charAt(0))) {
            tokens[0] = String.format("%c%s", tokens[0].charAt(0), tokens[0]);
        }
    }
}
