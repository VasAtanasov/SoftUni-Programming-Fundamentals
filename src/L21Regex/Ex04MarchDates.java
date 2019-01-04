package L21Regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex04MarchDates {
    private static final String REGEX;
    private static List<String> matches;
    private static Pattern pattern;
    private static BufferedReader reader;

    static {
        REGEX = "\\b(?<day>[0-9]{2})([.\\/-])(?<month>[A-Z][a-z]{2})\\2(?<year>[0-9]{4})\\b";
        matches = new ArrayList<>();
        pattern = Pattern.compile(REGEX);
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        String input = reader.readLine();
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            String day = matcher.group("day");
            String month = matcher.group("month");
            String year = matcher.group("year");

            matches.add(String.format("Day: %s, Month: %s, Year: %s",day,month,year));
        }

        matches.forEach(System.out::println);
    }
}
