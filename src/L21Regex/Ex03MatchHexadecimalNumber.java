package L21Regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Ex03MatchHexadecimalNumber {
    private static final String REGEX;
    private static List<String> matches;
    private static Pattern pattern;
    private static BufferedReader reader;

    static {
        REGEX = "\\b(?:0x)?[0-9A-F]+\\b";
        matches = new ArrayList<>();
        pattern = Pattern.compile(REGEX);
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        String input = reader.readLine();
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            matches.add(matcher.group());
        }

        System.out.println(matches.stream().collect(Collectors.joining(" ")));
    }
}
