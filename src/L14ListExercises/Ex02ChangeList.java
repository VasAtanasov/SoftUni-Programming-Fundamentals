package L14ListExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex02ChangeList {
    private static List<Integer> numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));

        while (true) {
            String input = reader.readLine();
            if ("Odd".equals(input)) {
                String output = getOdds(numbers);
                System.out.println(output);
                break;
            }
            if ("Even".equals(input)) {
                String output = getEven(numbers);
                System.out.println(output);
                break;
            }

            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            int element = Integer.parseInt(tokens[1]);

            switch (command) {
                case "Insert":
                    int index = Integer.parseInt(tokens[2]);
                    numbers.add(index, element);
                    break;
                case "Delete":
                    deleteElements(element);
                    break;
            }


        }
    }

    private static void deleteElements(int element) {
        for (int i = numbers.size() - 1; i >= 0; i--) {
            if (numbers.get(i).equals(element)) {
                numbers.remove(i);
            }
        }
    }

    private static String getEven(List<Integer> numbers) {
        return numbers.stream()
                .filter(e -> e % 2 == 0)
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }

    private static String getOdds(List<Integer> numbers) {
        return numbers.stream()
                .filter(e -> e % 2 != 0)
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }
}
