package L13Lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex01RemoveNegativesAndReverse01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        List<Integer> filteredAndReversed = new ArrayList<>();

        for (int i = numbers.length - 1; i >= 0; i--) {
            if (numbers[i] >= 0) {
                filteredAndReversed.add(numbers[i]);
            }
        }

        if (filteredAndReversed.size() > 0) {
            StringBuilder output = new StringBuilder();
            for (Integer number : filteredAndReversed) {
                output.append(number).append(" ");
            }
            System.out.println(output.toString().trim());
        } else {
            System.out.println("empty");
        }
    }
}
