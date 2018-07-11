package Z_Exams.exam04Mar2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Ex02KaminoFactory {
    private static BufferedReader reader;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(reader.readLine());

        int bestSequence = 1;
        int bestIndex = 0;
        int bestSequenceLength = 1;
        int bestSum = 0;
        String outputSequence = "";


        int sequence = 1;
        String input;
        while (! "Clone them!".equals(input = reader.readLine())) {
            int[] numbers = Arrays.stream(input.split("[!]+"))
                    .filter(e -> ! e.isEmpty())
                    .mapToInt(Integer::parseInt)
                    .toArray();

            if (sequence == 1) {
                outputSequence = getSequenceString(numbers);
            }

            int index = 0;
            int length = 1;
            int bestLength = 1;

            for (int i = 1; i < numbers.length; i++) {
                if (numbers[i] == numbers[i - 1] && numbers[i] == 1) {
                    length++;
                    if (i == numbers.length - 1 && length > bestLength) {
                        bestLength = length;
                        index = i - bestLength;
                    }
                } else if (length > bestLength) {
                    bestLength = length;
                    index = i - bestLength;
                    length = 1;
                } else {
                    length = 1;
                }
            }

            int sum = Arrays.stream(numbers).sum();

            if (bestLength > bestSequenceLength) {
                bestSequenceLength = bestLength;
                bestIndex = index;
                bestSum = sum;
                outputSequence = getSequenceString(numbers);
                bestSequence = sequence;
            } else if (index < bestIndex) {
                bestSequenceLength = bestLength;
                bestIndex = index;
                bestSum = sum;
                outputSequence = getSequenceString(numbers);
                bestSequence = sequence;
            } else if (sum > bestSum) {
                bestSequenceLength = bestLength;
                bestIndex = index;
                bestSum = sum;
                outputSequence = getSequenceString(numbers);
                bestSequence = sequence;
            }

            sequence++;
        }

        System.out.println(String.format("Best DNA sample %d with sum: %d.", bestSequence, bestSum));
        System.out.println(outputSequence);
    }

    private static String getSequenceString(int[] numbers) {
        String outputSequence;
        outputSequence = Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.joining(" "));
        return outputSequence;
    }
}
