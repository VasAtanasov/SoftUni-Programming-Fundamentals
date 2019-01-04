package Z_Exams.exam05Nov2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex03AnonymousVox {
    private static BufferedReader reader;
    private static final String REGEX;
    private static Pattern pattern;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        REGEX = "(?<start>[A-Za-z]+)(?<placeHolder>.+)\\1";
        pattern = Pattern.compile(REGEX);
    }

    public static void main(String[] args) throws IOException {
        String input = reader.readLine();
        String[] placeHolders = Arrays.stream(reader.readLine().split("[{}]"))
                .filter(s -> !s.isEmpty())
                .toArray(String[]::new);
        Matcher matcher = pattern.matcher(input);

        int index = 0;
        while (matcher.find() && index < placeHolders.length) {
            int start = input.indexOf(matcher.group());
            int end = matcher.group().length() + start;
            String replacer = matcher.group("start") + placeHolders[index++] + matcher.group("start");
            input = input.substring(0, start) + replacer + input.substring(end);
        }

        System.out.println(input);

    }
}
