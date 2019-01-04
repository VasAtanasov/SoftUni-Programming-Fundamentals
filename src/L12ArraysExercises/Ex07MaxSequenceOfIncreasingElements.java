package L12ArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class Ex07MaxSequenceOfIncreasingElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int count = 1;
        int bestCount = 0;
        int bestIndex = 0;


        for (int i = 1; i < input.length; i++) {
            if (input[i - 1] < input[i]) {
                count++;
            } else {
                count = 1;
            }
            if (count > bestCount) {
                bestCount = count;
                bestIndex = i - count + 1;
            }
        }

        printIntArray(input, bestCount, bestIndex);

    }

    private static void printIntArray(int[] array, int bestCount, int bestIndex) {
        for (int i = bestIndex; i < bestIndex + bestCount; i++) {
            System.out.print(array[i]);
            if (i == array.length - 1) {
                break;
            }
            System.out.print(" ");
        }
    }
}
