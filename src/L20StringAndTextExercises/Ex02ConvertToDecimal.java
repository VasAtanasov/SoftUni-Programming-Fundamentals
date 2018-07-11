package L20StringAndTextExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Ex02ConvertToDecimal {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = reader.readLine().split("\\s+");
        BigInteger fromBase = new BigInteger(numbers[0]);
        BigInteger result = BigInteger.ZERO;

        int power = numbers[1].length() - 1;

        for (int i = 0; i < numbers[1].length(); i++) {
            BigInteger num = BigInteger.valueOf(numbers[1].charAt(i) - 48);
            result = result.add(num.multiply(fromBase.pow(power)));
            power--;
        }

        System.out.println(result);
    }
}
