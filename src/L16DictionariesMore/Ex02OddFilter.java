package L16DictionariesMore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Ex02OddFilter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .toArray();

        double average = Arrays.stream(numbers).sum() / numbers.length;

        System.out.println(Arrays.stream(numbers)
                .map(n -> n > average ? n + 1 : n - 1)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));
    }
}
