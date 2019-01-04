package L08DataTypeAndVarMore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Ex05WeatherForecast {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        BigDecimal number = new BigDecimal(input);

        if (input.contains(".") && number.abs().compareTo(BigDecimal.valueOf(Double.MIN_VALUE)) >= 0 && number.abs().compareTo(BigDecimal.valueOf(Double.MAX_VALUE)) <= 0) {
            System.out.println("Rainy");
            return;
        }

        if (number.compareTo(BigDecimal.valueOf(Byte.MIN_VALUE)) >= 0 && number.compareTo(BigDecimal.valueOf(Byte.MAX_VALUE)) <= 0) {
            System.out.println("Sunny");
            return;
        }

        if (number.compareTo(BigDecimal.valueOf(Integer.MIN_VALUE)) >= 0 && number.compareTo(BigDecimal.valueOf(Integer.MAX_VALUE)) <= 0) {
            System.out.println("Cloudy");
            return;
        }

        if (number.compareTo(BigDecimal.valueOf(Long.MIN_VALUE)) >= 0 && number.compareTo(BigDecimal.valueOf(Long.MAX_VALUE)) <= 0) {
            System.out.println("Windy");
        }


    }
}
