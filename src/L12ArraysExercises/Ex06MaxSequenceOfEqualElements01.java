package L12ArraysExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex06MaxSequenceOfEqualElements01 {
    private static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int len = 1;
        int bestLen = 1;
        int number = 0;

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                len++;
            } else {
                if (len > bestLen) {
                    bestLen = len;
                    number = numbers[i];
                }
                len = 1;
            }

            if ((i + 1) == numbers.length - 1) {
                if (len > bestLen) {
                    bestLen = len;
                    number = numbers[i];
                }
                len = 1;
            }
        }


        StringBuilder output = new StringBuilder();
        for (int i = 0; i < bestLen; i++) {
            output.append(number).append(" ");
        }

        System.out.println(output.toString().trim());
    }
// below code also working
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        numbers = Arrays.stream(reader.readLine().split("\\s+"))
//                .mapToInt(Integer::parseInt)
//                .toArray();
//
//        int maxLength = 1;
//        int currantLength = 1;
//        int startIndex = 0;
//
//        for (int i = 0; i < numbers.length - 1; i++) {
//            if (numbers[i] == numbers[i + 1]) {
//                currantLength++;
//                if (i == numbers.length - 2 && currantLength > maxLength) {
//                    maxLength = currantLength;
//                    startIndex = i - currantLength + 2;
//                }
//
//            } else {
//                if (currantLength > maxLength) {
//                    maxLength = currantLength;
//                    startIndex = i - currantLength + 1;
//                }
//                currantLength = 1;
//            }
//
//        }
//
//        System.out.println(getResultArray(maxLength, startIndex));
//    }
//
//    private static String getResultArray(int maxLength, int startIndex) {
//        StringBuilder output = new StringBuilder();
//        for (int i = startIndex; i < startIndex + maxLength; i++) {
//            output.append(numbers[i]).append(" ");
//        }
//        return output.toString().trim();
//    }
}
