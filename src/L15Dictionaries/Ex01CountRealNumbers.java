package L15Dictionaries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Ex01CountRealNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Double, Integer> occurrences = new TreeMap<>();
        double[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        for (double number : numbers) {
            occurrences.putIfAbsent(number, 0);
            occurrences.put(number, occurrences.get(number) + 1);
        }

        DecimalFormat df = new DecimalFormat("0.#########");
        occurrences.forEach((key, value) -> {
            System.out.println(String.format("%s -> %d", df.format(key), value));
        });
    }
}
