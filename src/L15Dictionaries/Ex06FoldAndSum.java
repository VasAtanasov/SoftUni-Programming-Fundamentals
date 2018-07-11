package L15Dictionaries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex06FoldAndSum {
    private static List<Integer> numbers;
    private static List<Integer> middle;
    private static List<Integer> left;
    private static List<Integer> right;
    private static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
        k = numbers.size() / 4;
        divideList();

        for (int i = 0; i < left.size(); i++) {
            processLeftPart(i);
            processRightPart(i);
        }

        System.out.println(middle.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
    }

    private static void divideList() {
        middle = numbers.stream()
                .skip(k)
                .limit(2 * k)
                .collect(Collectors.toCollection(ArrayList::new));

        left = numbers.stream()
                .limit(k)
                .collect(Collectors.toCollection(ArrayList::new));

        right = numbers.stream()
                .skip(3 * k)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private static void processLeftPart(int index) {
        int middleLeftNum = middle.get(index);
        int leftNum = left.get(left.size() - 1 - index);
        middle.set(index, middleLeftNum + leftNum);
    }

    private static void processRightPart(int index) {
        int middleRightNum = middle.get(middle.size() - 1 - index);
        int rightNum = right.get(index);
        middle.set(middle.size() - 1 - index, middleRightNum + rightNum);
    }
}
