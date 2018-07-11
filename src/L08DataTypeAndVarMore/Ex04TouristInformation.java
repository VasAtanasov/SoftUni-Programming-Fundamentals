package L08DataTypeAndVarMore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Ex04TouristInformation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String unit = reader.readLine();
        BigDecimal value = new BigDecimal(reader.readLine());

        switch (unit) {
            case "miles":
                BigDecimal kilometers = value.multiply(BigDecimal.valueOf(1.6));
                System.out.println(String.format("%s miles = %.2f kilometers",value,kilometers));
                break;
            case "inches":
                BigDecimal centimetersFromInches = value.multiply(BigDecimal.valueOf(2.54));
                System.out.println(String.format("%s inches = %.2f centimeters",value,centimetersFromInches));
                break;
            case "feet":
                BigDecimal centimetersFromFeet = value.multiply(BigDecimal.valueOf(30));
                System.out.println(String.format("%s feet = %.2f centimeters",value,centimetersFromFeet));
                break;
            case "yards":
                BigDecimal meters = value.multiply(BigDecimal.valueOf(0.91));
                System.out.println(String.format("%s yards = %.2f meters",value,meters));
                break;
            case "gallons":
                BigDecimal liters = value.multiply(BigDecimal.valueOf(3.8));
                System.out.println(String.format("%s gallons = %.2f liters",value,liters));
                break;
        }
    }
}
