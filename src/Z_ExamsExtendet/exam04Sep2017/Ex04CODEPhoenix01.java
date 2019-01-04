package Z_ExamsExtendet.exam04Sep2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;

public class Ex04CODEPhoenix01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, LinkedHashSet<String>> creatures = new LinkedHashMap<>();
        List<String> check = new ArrayList<>();

        String input = reader.readLine();
        while (! "Blaze it!".equals(input)) {
            String[] split = input.split(" -> ");
            String creature = split[0];
            String squadMate = split[1];
            check.add(squadMate + creature);
            creatures.putIfAbsent(creature, new LinkedHashSet<>());

            if (creature.equals(squadMate) || check.contains(creature + squadMate)) {
                creatures.get(squadMate).remove(creature);
                input = reader.readLine();
                continue;
            }

            creatures.get(creature).add(squadMate);
            input = reader.readLine();
        }

        creatures.entrySet().stream()
                .sorted((a, b) -> Long.compare(b.getValue().size(), a.getValue().size()))
                .forEach((squad) -> {
                    System.out.println(String.format("%s : %d", squad.getKey(), squad.getValue().size()));
                });
    }
}
