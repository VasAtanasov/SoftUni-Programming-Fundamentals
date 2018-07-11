package L13Lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex07CountNumbers05 {
    private static BufferedReader reader;
    private static List<Integer> numbers;
    private static int maxElement = Integer.MIN_VALUE;
    private static int[] count;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        getNumbers();
        count = new int[maxElement + 1];
        numbers.forEach(integer -> count[integer]++);

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                output.append(String.format("%d -> %d", i, count[i]))
                        .append(System.lineSeparator());
            }
        }

        System.out.println(output.toString());

    }

    private static void getNumbers() throws IOException {
        numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .peek(n -> maxElement = n > maxElement ? n : maxElement)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
