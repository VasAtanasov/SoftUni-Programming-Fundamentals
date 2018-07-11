package L08DataTypeAndVarMore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Ex01TypeBoundaries {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        switch (input) {
            case "byte":
                System.out.println("255");
                System.out.println("0");
                break;
            case "sbyte":
                System.out.println(Byte.MAX_VALUE);
                System.out.println(Byte.MIN_VALUE);
                break;
            case "int":
                System.out.println(Integer.MAX_VALUE);
                System.out.println(Integer.MIN_VALUE);
                break;
            case "uint":
                System.out.println(new BigInteger("4294967295"));
                System.out.println(new BigInteger("0"));
                break;
            case "long":
                System.out.println(Long.MAX_VALUE);
                System.out.println(Long.MIN_VALUE);
                break;

        }
    }
}
