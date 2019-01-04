package Z_ExamsExtendet.exam04Sep2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ex04CODEPhoenix {
    private static BufferedReader reader;
    private static Map<String, Creature> creatures;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        creatures = new LinkedHashMap<>();
    }

    public static void main(String[] args) throws IOException {
        String input;
        while (! "Blaze it!".equals(input = reader.readLine())) {
            String[] tokens = input.split(" -> ");
            String creature = tokens[0];
            String squadMate = tokens[1];

            if (creature.equals(squadMate)) {
                continue;
            }

            creatures.putIfAbsent(creature, new Creature(creature));
            creatures.get(creature).addSquadMate(squadMate);
        }

        filterCreatures();

        creatures.values().stream()
                .sorted()
                .forEach(System.out::println);


    }

    private static void filterCreatures() {
        List<String> set = new ArrayList<>(creatures.keySet());
        for (int i = 0; i < set.size() - 1; i++) {
            String creature = set.get(i);
            for (int j = i + 1; j < creatures.size(); j++) {
                String otherCreature = set.get(j);
                if (creatures.get(creature).contains(otherCreature) && creatures.get(otherCreature).contains(creature)) {
                    creatures.get(creature).removeCreature(otherCreature);
                    creatures.get(otherCreature).removeCreature(creature);
                }
            }
        }
    }
}

class Creature implements Comparable<Creature> {
    private String name;
    private List<String> mates;

    Creature(String name) {
        this.name = name;
        this.mates = new ArrayList<>();
    }

    String getName() {
        return this.name;
    }

    void removeCreature(String squadMate) {
        this.mates.remove(squadMate);
    }

    boolean contains(String squadMate) {
        return this.mates.contains(squadMate);
    }

    void addSquadMate(String squadMate) {
        if (! this.mates.contains(squadMate)) {
            this.mates.add(squadMate);
        }
    }

    private int squadMateCount() {
        return this.mates.size();
    }

    @Override
    public int compareTo(Creature other) {
        return Integer.compare(other.squadMateCount(), this.squadMateCount());
    }

    @Override
    public String toString() {
        return String.format("%s : %d", this.getName(), this.squadMateCount());

    }
}