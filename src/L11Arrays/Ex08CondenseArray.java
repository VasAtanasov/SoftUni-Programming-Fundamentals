package L11Arrays;

import java.util.Scanner;

public class Ex08CondenseArray {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] array = parseIntegers(scanner.nextLine().split("\\s+"));

        if (array.length == 1) {
            System.out.println(array[0]);
            return;
        }

        int arrayLength = array.length;

        while (arrayLength != 1) {
            array = condenseArray(array);
            arrayLength = array.length;
        }

        System.out.println(array[0]);

    }

    private static int[] condenseArray(int[] array) {
        int[] condensed = new int[array.length - 1];
        for (int i = 0; i < array.length - 1; i++) {
            condensed[i] = array[i] + array[i + 1];
        }

        return condensed;
    }

    private static int[] parseIntegers(String[] split) {
        int[] result = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            result[i] = Integer.parseInt(split[i]);
        }
        return result;
    }
}
