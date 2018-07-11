package L07DataTypeAndVar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex07Greeting {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(String.format("Hello, %s %s. You are %s years old", reader.readLine(), reader.readLine(), reader.readLine()));
    }
}
