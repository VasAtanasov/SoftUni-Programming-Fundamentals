package L13Lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ex03SumAdjacentEqualNumbers01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Double> numbers = makeList(reader.readLine().split("\\s+"));
        boolean equalPairs = true;
        while (equalPairs) {
            equalPairs = false;
            for (int i = 0; i < numbers.size() - 1; i++) {
                if (Objects.equals(numbers.get(i), numbers.get(i + 1))) {
                    double sum = numbers.get(i) + numbers.get(i + 1);
                    numbers.set(i, sum);
                    numbers.remove(i + 1);
                    equalPairs = true;
                    break;
                }
            }
        }
        System.out.println(numbers);
    }

    private static List<Double> makeList(String[] list) {
        List<Double> makeList = new ArrayList<>();
        for (String num : list) {
            makeList.add(Double.valueOf(num));
        }
        return makeList;
    }
}
