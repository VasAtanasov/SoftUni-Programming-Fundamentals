package L12ArraysExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex08MostFrequentNumber {
    private static int[] numbers;
    private static int[] distinct;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        distinct = new int[0];
        getDistinctNumbres();

        int currantCount = 0;
        int mostOccurredCount = 0;
        int numberMostOccurred = distinct[0];

        for (int i = 0; i < distinct.length; i++) {
            int number = distinct[i];
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[j] == number) {
                    currantCount++;
                }
            }

            if (currantCount > mostOccurredCount) {
                mostOccurredCount = currantCount;
                numberMostOccurred = number;
            }

            currantCount = 0;
        }

        System.out.println(numberMostOccurred);

    }

    private static void getDistinctNumbres() {
        for (int number : numbers) {
            if (! containsNumber(number)) {
                distinct = addNumber(number);
            }
        }
    }

    private static int[] addNumber(int number) {
        int[] expandArray = new int[distinct.length + 1];
        for (int i = 0; i < distinct.length; i++) {
            expandArray[i] = distinct[i];
        }
        expandArray[expandArray.length - 1] = number;
        return expandArray;
    }

    private static boolean containsNumber(int number) {
        for (int num : distinct) {
            if (num == number) {
                return true;
            }
        }
        return false;
    }
}
