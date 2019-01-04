package L20StringAndTextExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Ex06SumBigNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numberOne = Arrays.stream(reader.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        int[] numberTwo = Arrays.stream(reader.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        int maxLength = Math.max(numberOne.length, numberTwo.length) + 1;
        int[] number = new int[maxLength];

        int remainder = 0;
        for (int i = 0; i < maxLength; i++) {
            int digitOne = i < numberOne.length ? numberOne[numberOne.length - 1 - i] : 0;
            int digitTwo = i < numberTwo.length ? numberTwo[numberTwo.length - 1 - i] : 0;
            int sum = digitOne + digitTwo + remainder;
            remainder = sum / 10;
            number[maxLength - 1 - i] = (sum % 10);
        }


        System.out.println(printNumber(number));

    }

    private static BigInteger printNumber(int[] digits) {
        StringBuilder output = new StringBuilder();
        for (int digit : digits) {
            output.append(digit);
        }
        return new BigInteger(output.toString());
    }
}
