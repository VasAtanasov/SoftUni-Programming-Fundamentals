package L12ArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class Ex10PairsByDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int difference = Integer.parseInt(scanner.nextLine());
        int count = 0;

        for (int i = 0; i < input.length; i++) {
            for (int j = i; j < input.length - 1; j++) {
                if (Math.abs(input[i] - input[j + 1]) == difference) {
                    count++;
                }
            }
        }
        System.out.println(count);

    }
}
