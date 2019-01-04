package L14ListExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Ex04LongestIncreasingSequence {
    private static BufferedReader reader;
    private static List<Integer> numbers;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));

        System.out.println(String.format("%s", FindLIS().toString().replaceAll("[\\[\\],]", "")));
    }

    private static List<Integer> FindLIS() {
        int elements = numbers.size();
        int[] lengths = new int[elements];
        int[] previous = new int[elements];

        int bestLength = 0;
        int lastIndex = - 1;

        for (int anchor = 0; anchor < elements; anchor++) {
            lengths[anchor] = 1;
            previous[anchor] = - 1;

            int anchorNum = numbers.get(anchor);

            for (int i = 0; i < anchor; i++) {
                int currentNum = numbers.get(i);

                if (currentNum < anchorNum
                        && lengths[i] + 1 > lengths[anchor]) {
                    lengths[anchor] = lengths[i] + 1;
                    previous[anchor] = i;
                }
            }

            if (lengths[anchor] > bestLength) {
                bestLength = lengths[anchor];
                lastIndex = anchor;
            }
        }

        List<Integer> LIS = new ArrayList<>();

        while (lastIndex != - 1) {
            LIS.add(numbers.get(lastIndex));
            lastIndex = previous[lastIndex];
        }

        Collections.reverse(LIS);

        return LIS;
    }
}
