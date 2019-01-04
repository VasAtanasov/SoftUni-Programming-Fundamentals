package L13Lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex04SpiltByWordCasing01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String regex = "[\\\\,;:.!/()\"'\\[\\] ]";
        List<String> input = Arrays.stream(reader.readLine().split(regex)).filter(e -> !e.equals("")).collect(Collectors.toList());

        List<String> lowerCase = input.stream().filter(Ex04SpiltByWordCasing01::isLowerCase).collect(Collectors.toList());
        List<String> upperCase = input.stream().filter(Ex04SpiltByWordCasing01::isUpperCase).collect(Collectors.toList());
        List<String> mixedCase = input.stream().filter(Ex04SpiltByWordCasing01::isMixed).collect(Collectors.toList());

        System.out.println("Lower-case: " + lowerCase.stream().collect(Collectors.joining(", ")));
        System.out.println("Mixed-case: " + mixedCase.stream().collect(Collectors.joining(", ")));
        System.out.println("Upper-case: " + upperCase.stream().collect(Collectors.joining(", ")));

    }

    private static boolean isMixed(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (isUpperCase(s) || isLowerCase(s)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isUpperCase(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (! Character.isUpperCase(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isLowerCase(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (! Character.isLowerCase(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
