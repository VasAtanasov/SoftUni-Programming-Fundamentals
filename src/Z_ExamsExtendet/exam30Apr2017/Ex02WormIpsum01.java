package Z_ExamsExtendet.exam30Apr2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Ex02WormIpsum01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String regex = "^([A-Z][^.?!]*)[.!?:;]$";
        String input = reader.readLine();
        while (!"Worm Ipsum".equals(input)) {
            if (Pattern.matches(regex, input)) {
                String sentence = changeWords(input);
                System.out.println(sentence);
            }
            input = reader.readLine();
        }
    }

    private static String changeWords(String words) {
        String wordRegex = "[^\\s,\\.:;'\\-()_]*";
        Pattern pattern = Pattern.compile(wordRegex);
        Matcher matcher = pattern.matcher(words);

        while (matcher.find()) {
            String word = matcher.group();
            List<String> letters = Arrays.stream(word.split(""))
                    .distinct()
                    .collect(Collectors.toList());
            long count = 0;
            String letter = "";

            for (int j = 0; j < letters.size(); j++) {
                int index = j;
                long letterCount = Arrays.stream(word.split(""))
                        .filter(e -> e.equals(letters.get(index)))
                        .count();
                if (letterCount > count && letterCount >= 2) {
                    count = letterCount;
                    letter = letters.get(index);
                }
            }

            if (count >= 2) {
                words = words.replace(word, generateWord(letter, word.length()));
            }
        }
        return words;
    }

    private static String generateWord(String letter, int length) {
        StringBuilder generate = new StringBuilder();
        for (int i = 0; i < length; i++) {
            generate.append(letter);
        }
        return generate.toString();
    }
}

