package L22RegexExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex05KeyReplacer {
    private static final String REGEX_START_KEY;
    private static final String REGEX_END_KEY;
    private static Pattern patternStartKey;
    private static Pattern patternEndKey;
    private static BufferedReader reader;

    static {
        REGEX_START_KEY = "^[A-Za-z]+(?=[\\|<\\\\])";
        REGEX_END_KEY = "(?<=[\\|<\\\\])[A-Za-z]+$";
        patternStartKey = Pattern.compile(REGEX_START_KEY);
        patternEndKey = Pattern.compile(REGEX_END_KEY);
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        String keys = reader.readLine();
        String input = reader.readLine();

        String startKey = takeKey(patternStartKey.matcher(keys));
        String endKey = takeKey(patternEndKey.matcher(keys));

        String stringRegex = String.format("%s(?<string>.*?)%s", startKey, endKey);
        Pattern stringPattern = Pattern.compile(stringRegex);
        Matcher stringMatcher = stringPattern.matcher(input);
        StringBuilder output = new StringBuilder();
        while (stringMatcher.find()) {
            output.append(stringMatcher.group("string"));
        }

        if (output.toString().isEmpty()) {
            System.out.println("Empty result");
        } else {
            System.out.println(output.toString());

        }
    }

    private static String takeKey(Matcher matcher) {
        if (matcher.find()) {
            return matcher.group();
        }
        return "";
    }
}
