package L20StringAndTextExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex08LettersChangeNumbers {
    private static final String REGEX = "(?<leftLetter>[A-Za-z])(?<number>[0-9]+)(?<rightLetter>[A-Za-z])";
    private static final Pattern pattern = Pattern.compile(REGEX);

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(String.format("%.2f",Arrays.stream(reader.readLine().split("\\s+"))
                .map(s -> mapString(s))
                .reduce(0D, (a, b) -> a + b)));
    }

    private static double mapString(String string) {
        Matcher matcher = pattern.matcher(string);
        if (matcher.find()) {
            String leftLetter = matcher.group("leftLetter");
            String rightLetter = matcher.group("rightLetter");
            double number = Double.parseDouble(matcher.group("number"));

            number = Character.isUpperCase(leftLetter.charAt(0)) ?
                    number / (leftLetter.charAt(0) - 64) :
                    number * (leftLetter.charAt(0) - 96);

            number = Character.isUpperCase(rightLetter.charAt(0)) ?
                    number - (rightLetter.charAt(0) - 64) :
                    number + (rightLetter.charAt(0) - 96);
            return number;
        }

        return 0;
    }
}
