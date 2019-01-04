package L13Lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex02AppendLists01 {
    private static String[] lists;
    private static List<Integer> numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        lists = getReversed(reader.readLine().split("\\|"));
        numbers = new ArrayList<>();
        addNumbers();
        printList();

    }

    private static void addNumbers() {
        for (String list : lists) {
            int[] numbs = Arrays.stream(list.split("\\s+"))
                    .filter(e -> ! e.equals(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int number : numbs) {
                numbers.add(number);
            }
        }
    }

    private static String[] getReversed(String[] strings) {
        String[] reversed = new String[strings.length];
        for (int i = 0; i < strings.length; i++) {
            reversed[i] = strings[strings.length - 1 - i];
        }
        return reversed;
    }

    private static void printList() {
        StringBuilder output = new StringBuilder();
        for (Integer number : numbers) {
            output.append(number).append(" ");
        }
        System.out.println(output.toString().trim());
    }
}
