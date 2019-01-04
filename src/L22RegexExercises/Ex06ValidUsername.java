package L22RegexExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex06ValidUsername {
    private static final String REGEX;
    private static List<String> userNames;
    private static BufferedReader reader;

    static {
        REGEX = "\\b(?<username>[A-Za-z][A-Za-z0-9_]{2,25})\\b";
        userNames = new ArrayList<>();
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        userNames = Arrays.stream(reader.readLine().split("[\\/(\\\\)\\s]+"))
                .filter(s -> s.matches(REGEX))
                .collect(Collectors.toCollection(ArrayList::new));

        String bestUsernameOne = "";
        String bestUsernameTwo = "";
        int bestLength = 0;

        for (int i = 0; i < userNames.size() - 1; i++) {
            String usernameOne = userNames.get(i);
            String usernameTwo = userNames.get(i + 1);
            int length = usernameOne.length() + usernameTwo.length();
            if (length > bestLength) {
                bestLength = length;
                bestUsernameOne = usernameOne;
                bestUsernameTwo = usernameTwo;
            }

        }

        System.out.println(bestUsernameOne);
        System.out.println(bestUsernameTwo);


    }
}
