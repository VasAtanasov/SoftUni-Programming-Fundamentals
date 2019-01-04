package L14ListExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex03SearchOfANumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
        int[] parameters = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int takeCount = parameters[0];
        int skipCount = parameters[1];
        int searched = parameters[2];

        int limit = takeCount - skipCount;
        boolean isPresent = numbers.stream()
                .skip(skipCount)
                .limit(limit)
                .anyMatch(e -> e.equals(searched));

        if (isPresent) {
            System.out.println("YES!");
        } else {
            System.out.println("NO!");
        }

    }
}
