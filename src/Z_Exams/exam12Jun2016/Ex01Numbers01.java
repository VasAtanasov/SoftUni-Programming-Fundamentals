package Z_Exams.exam12Jun2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex01Numbers01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+")).map(Integer::valueOf)
                .collect(Collectors.toCollection(ArrayList::new));

        double average = numbers.stream().mapToDouble(Double::valueOf).average().getAsDouble();

        numbers = numbers.stream()
                .filter(e -> e > average)
                .sorted((a, b) -> Integer.compare(b, a))
                .limit(5)
                .collect(Collectors.toCollection(ArrayList::new));

        if (numbers.size() == 0) {
            System.out.println("No");

        } else {
            System.out.println(numbers.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }

    }
}
