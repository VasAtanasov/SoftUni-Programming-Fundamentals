package L09MethodsAndDebugging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex05TemperatureConversion {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double fahrenheit = Double.parseDouble(reader.readLine());
        double celsius = convertFahrenheitToCelsius(fahrenheit);
        System.out.println(String.format("%.2f",celsius));
    }

    private static double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}
