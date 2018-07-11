package L11Arrays;

import java.util.Scanner;

public class Ex09ExtractMiddleElements {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] array = parseIntegers(scanner.nextLine().split("\\s+"));
        int arrayLength = array.length;

        if (arrayLength == 1) {
            System.out.printf("{ %d }", array[0]);
        } else if (arrayLength % 2 == 0) {
            System.out.printf("{ %d, %d }", array[arrayLength / 2 - 1], array[arrayLength / 2]);
        } else {
            System.out.printf("{ %d, %d, %d }", array[arrayLength / 2 - 1], array[arrayLength / 2], array[arrayLength / 2 + 1]);
        }
    }

    private static int[] parseIntegers(String[] split) {
        int[] result = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            result[i] = Integer.parseInt(split[i]);
        }
        return result;
    }
}
