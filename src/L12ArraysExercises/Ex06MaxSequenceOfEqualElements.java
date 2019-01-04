package L12ArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class Ex06MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int lengthCount = 1;
        int[] sequence = new int[lengthCount];
        sequence[0] = input[0];

        for (int i = 1; i < input.length; i++) {
            if (input[i - 1] == input[i]) {
                lengthCount++;
                if (lengthCount > sequence.length) {
                    sequence = addElement(sequence, input[i - 1]);
                }
            } else {
                lengthCount = 1;
            }
        }

        printIntArray(sequence);

    }

    private static int[] addElement(int[] sequence, int i) {
        int[] newArray = new int[sequence.length + 1];
        for (int j = 0; j < newArray.length; j++) {
            newArray[j] = i;
        }

        return newArray;
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
