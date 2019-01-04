package L09MethodsAndDebugging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Ex07MathPower {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BigDecimal base = new BigDecimal(reader.readLine());
        int exponent = Integer.parseInt(reader.readLine());
        System.out.println(base.pow(exponent));
    }
}
