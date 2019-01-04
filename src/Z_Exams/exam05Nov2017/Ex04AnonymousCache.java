package Z_Exams.exam05Nov2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class Ex04AnonymousCache {
    private static BufferedReader reader;
    private static Map<String, DataSet> dataSets;
    private static Map<String, DataSet> cache;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        dataSets = new HashMap<>();
        cache = new LinkedHashMap<>();
    }

    public static void main(String[] args) throws IOException {
        String input;
        while (! "thetinggoesskrra".equals(input = reader.readLine())) {
            String[] tokens = input.split("[-\\s>|]+");
            if (tokens.length == 1) {
                updateDataSet(tokens[0]);
            } else {
                processDataSets(tokens);
            }
        }

        Optional<DataSet> largestBySize = dataSets.values()
                .stream()
                .sorted()
                .findFirst();

        largestBySize.ifPresent(System.out::println);
    }

    private static void processDataSets(String[] tokens) {
        String dataKey = tokens[0];
        int dataSize = Integer.parseInt(tokens[1]);
        String dataSet = tokens[2];

        if (dataSets.containsKey(dataSet)) {
            dataSets.get(dataSet).addDataSetKeyAndSize(dataKey, dataSize);
        } else {
            cache.putIfAbsent(dataSet, new DataSet(dataSet));
            cache.get(dataSet).addDataSetKeyAndSize(dataKey, dataSize);
        }
    }

    private static void updateDataSet(String dataSet) {
        dataSets.putIfAbsent(dataSet, new DataSet(dataSet));
        if (cache.containsKey(dataSet)) {
            dataSets.put(dataSet, cache.get(dataSet));
            cache.remove(dataSet);
        }
    }
}


class DataSet implements Comparable<DataSet> {
    private String name;
    private Map<String, Integer> sets;

    DataSet(String name) {
        this.name = name;
        this.sets = new LinkedHashMap<>();
    }

    public String getName() {
        return this.name;
    }

    private Map<String, Integer> getSets() {
        return this.sets;
    }

    void addDataSetKeyAndSize(String dataKey, int dataSize) {
        this.getSets().put(dataKey, dataSize);
    }

    private long getTotalDataSize() {
        return sets.values().stream().mapToLong(i -> i).sum();
    }

    @Override
    public int compareTo(DataSet other) {
        return Long.compare(other.getTotalDataSize(), this.getTotalDataSize());
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("Data Set: %s, Total Size: %d%n", this.getName(), this.getTotalDataSize()));
        sets.keySet().forEach(key -> output.append(String.format("$.%s%n", key)));
        return output.toString();
    }
}