package Z_Exams.exam25Apr2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex02MemoryView01 {
    private static List<Integer> codes;
    private static List<String> words;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        codes = new ArrayList<>();

        receiveInput(reader);
        getWords();

        words.forEach(System.out::println);

    }

    private static void getWords() {
        words = new ArrayList<>();
        for (int i = 0; i < codes.size() - 2; i++) {
            int numOne = codes.get(i);
            int numTwo = codes.get(i + 1);
            int numThree = codes.get(i + 2);

            if (numOne == 32656 && numTwo == 19759 && numThree == 32763) {
                StringBuilder word = new StringBuilder();
                int length = codes.get(i + 4);
                int index = i + 6;
                for (int j = 0; j < length; j++) {
                    word.append((char) codes.get(index).intValue());
                    index++;
                    i = index;
                }
                words.add(word.toString());
            }
        }
    }

    private static void receiveInput(BufferedReader reader) throws IOException {
        String input;
        while (! "Visual Studio crash".equals(input = reader.readLine())) {
            codes.addAll(Arrays.stream(input.split("\\s+"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toCollection(ArrayList::new)));
        }
    }
}

