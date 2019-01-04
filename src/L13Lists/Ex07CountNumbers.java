package L13Lists;

import java.util.Arrays;
import java.util.Scanner;

public class Ex07CountNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        if (input.length == 1) {
            System.out.printf("%d -> %d%n", input[0], 1);
            return;
        }

        Arrays.sort(input);
        int count = 1;
        int endOfSearch = input.length - 2;

        for (int i = 0; i < input.length - 1; i++) {
            if (i == endOfSearch) {
                if (input[i] == input[i + 1]) {
                    count++;
                    System.out.printf("%d -> %d%n", input[i], count);
                } else if (input[i] != input[i + 1]) {
                    System.out.printf("%d -> %d%n", input[i], count);
                    count = 1;
                    System.out.printf("%d -> %d%n", input[i + 1], count);
                }
            } else if (input[i] == input[i + 1]) {
                count++;
            } else {
                System.out.printf("%d -> %d%n", input[i], count);
                count = 1;
            }
        }
    }
}
