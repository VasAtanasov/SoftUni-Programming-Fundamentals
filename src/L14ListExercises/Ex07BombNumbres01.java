package L14ListExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ex07BombNumbres01 {
    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = makeList(scanner.nextLine().split("\\s+"));
        int[] bombParameters = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
        int bombPower = bombParameters[1];


        while (isContained(numbers, bombParameters[0])) {
            int bombIndex = numbers.indexOf(bombParameters[0]);
            int leftEnd = getLeftEnd(bombIndex, bombPower);
            int rightEnd = getRightEnd(numbers, bombIndex, bombPower, leftEnd);
            detonateElements(numbers, leftEnd, rightEnd);
        }
        printSum(numbers);
    }

    private static void printSum(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        System.out.println(sum);
    }

    private static void detonateElements(List<Integer> numbers, int leftEnd, int rightEnd) {
        for (int i = leftEnd; i <= rightEnd; i++) {
            numbers.remove(leftEnd);
        }
    }

    private static int getRightEnd(List<Integer> numbers, int bombIndex, int bombPower, int leftEnd) {
        int rightEnd = leftEnd + 2 * bombPower;
        return rightEnd > numbers.size() - 1 ? numbers.size() - 1 : rightEnd;
    }

    private static int getLeftEnd(int bombIndex, int bombPower) {
        return bombIndex - bombPower < 0 ? 0 : bombIndex - bombPower;
    }

    private static boolean isContained(List<Integer> numbers, int bombParameter) {
        return numbers.contains(bombParameter);
    }

    private static List<Integer> makeList(String[] list) {
        List<Integer> makeList = new ArrayList<>();
        for (String num : list) {
            makeList.add(Integer.valueOf(num));
        }
        return makeList;
    }
}
