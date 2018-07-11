package L14ListExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Ex05ArrayManipulator01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> input = new ArrayList<>();

        String[] nums = reader.readLine().split("\\s+");

        for (String num : nums) {
            input.add(Integer.parseInt(num));
        }

        String command = reader.readLine();

        while (!"print".equals(command)) {
            String[] token = command.split("\\s+");
            switch (token[0]) {
                case "add":
                    addElementAtIndex(input, token[1], token[2]);
                    break;
                case "addMany":
                    addManyElements(input, token);
                    break;
                case "contains":
                    getIndex(input, token[1]);
                    break;
                case "remove":
                    removeElement(input, token[1]);
                    break;
                case "shift":
                    shiftElements(input, token[1]);
                    break;
                case "sumPairs":
                    sumEachPair(input);
                    break;
            }

            command = reader.readLine();
        }

        System.out.println(input);

    }

    private static void sumEachPair(List<Integer> input) {
        int terminateAt = (input.size() % 2 == 0) ? input.size() - 1 : input.size() - 2;
        for (int i = 0; i < terminateAt; i++) {
            int sum = input.get(i) + input.get(i + 1);
            input.remove(i);
            input.remove(i);
            input.add(i, sum);
            terminateAt--;
        }
    }

    private static void shiftElements(List<Integer> input, String s) {
        int timesShift = Integer.parseInt(s);
        Collections.rotate(input, timesShift * -1);
    }

    private static void removeElement(List<Integer> input, String s) {
        int index = Integer.parseInt(s);
        input.remove(index);
    }

    private static void getIndex(List<Integer> input, String s) {
        int element = Integer.parseInt(s);
        System.out.println(input.indexOf(element));
    }

    private static void addManyElements(List<Integer> input, String[] token) {
        int index = Integer.parseInt(token[1]);
        List<Integer> arr = Arrays.stream(token).skip(2)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        input.addAll(index, arr);
    }

    private static void addElementAtIndex(List<Integer> input, String i, String e) {
        int index = Integer.parseInt(i);
        int element = Integer.parseInt(e);
        input.add(index, element);
    }
}
