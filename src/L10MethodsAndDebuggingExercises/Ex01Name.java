package L10MethodsAndDebuggingExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex01Name {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        printGreeting(reader.readLine());
    }

    private static void printGreeting(String s) {
        System.out.println(String.format("Hello, %s!",s));
    }
}
