package L16DictionariesMore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex02OddFilter01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::valueOf)
                .filter(e -> e % 2 == 0)
                .collect(Collectors.toCollection(ArrayList::new));

        double average = numbers.stream().mapToDouble(Double::valueOf).average().getAsDouble();

        System.out.println(numbers.stream()
                .map(e -> (e > average) ? e + 1 : e - 1)
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
    }
}

