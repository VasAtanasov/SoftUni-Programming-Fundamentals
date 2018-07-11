package L11Arrays;

import java.util.Scanner;

public class Ex03LastKNumbersSumsSequence {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = Integer.parseInt(scanner.nextLine());
        int k = Integer.parseInt(scanner.nextLine());

        long[] array = new long[n];
        array[0] = 1;

        for (int i = 1; i < n; i++) {
            sumPreviousKElements(array, i, k);
        }

        printIntArray(array);

    }

    private static void sumPreviousKElements(long[] array, int i, int k) {
        for (int j = 1; j <= k; j++) {
            try {
                array[i] = array[i] + array[i - j];
            } catch (Exception ex) {
                break;
            }
        }
    }

    private static void printIntArray(long[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i == array.length - 1) {
                break;
            }
            System.out.print(" ");
        }
    }
}
