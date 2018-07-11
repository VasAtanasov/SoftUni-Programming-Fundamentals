package L12ArraysExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex05CompareCharArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] arrayOne = reader.readLine().split("\\s+");
        String[] arrayTwo = reader.readLine().split("\\s+");

        List<String[]> arrays = new ArrayList<>();
        arrays.add(arrayOne);
        arrays.add(arrayTwo);

        arrays.stream()
                .map(arr -> Arrays.stream(arr).collect(Collectors.joining("")))
                .sorted((a, b) -> {
                    int index = Integer.compare(a.length(), b.length());
                    return index != 0 ? index : a.compareTo(b);
                })
                .forEach(System.out::println);
    }
}
