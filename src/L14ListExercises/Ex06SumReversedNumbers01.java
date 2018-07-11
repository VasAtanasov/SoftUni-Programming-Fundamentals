package L14ListExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ex06SumReversedNumbers01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> input = new ArrayList<>(Arrays.asList(scanner.nextLine().split(" ")));
        int sum = 0;

        for (int i = 0; i < input.size(); i++) {
            int number = reverseDigits(input.get(i));
            sum += number;
        }

        System.out.println(sum);
    }

    private static int reverseDigits(String input) {
        char[] digits = input.toCharArray();
        StringBuilder number = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            number.append(digits[i]);
        }

        return Integer.parseInt(number.toString());

    }

}