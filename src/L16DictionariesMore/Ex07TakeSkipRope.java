package L16DictionariesMore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex07TakeSkipRope {
    private static List<Integer> digits;
    private static List<Integer> take;
    private static List<Integer> skip;
    private static List<String> symbols;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        filterList(input);
        initializeTakeSkipLists();

        StringBuilder word = new StringBuilder();
        int toSkip = 0;
        int toTake;
        for (int i = 0; i < Math.min(take.size(), skip.size()); i++) {
            toTake = take.get(i);

            word.append(symbols.stream()
                    .skip(toSkip)
                    .limit(toTake)
                    .collect(Collectors.joining("")));

            toSkip += (skip.get(i) + toTake);
        }

        System.out.println(word);
    }

    private static void initializeTakeSkipLists() {
        take = new ArrayList<>();
        skip = new ArrayList<>();
        for (int i = 0; i < digits.size(); i++) {
            if (i % 2 == 0) {
                take.add(digits.get(i));
            } else {
                skip.add(digits.get(i));
            }
        }
    }

    private static void filterList(String input) {
        digits = new ArrayList<>();
        symbols = new ArrayList<>();
        Arrays.stream(input.split(""))
                .forEach(e -> {
                    if (Character.isDigit(e.charAt(0))) {
                        digits.add(Integer.parseInt(e));
                    } else {
                        symbols.add(e);
                    }
                });
    }
}
