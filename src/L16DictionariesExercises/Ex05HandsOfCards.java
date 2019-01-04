package L16DictionariesExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ex05HandsOfCards {
    private static List<String> powers = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A");
    private static List<String> suits = Arrays.asList("0", "C", "D", "H", "S");
    private static Map<String, HashSet<String>> players;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        players = new LinkedHashMap<>();

        String input;
        while (! "JOKER".equals(input = reader.readLine())) {
            String[] tokens = input.split(":");
            String name = tokens[0];
            players.putIfAbsent(name, new HashSet<>());
            addCards(tokens[1], name);
        }

        printResult();
    }

    private static void addCards(String token, String name) {
        String[] deck = Arrays.stream(token.split("[,\\s]+")).toArray(String[]::new);
        for (int i = 1; i < deck.length; i++) {
            players.get(name).add(deck[i]);
        }
    }

    private static void printResult() {
        players.forEach((p, d) -> {
            int totalPower = d.stream()
                    .map(c -> {
                        int power = powers.indexOf(c.substring(0, c.length() - 1));
                        int multiplier = suits.indexOf(c.substring(c.length() - 1));
                        return power * multiplier;
                    })
                    .reduce(0, (a, b) -> a + b);
            System.out.println(String.format("%s: %d", p, totalPower));
        });
    }
}
