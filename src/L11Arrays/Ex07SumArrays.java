package L11Arrays;

import java.util.Scanner;

public class Ex07SumArrays {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        long[] arrayOne = parseLong(scanner.nextLine().split("\\s+"));
        long[] arrayTwo = parseLong(scanner.nextLine().split("\\s+"));
        int arrayOneLength = arrayOne.length;
        int arrayTwoLength = arrayTwo.length;
        int longestArray = Math.max(arrayOneLength, arrayTwoLength);
        int shortestArray = Math.min(arrayOneLength, arrayTwoLength);

        if (arrayOneLength < arrayTwoLength) {
            arrayOne = fillArray(arrayOne, longestArray, shortestArray);
        } else if (arrayOneLength > arrayTwoLength) {
            arrayTwo = fillArray(arrayTwo, longestArray, shortestArray);
        }

        long[] array = new long[longestArray];
        sumArrays(array, arrayOne, arrayTwo, longestArray);
        printLongArray(array);

    }

    private static long[] fillArray(long[] array, int longestArray, int shortestArray) {
        int index = 0;
        int i = 0;
        long[] temp = array;
        array = new long[longestArray];
        while (index != longestArray) {
            if (i == shortestArray) {
                i = 0;
            }
            array[index] = temp[i];
            i++;
            index++;
        }
        return array;
    }

    private static void sumArrays(long[] array, long[] arrayOne, long[] arrayTwo, int arrayLength) {
        for (int i = 0; i < arrayLength; i++) {
            long arrayOneNumber = arrayOne[i];
            long arrayTwoNumber = arrayTwo[i];
            array[i] = arrayOneNumber + arrayTwoNumber;
        }
    }

    private static long[] parseLong(String[] split) {
        long[] result = new long[split.length];
        for (int i = 0; i < split.length; i++) {
            result[i] = Long.parseLong(split[i]);
        }
        return result;
    }

    private static void printLongArray(long[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i == array.length - 1) {
                break;
            }
            System.out.print(" ");
        }
    }


}
