package L22RegexExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ex07QueryMess {
    private static BufferedReader reader;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        String input;
        while (! "END".equals(input = reader.readLine())) {
            Map<String, List<String>> pairs = new LinkedHashMap<>();
            String[] tokens = Arrays.stream(input.split("[&?]"))
                    .filter(s -> ! s.isEmpty())
                    .filter(s -> s.contains("="))
                    .toArray(String[]::new);

            for (String token : tokens) {
                String[] pair = token.split("=");
                String key = getString(pair[0]);
                String value = getString(pair[1]);

                pairs.putIfAbsent(key, new ArrayList<>());
                pairs.get(key).add(value);
            }

            pairs.forEach((key, value) -> System.out.print(String.format("%s=%s", key, value)));
            System.out.println();
        }
    }

    private static String getString(String string) {
        return string
                .replaceAll("\\+|%20", " ")
                .trim()
                .replaceAll(" +", " ");
    }
}
