package L22RegexExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Ex08UseYourChains {
    private static final String REGEX;
    private static Pattern pattern;
    private static List<String> matches;
    private static BufferedReader reader;

    static {
        REGEX = "<p>(?<text>.+?)<\\/p>";
        pattern = Pattern.compile(REGEX);
        matches = new ArrayList<>();
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        processSting();
        matches.forEach(System.out::print);

    }

    private static void processSting() throws IOException {
        String input = reader.readLine();
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            String text = Arrays.stream(matcher.group("text")
                    .replaceAll("[^a-z0-9]", " ")
                    .replaceAll(" +", " ")
                    .split(""))
                    .map(s -> mapLetter(s))
                    .collect(Collectors.joining(""));
            matches.add(text);
        }
    }

    private static String mapLetter(String letter) {
        char ch = letter.charAt(0);
        if (letter.matches("[a-m]")) {
            ch += 13;
        } else if (letter.matches("[n-z]")) {
            ch -= 13;
        }
        return String.format("%c", ch);
    }
}
