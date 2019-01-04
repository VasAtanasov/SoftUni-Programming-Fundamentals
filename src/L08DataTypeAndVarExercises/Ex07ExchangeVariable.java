package L08DataTypeAndVarExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex07ExchangeVariable {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        String b = reader.readLine();

        System.out.println("Before:");
        System.out.println(String.format("a = %s",a));
        System.out.println(String.format("b = %s",b));
        System.out.println("After:");
        System.out.println(String.format("a = %s",b));
        System.out.println(String.format("b = %s",a));

    }
}
