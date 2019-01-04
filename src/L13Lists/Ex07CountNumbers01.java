package L13Lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex07CountNumbers01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
        int[] sortedNumbers = new int[1001];

        for (int index : numbers) {
            sortedNumbers[index]++;
        }

        printArray(sortedNumbers);
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                System.out.printf("%d -> %d%n", i, array[i]);
            }
        }
    }
}
