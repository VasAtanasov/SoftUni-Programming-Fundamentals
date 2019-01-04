package L21Regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Ex01MatchFullName {
    private static final String REGEX;
    private static List<String> matches;
    private static Pattern pattern;

    static {
        REGEX = "\\b[A-Z][a-z]+ [A-Z][a-z]+\\b";
        matches = new ArrayList<>();
        pattern = Pattern.compile(REGEX);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            matches.add(matcher.group());
        }

        System.out.println(matches.stream().collect(Collectors.joining(" ")));

    }
}
