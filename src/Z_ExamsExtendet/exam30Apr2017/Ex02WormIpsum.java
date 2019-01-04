package Z_ExamsExtendet.exam30Apr2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex02WormIpsum {
    private static BufferedReader reader;
    private static final String SENTENCE_REGEX;
    private static final String WORD_REGEX;
    private static Pattern pattern;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        SENTENCE_REGEX = "^(?<sentence>[A-Z][^.!?\\n]*?)(?<mark>[.!?])$";
        WORD_REGEX = "(?<word>[A-Za-z0-9_-]+)";
        pattern = Pattern.compile(WORD_REGEX);
    }

    public static void main(String[] args) throws IOException {
        String sentence;
        while (! "Worm Ipsum".equals(sentence = reader.readLine())) {
            if (! sentence.matches(SENTENCE_REGEX)) {
                continue;
            }

            Matcher matcher = pattern.matcher(sentence);

            while (matcher.find()) {
                String match = matcher.group("word");
                String word = processWord(match);
                sentence = sentence.replace(match, word);
            }

            System.out.println(sentence);

        }

    }

    private static String processWord(String word) {
        Map<Character, Integer> characters = new LinkedHashMap<>();
        char[] chars = word.toCharArray();

        for (char character : chars) {
            characters.putIfAbsent(character, 0);
            characters.put(character, characters.get(character) + 1);
        }

        Optional<Character> character = characters.entrySet()
                .stream()
                .filter(c -> c.getValue() > 1)
                .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                .map(Map.Entry::getKey)
                .findFirst();

        return character
                .map(character1 -> generateFrom(character1, word.length()))
                .orElse(word);

    }

    private static String generateFrom(char input, int times) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < times; i++) {
            builder.append(input);
        }
        return builder.toString();
    }
}
