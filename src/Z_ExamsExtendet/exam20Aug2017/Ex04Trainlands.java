package Z_ExamsExtendet.exam20Aug2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Ex04Trainlands {
    private static BufferedReader reader;
    private static Map<String, Train> trains;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        trains = new LinkedHashMap<>();
    }

    public static void main(String[] args) throws IOException {
        String input;
        while (! "It's Training Men!".equals(input = reader.readLine())) {
            if (input.contains(":")) {
                registerTrainsAndWagons(input);

            } else if (input.contains("=")) {
                copyWagons(input);

            } else {
                transferWagons(input);

            }
        }

        trains.values()
                .stream()
                .sorted()
                .forEach(System.out::print);
    }

    private static void copyWagons(String input) {
        String[] tokens = input.split(" = ");
        String trainName = tokens[0];
        String otherTrainName = tokens[1];

        if (trains.containsKey(trainName)) {
            trains.get(trainName).getWagons().clear();
        } else {
            trains.put(trainName, new Train(trainName));
        }

        trains.get(trainName).getWagons().putAll(trains.get(otherTrainName).getWagons());
    }

    private static void transferWagons(String input) {
        String[] tokens = input.split(" -> ");
        String trainName = tokens[0];
        String otherTrainName = tokens[1];

        trains.putIfAbsent(trainName, new Train(trainName));
        trains.get(trainName).getWagons().putAll(trains.get(otherTrainName).getWagons());
        trains.remove(otherTrainName);
    }

    private static void registerTrainsAndWagons(String input) {
        String[] tokens = Arrays.stream(input.split("[->:\\s]+"))
                .filter(s -> ! s.isEmpty())
                .toArray(String[]::new);

        String trainName = tokens[0];
        String wagonName = tokens[1];
        long wagonPower = Long.parseLong(tokens[2]);

        trains.putIfAbsent(trainName, new Train(trainName));
        trains.get(trainName).attachWagon(wagonName, wagonPower);
    }
}

class Train implements Comparable<Train> {
    private String name;
    private Map<String, Wagon> wagons;

    Train(String name) {
        this.name = name;
        this.wagons = new LinkedHashMap<>();
    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    Map<String, Wagon> getWagons() {
        return this.wagons;
    }

    void attachWagon(String wagonName, long wagonPower) {
        this.wagons.put(wagonName, new Wagon(wagonName, wagonPower));
    }

    private long getTotalWagonPower() {
        return this.getWagons().values().stream()
                .mapToLong(Wagon::getPower)
                .sum();
    }

    private int getWagonCount() {
        return this.getWagons().size();
    }

    @Override
    public int compareTo(Train other) {
        int index = Long.compare(other.getTotalWagonPower(), this.getTotalWagonPower());
        return index != 0 ? index : Integer.compare(this.getWagonCount(), other.getWagonCount());
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("Train: %s%n", this.getName()));
        this.getWagons().values()
                .stream()
                .sorted()
                .forEach(wagon -> output.append(String.format("%s%n", wagon)));
        return output.toString();
    }
}


class Wagon implements Comparable<Wagon> {
    private String name;
    private long power;

    Wagon(String name, long power) {
        this.name = name;
        this.power = power;
    }

    long getPower() {
        return this.power;
    }

    String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Wagon other) {
        return Long.compare(other.getPower(), this.getPower());
    }

    @Override
    public String toString() {
        return String.format("###%s - %d", this.getName(), this.getPower());
    }
}