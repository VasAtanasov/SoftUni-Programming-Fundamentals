package L11Arrays;

import java.util.Scanner;
import java.util.stream.LongStream;

public class Ex04TripleSum {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        long[] arr = parseLong(scanner.nextLine().split("\\s+"));
        int counter = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length - 1; j++) {
                long sum = arr[i] + arr[j + 1];
                boolean contains = LongStream.of(arr).anyMatch(x -> x == sum);
                if (contains) {
                    System.out.printf("%d + %d == %d%n", arr[i], arr[j + 1], sum);
                    counter++;
                }
            }
        }

        if (counter == 0) {
            System.out.println("No");
        }

    }

    private static long[] parseLong(String[] split) {
        long[] result = new long[split.length];
        for (int i = 0; i < split.length; i++) {
            result[i] = Long.parseLong(split[i]);
        }
        return result;
    }
}
