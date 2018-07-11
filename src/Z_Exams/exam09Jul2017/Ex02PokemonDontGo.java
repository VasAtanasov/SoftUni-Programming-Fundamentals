package Z_Exams.exam09Jul2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex02PokemonDontGo {
    private static BufferedReader reader;
    private static List<Long> numbers;
    private static long removedElementsSum;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Long::valueOf)
                .collect(Collectors.toCollection(ArrayList::new));

        while (numbers.size() > 0) {
            int index = Integer.parseInt(reader.readLine());
            long removedElement = removeElement(index);
            mapNumbers(removedElement);
            removedElementsSum += removedElement;
        }

        System.out.println(removedElementsSum);
    }

    private static void mapNumbers(long removedElement) {
        for (int i = 0; i < numbers.size(); i++) {
            long number = numbers.get(i);
            if (number <= removedElement) {
                numbers.set(i, number + removedElement);
            } else {
                numbers.set(i, number - removedElement);
            }
        }
    }

    private static long removeElement(int index) {
        long removedElement;
        if (index < 0) {
            removedElement = numbers.get(0);
            numbers.set(0, numbers.get(numbers.size() - 1));
        } else if (index >= numbers.size()) {
            removedElement = numbers.get(numbers.size() - 1);
            numbers.set(numbers.size() - 1, numbers.get(0));
        } else {
            removedElement = numbers.remove(index);
        }
        return removedElement;
    }
}
