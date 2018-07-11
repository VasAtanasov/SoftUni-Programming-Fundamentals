package L09MethodsAndDebugging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex08GreaterOfTwoValues {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String type = reader.readLine();
        String valueOne = reader.readLine();
        String valueTwo = reader.readLine();

        System.out.println(getMax(valueOne, valueTwo, type));
    }

    private static String getMax(String valueOne, String valueTwo, String type) {
        if (type.equals("int")) {
            return Integer.parseInt(valueOne) > Integer.parseInt(valueTwo) ? valueOne : valueTwo;
        } else {
            return valueOne.compareTo(valueTwo) > 0 ? valueOne : valueTwo;
        }
    }
}
