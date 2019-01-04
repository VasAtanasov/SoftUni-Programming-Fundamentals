package L13Lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ex01RemoveNegativesAndReverse02 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = makeList(reader.readLine().split("\\s+"));
        numbers = numbers.stream().filter(e -> e >= 0).collect(Collectors.toList());

        if (numbers.isEmpty()) {
            System.out.println("empty");
        } else {
            printList(numbers);
        }
    }

    private static void printList(List<Integer> numbers) {
        StringBuilder list = new StringBuilder();
        for (int i = numbers.size() - 1; i >= 0; i--) {
            list.append(numbers.get(i));
            list.append(" ");
        }
        System.out.println(list.toString().trim());
    }

    private static List<Integer> makeList(String[] list) {
        List<Integer> makeList = new ArrayList<>();
        for (String num : list) {
            makeList.add(Integer.valueOf(num));
        }
        return makeList;
    }
}
