package L14ListExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Ex05ArrayManipulator {
    private static List<Integer> numbers;
    private static String[] tokens;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        numbers = Arrays.stream(reader.readLine().split("\\s+"))    //last test gives time limit with streams
//                .map(Integer::parseInt)                             //so parse list with for loop
//                .collect(Collectors.toCollection(ArrayList::new));
        numbers = new ArrayList<>();
        parseList(reader.readLine().split("\\s+"));

        String input;
        while (! "print".equals(input = reader.readLine())) {
            tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "add":
                    addElement();
                    break;
                case "addMany":
                    addManyElements();
                    break;
                case "contains":
                    containsElement();
                    break;
                case "remove":
                    removeElement();
                    break;
                case "shift":
                    shiftElements();
                    break;
                case "sumPairs":
                    sumPairs();
                    break;
            }

        }

        System.out.println(numbers);
    }

    private static void sumPairs() {
        List<Integer> summed = new ArrayList<>();
        if (numbers.size() % 2 == 0) {
            for (int i = 0; i < numbers.size(); i += 2) {
                summed.add(numbers.get(i) + numbers.get(i + 1));
            }
        } else {
            for (int i = 0; i < numbers.size() - 1; i += 2) {
                summed.add(numbers.get(i) + numbers.get(i + 1));
            }
            summed.add(numbers.get(numbers.size() - 1));
        }
        numbers = summed;
    }

    private static void shiftElements() {
        int times = Integer.parseInt(tokens[1]) % numbers.size();
        Collections.rotate(numbers, - times); // negative to rotate left and positive to rotate right
    }

    private static void removeElement() {
        int index = Integer.parseInt(tokens[1]);
        numbers.remove(index);
    }

    private static void containsElement() {
        int element = Integer.parseInt(tokens[1]);
        System.out.println(numbers.indexOf(element));
    }

    private static void addManyElements() {
        int index = Integer.parseInt(tokens[1]);
        List<Integer> elements = Arrays.stream(tokens)
                .skip(2)
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));

        numbers.addAll(index, elements);
    }

    private static void addElement() {
        int index = Integer.parseInt(tokens[1]);
        int element = Integer.parseInt(tokens[2]);
        numbers.add(index, element);
    }

    private static void parseList(String[] input) {
        for (String element : input) {
            numbers.add(Integer.parseInt(element));
        }
    }
}
