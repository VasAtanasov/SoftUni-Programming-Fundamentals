package Z_ExamsExtendet.exam09May2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Ex02SpyGram {
    private static BufferedReader reader;
    private static int[] keys;
    private static final String REGEX;
    private static Pattern pattern;
    private static Map<String, List<String>> messages;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        REGEX = "^TO: (?<recipient>[A-Z]+); MESSAGE: (?<message>[^\\n]+);$";
        pattern = Pattern.compile(REGEX);
        messages = new TreeMap<>();
    }

    public static void main(String[] args) throws IOException {
        getKeys();

        String input;
        while (! "END".equals(input = reader.readLine())) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String recipient = matcher.group("recipient");
                String message = mapMessage(input);

                messages.putIfAbsent(recipient, new ArrayList<>());
                messages.get(recipient).add(message);
            }
        }

        messages.values().forEach(m -> m.forEach(System.out::println));

    }

    private static String mapMessage(String input) {
        int[] chars = input
                .chars()
                .toArray();

        int index = 0;
        for (int i = 0; i < input.length(); i++) {
            chars[i] += keys[index];
            index = (index + 1) % keys.length;
        }

        return Arrays.stream(chars)
                .mapToObj(value -> String.format("%c", value))
                .collect(Collectors.joining(""));
    }

    private static void getKeys() throws IOException {
        keys = Arrays.stream(reader.readLine().split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
