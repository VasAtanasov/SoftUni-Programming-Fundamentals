package L08DataTypeAndVarMore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex02NumberChecker {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            long number = Long.parseLong(reader.readLine());
            System.out.println("integer");
        } catch (Exception ex) {
            System.out.println("floating-point");
        }
    }
}
