package Z_Exams.exam09Jul2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Ex04PokemonEvolution {
    private static BufferedReader reader;
    private static Map<String, Pokemon> pokemons;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        pokemons = new LinkedHashMap<>();
    }

    public static void main(String[] args) throws IOException {
        String input;
        while (! "wubbalubbadubdub".equals(input = reader.readLine())) {
            processInput(input);
        }

        printResult();
    }

    private static void printResult() {
        pokemons.values()
                .forEach(pokemon -> {
                    StringBuilder output = new StringBuilder();
                    output.append(String.format("# %s%n", pokemon.getName()));
                    pokemon.getEvolutions().stream()
                            .sorted()
                            .forEach(evolution -> output.append(String.format("%s%n", evolution)));
                    System.out.print(output.toString());
                });
    }

    private static void processInput(String input) {
        String[] tokens = input.split("[-\\s>]+");
        String name = tokens[0];
        if (tokens.length == 1) {
            if (pokemons.containsKey(name)) {
                System.out.print(pokemons.get(name));
            }
        } else {
            String type = tokens[1];
            int index = Integer.parseInt(tokens[2]);

            pokemons.putIfAbsent(name, new Pokemon(name));
            pokemons.get(name).addEvolution(new Evolution(type, index));
        }
    }
}

class Pokemon {
    private String name;
    private List<Evolution> evolutions;

    Pokemon(String name) {
        this.name = name;
        this.evolutions = new ArrayList<>();
    }

    String getName() {
        return this.name;
    }

    List<Evolution> getEvolutions() {
        return this.evolutions;
    }

    void addEvolution(Evolution evolution) {
        this.evolutions.add(evolution);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("# %s%n", this.getName()));
        this.getEvolutions()
                .forEach(evolution -> output.append(String.format("%s%n", evolution)));
        return output.toString();
    }
}

class Evolution implements Comparable<Evolution> {
    private String type;
    private int index;

    Evolution(String type, int index) {
        this.type = type;
        this.index = index;
    }

    String getType() {
        return this.type;
    }

    int getIndex() {
        return this.index;
    }

    @Override
    public int compareTo(Evolution other) {
        return Integer.compare(other.getIndex(), this.getIndex());
    }

    @Override
    public String toString() {
        return String.format("%s <-> %d", this.getType(), this.getIndex());
    }
}