package Z_ExamsExtendet.exam09May2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex03Spyfer {
    private static BufferedReader reader;
    private static List<Integer> numbers;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        getNumbers();

        int index = 0;
        while (index < numbers.size()) {
            int leftIndex = index - 1;
            int rightIndex = index + 1;

            int leftElement = leftIndex < 0 ? 0 : numbers.get(leftIndex);
            int element = numbers.get(index);
            int rightElement = rightIndex >= numbers.size() ? 0 : numbers.get(rightIndex);

            int sum = leftElement + rightElement;
            if (element == sum) {
                removeElements(leftIndex, rightIndex);
                index = 0;
            } else {
                index++;
            }
        }

        System.out.println(numbers.stream().map(String::valueOf)
                .collect(Collectors.joining(" ")));

    }

    private static void removeElements(int leftIndex, int rightIndex) {
        if (rightIndex < numbers.size()) {
            numbers.remove(rightIndex);
        }
        if (leftIndex >= 0) {
            numbers.remove(leftIndex);
        }
    }

    private static void getNumbers() throws IOException {
        numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
