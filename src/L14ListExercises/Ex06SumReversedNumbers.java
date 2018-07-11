package L14ListExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex06SumReversedNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(number -> reverseDigits(number))
                .sum());
    }

    private static int reverseDigits(String number) {
        StringBuilder reversedString = new StringBuilder();
        for (int i = number.length() - 1; i >= 0; i--) {
            reversedString.append(number.charAt(i));
        }
        return Integer.parseInt(reversedString.toString());
    }
}
