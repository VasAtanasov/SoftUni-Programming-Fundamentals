package L21Regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex06ReplaceTag {
    private static final String REGEX;
    private static List<String> matches;
    private static Pattern pattern;
    private static BufferedReader reader;

    static {
        REGEX = "<a ?href=.*?>.*?<\\/a>";
        matches = new ArrayList<>();
        pattern = Pattern.compile(REGEX);
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {

        String input;
        StringBuilder output = new StringBuilder();
        while (! "end".equals(input = reader.readLine())) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String replace = matcher.group().replaceAll("<a ?", "[URL ").replaceAll("</a", "[/URL").replaceAll(">", "]");
                input = input.replaceAll(matcher.group(),replace);
                output.append(input).append(System.lineSeparator());
            } else {
                output.append(input).append(System.lineSeparator());
            }
        }

        System.out.println(output.toString());


    }
}
