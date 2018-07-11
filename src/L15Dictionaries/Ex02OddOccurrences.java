package L15Dictionaries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Ex02OddOccurrences {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().toLowerCase().split("\\s+");

        LinkedHashMap<String, Integer> occurrences = new LinkedHashMap<>();
        for (String string : input) {
            occurrences.putIfAbsent(string, 0);
            int updateCount = occurrences.get(string) + 1;
            occurrences.put(string, updateCount);
        }

        System.out.println(occurrences.entrySet().stream()
                .filter(e -> e.getValue() % 2 != 0)
                .map(Map.Entry::getKey)
                .collect(Collectors.joining(", ")));
    }
}
