package L13Lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeMap;

public class Ex07CountNumbers04 {
    private static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        TreeMap<Integer, Integer> occurrences = new TreeMap<>();
        for (int number : numbers) {
            occurrences.putIfAbsent(number, 0);
            int count = occurrences.get(number) + 1;
            occurrences.put(number, count);
        }

        occurrences.forEach((key,vale) -> System.out.println(String.format("%d -> %d",key,vale)));
    }
}
