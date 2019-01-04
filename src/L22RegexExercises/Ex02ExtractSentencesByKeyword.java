package L22RegexExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex02ExtractSentencesByKeyword {
    private static final String REGEX_SENTENCE;
    private static String REGEX_KEYWORD;
    private static List<String> matches;
    private static Pattern pattern;
    private static BufferedReader reader;

    static {
        REGEX_SENTENCE = "[^.!?]+";
        matches = new ArrayList<>();
        pattern = Pattern.compile(REGEX_SENTENCE);
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        REGEX_KEYWORD = String.format("(?<=[^A-Za-z])%s(?=[^A-Za-z])", reader.readLine());
        Pattern patternKeyword = Pattern.compile(REGEX_KEYWORD);
        String input = reader.readLine();
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            Matcher matcherKeyword = patternKeyword.matcher(matcher.group());
            if (matcherKeyword.find()) {
                matches.add(matcher.group().trim());
            }
        }
        matches.forEach(System.out::println);
    }
}
