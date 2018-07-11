package L07DataTypeAndVar;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class Ex01CenturiesToMinutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger centuries = new BigInteger(scanner.nextLine());
        BigInteger years = centuries.multiply(new BigInteger("100"));
        BigDecimal days = new BigDecimal(years).multiply(new BigDecimal("365.2422"));
        BigInteger hours = days.toBigInteger().multiply(new BigInteger("24"));
        BigInteger minutes = hours.multiply(new BigInteger("60"));

        System.out.printf("%d centuries = %d years = %.0f days = %d hours = %d minutes",
                centuries, years, days, hours, minutes);


    }
}
