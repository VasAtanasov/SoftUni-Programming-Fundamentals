package L14ListExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ex01MaxSequenceOfEqualElements01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = makeList(reader.readLine().split("\\s+"));
        if (numbers.size() == 1) {
            System.out.println(numbers.get(0));
            return;
        }

        int element = 0;
        int bestLength = 0;
        int maxLength = 1;


        for (int i = 1; i < numbers.size(); i++) {
            while (Objects.equals(numbers.get(i), numbers.get(i - 1))) {
                maxLength++;
                if (i == numbers.size() - 1) break;
                i++;
            }
            if (bestLength < maxLength) {
                element = numbers.get(i - 1);
                bestLength = maxLength;
            }
            maxLength = 1;
        }

        StringBuilder sequence = new StringBuilder();
        for (int i = 0; i < bestLength; i++) {
            sequence.append(element);
            sequence.append(" ");
        }
        System.out.println(sequence.toString().trim());


    }

    private static List<Integer> makeList(String[] list) {
        List<Integer> makeList = new ArrayList<>();
        for (String num : list) {
            makeList.add(Integer.valueOf(num));
        }
        return makeList;
    }
}
