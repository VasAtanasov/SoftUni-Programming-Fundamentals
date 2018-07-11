package L12ArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class Ex03FoldAndSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        if (input.length == 4) {
            int[] sum = new int[2];
            sum[0] = input[0] + input[1];
            sum[1] = input[2] + input[3];
            printIntArray(sum);
            return;
        }

        int rowLength = input.length / 2;

        int[] firstRow = createFirstRow(input, rowLength);
        int[] secondRow = createSecondRow(input, rowLength);
        int[] sum = sumArrays(firstRow, secondRow, rowLength);

        printIntArray(sum);
    }

    private static int[] sumArrays(int[] firstRow, int[] secondRow, int rowLength) {
        int[] sum = new int[rowLength];
        for (int i = 0; i < rowLength; i++) {
            sum[i] = firstRow[i] + secondRow[i];
        }

        return sum;
    }

    private static int[] createSecondRow(int[] input, int rowLength) {
        int[] secondRow = new int[rowLength];
        int startIndex = rowLength / 2;
        for (int i = 0; i < rowLength; i++) {
            secondRow[i] = input[startIndex];
            startIndex++;
        }

        return secondRow;
    }

    private static int[] createFirstRow(int[] input, int rowLength) {
        int[] firstRow = new int[rowLength];
        int reversedIndex = (rowLength / 2) - 1;
        for (int i = 0; i < rowLength / 2; i++) {
            firstRow[i] = input[reversedIndex];
            reversedIndex--;
        }
        reversedIndex = input.length - 1;
        for (int i = rowLength / 2; i < rowLength; i++) {
            firstRow[i] = input[reversedIndex];
            reversedIndex--;
        }

        return firstRow;
    }

    private static void printIntArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i == array.length - 1) {
                break;
            }
            System.out.print(" ");
        }
    }
}
