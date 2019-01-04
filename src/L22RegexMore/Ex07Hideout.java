package L22RegexMore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex07Hideout {
    private static final String SPECIAL_CHARACTERS = "<([{\\^-=$!|]})?*+.>";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        while (true) {
            String[] tokens = reader.readLine().split("\\s+");
            String character = tokens[0];
            int count = Integer.parseInt(tokens[1]);

            if (SPECIAL_CHARACTERS.contains(character)) {
                character = "\\" + character;
            }
            String regex = String.format("%s{%d,}", character, count);
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                int index = input.indexOf(matcher.group());
                int length = matcher.group().length();
                System.out.println(String.format("Hideout found at index %d and it is with size %d!", index, length));
                return;
            }
        }
    }
}
