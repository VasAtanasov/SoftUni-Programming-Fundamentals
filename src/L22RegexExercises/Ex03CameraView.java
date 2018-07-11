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

public class Ex03CameraView {
    private static final String REGEX_SENTENCE;
    private static List<String> matches;
    private static Pattern pattern;
    private static BufferedReader reader;

    static {
        REGEX_SENTENCE = "(?<=\\|<)\\w+";
        matches = new ArrayList<>();
        pattern = Pattern.compile(REGEX_SENTENCE);
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        int[] parameters = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int toSkip = parameters[0];
        int toTake = parameters[1];

        String input = reader.readLine();
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String match = Arrays.stream(matcher.group().split(""))
                    .skip(toSkip)
                    .limit(toTake)
                    .collect(Collectors.joining(""));
            matches.add(match);
        }

        System.out.println(matches.stream().collect(Collectors.joining(", ")));
    }
}
