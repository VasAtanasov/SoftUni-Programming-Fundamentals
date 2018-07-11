package L22RegexMore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex08Mines {
    private static final String REGEX;
    private static Pattern pattern;
    private static BufferedReader reader;

    static {
        REGEX = "<(?<power>[^\\s]{2})>";
        pattern = Pattern.compile(REGEX);
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        String input = reader.readLine();
        while (true) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                int power = getPower(matcher.group("power"));
                String replaceRegex = String.format(".{0,%d}<%s>.{0,%d}", power, matcher.group("power"), power);
                Pattern replacePatter = Pattern.compile(replaceRegex);
                Matcher replaceMatcher = replacePatter.matcher(input);

                if (replaceMatcher.find()) {
                    String toReplace = generateFrom("_", replaceMatcher.group().length());
                    input = input.replaceAll(replaceRegex, toReplace);
                }

            } else {
                break;
            }

        }

        System.out.println(input);
    }

    private static int getPower(String power) {
        return Math.abs(power.charAt(0) - power.charAt(1));
    }

    private static String generateFrom(String input, int times) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < times; i++) {
            builder.append(input);
        }
        return builder.toString();
    }
}
