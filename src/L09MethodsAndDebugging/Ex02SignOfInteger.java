package L09MethodsAndDebugging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex02SignOfInteger {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        printNumber(Integer.parseInt(reader.readLine()));
    }

    private static void printNumber(int number) {
        if (number < 0) {
            System.out.println(String.format("The number %d is negative.", number));
        } else if (number > 0) {
            System.out.println(String.format("The number %d is positive.", number));
        } else {
            System.out.println(String.format("The number %d is zero.", number));

        }
    }
}
