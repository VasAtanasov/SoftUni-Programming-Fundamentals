package L16DictionariesExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Ex03MinerTask {
    private static Map<String, Long> resources;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        resources = new LinkedHashMap<>();

        String resource;
        while (! "stop".equals(resource = reader.readLine())) {
            long quantity = Long.parseLong(reader.readLine());

            resources.putIfAbsent(resource, 0L);
            long newQuantity = resources.get(resource) + quantity;
            resources.put(resource, newQuantity);
        }

        printMap();
    }

    private static void printMap() {
        resources.forEach((r, q) -> System.out.println(String.format("%s -> %d", r, q)));
    }
}
