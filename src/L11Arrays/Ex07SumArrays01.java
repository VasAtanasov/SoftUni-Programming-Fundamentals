package L11Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex07SumArrays01 {
    private static int[] arrayOne;
    private static int[] arrayTwo;
    private static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        arrayOne = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        arrayTwo = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int maxLength = Math.max(arrayOne.length, arrayTwo.length);
        result = new int[maxLength];

        sumArrays(maxLength);
        printArray(result);

    }

    private static void sumArrays(int maxLength) {
        for (int i = 0; i < maxLength; i++) {
            int elementOne = arrayOne[i % arrayOne.length];
            int elementTwo = arrayTwo[i % arrayTwo.length];
            result[i] = elementOne + elementTwo;
        }
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i == array.length - 1) {
                break;
            }
            System.out.print(" ");
        }
    }
}
