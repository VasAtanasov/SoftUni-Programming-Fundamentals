package L13Lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex07CountNumbers03 {
    private static int[] numbers;
    private static int[] range;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        range = new int[getRangeSize()];
        countOccurrence();
        printArray();
    }

    private static void printArray() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < range.length; i++) {
            if (range[i] != 0) {
                output.append(String.format("%d -> %d",i,range[i])).append(System.lineSeparator());
            }
        }
        System.out.println(output.toString().trim());
    }

    private static void countOccurrence() {
        for (int index : numbers) {
            range[index]++;
        }
    }

    private static int getRangeSize() {
        int maxNum = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > maxNum) {
                maxNum = numbers[i];
            }
        }
        return maxNum + 1;
    }
}
