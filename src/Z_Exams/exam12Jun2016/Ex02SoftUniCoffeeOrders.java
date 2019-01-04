package Z_Exams.exam12Jun2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Ex02SoftUniCoffeeOrders {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/M/yyyy");
        int count = Integer.parseInt(reader.readLine());
        BigDecimal totalPrice = BigDecimal.ZERO;

        for (int i = 0; i < count; i++) {
            BigDecimal pricePerCapsule = new BigDecimal(reader.readLine());
            LocalDate date = LocalDate.parse(reader.readLine(), dtf);
            BigDecimal capsulesCount = new BigDecimal(reader.readLine());
            BigDecimal daysInMonth = BigDecimal.valueOf(date.lengthOfMonth());

            BigDecimal price = (daysInMonth.multiply(capsulesCount)).multiply(pricePerCapsule);
            System.out.println(String.format("The price for the coffee is: $%.2f",price));
            totalPrice = totalPrice.add(price);
        }

        System.out.println(String.format("Total: $%.2f",totalPrice));
    }
}
