package L19StringAndText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Ex03TextFilter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> banedList = createMap(reader.readLine().split(", "));
        String input = reader.readLine();

        for (Map.Entry<String, String> words : banedList.entrySet()) {
            input = input.replaceAll(words.getKey(), words.getValue());
        }

        System.out.println(input);

    }

    private static Map<String, String> createMap(String[] words) {
        Map<String, String> bannedList = new HashMap<>();
        for (String word : words) {
            bannedList.put(word, generateFrom("*", word.length()));
        }
        return bannedList;
    }

    private static String generateFrom(String input, int times) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < times; i++) {
            builder.append(input);
        }
        return builder.toString();
    }
}
