package L08DataTypeAndVarExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Ex18DifferentIntegerSize {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BigInteger number = new BigInteger(reader.readLine());
        List<String> dataTypes = new ArrayList<>();

        if (number.compareTo(BigInteger.valueOf(- 128)) >= 0 && number.compareTo(BigInteger.valueOf(127)) <= 0) {
            dataTypes.add("* sbyte");
        }
        if (number.compareTo(BigInteger.ZERO) >= 0 && number.compareTo(BigInteger.valueOf(255)) <= 0) {
            dataTypes.add("* byte");
        }
        if (number.compareTo(BigInteger.valueOf(- 32_768)) >= 0 && number.compareTo(BigInteger.valueOf(327_67)) <= 0) {
            dataTypes.add("* short");
        }
        if (number.compareTo(BigInteger.ZERO) >= 0 && number.compareTo(BigInteger.valueOf(65535)) <= 0) {
            dataTypes.add("* ushort");
        }
        if (number.compareTo(BigInteger.valueOf(- 2_147_483_648)) >= 0 && number.compareTo(BigInteger.valueOf(2_147_483_647)) <= 0) {
            dataTypes.add("* int");
        }
        if (number.compareTo(BigInteger.ZERO) >= 0 && number.compareTo(new BigInteger("4294967295")) <= 0) {
            dataTypes.add("* uint");
        }
        if (number.compareTo(BigInteger.valueOf(Long.MIN_VALUE)) >= 0 && number.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) <= 0) {
            dataTypes.add("* long");
        }
        if (number.compareTo(BigInteger.valueOf(Long.MIN_VALUE)) < 0 || number.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) > 0) {
            System.out.println(String.format("%s can't fit in any type", number));
            return;
        }
        System.out.println(String.format("%s can fit in:", number));
        dataTypes.forEach(System.out::println);
    }
}
