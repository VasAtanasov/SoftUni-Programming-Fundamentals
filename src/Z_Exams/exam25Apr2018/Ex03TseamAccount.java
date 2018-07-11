package Z_Exams.exam25Apr2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex03TseamAccount {
    private static BufferedReader reader;
    private static List<String> games;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        games = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        receiveGames();
        String input;
        while (! "Play!".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String game = tokens[1];

            switch (command) {
                case "Install":
                    installGame(game);
                    break;
                case "Uninstall":
                    uninstallGame(game);
                    break;
                case "Update":
                    updateGame(game);
                    break;
                case "Expansion":
                    installExpansion(game);
                    break;
            }
        }

        System.out.println(games.stream().collect(Collectors.joining(" ")));
    }

    private static void installExpansion(String input) {
        String game = input.split("-")[0];
        String expansion = input.split("-")[1];
        if (games.contains(game)) {
            games.add(games.indexOf(game) + 1, String.format("%s:%s",game,expansion) );
        }
    }

    private static void updateGame(String game) {
        if (games.contains(game)) {
            games.remove(game);
            games.add(game);
        }
    }

    private static void uninstallGame(String game) {
        if (games.contains(game)) {
            games.remove(game);
        }
    }

    private static void installGame(String game) {
        if (games.contains(game)) {
            return;
        }
        games.add(game);
    }

    private static void receiveGames() throws IOException {
        games = Arrays.stream(reader.readLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
