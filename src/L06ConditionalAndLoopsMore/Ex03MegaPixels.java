package L06ConditionalAndLoopsMore;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Ex03MegaPixels {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigDecimal numberOne = new BigDecimal(scanner.nextLine());
        BigDecimal numberTwo = new BigDecimal(scanner.nextLine());

        BigDecimal megaPixels = (numberOne.multiply(numberTwo)).divide(BigDecimal.valueOf(1000000),1, RoundingMode.HALF_EVEN).stripTrailingZeros();

        System.out.printf("%.0fx%.0f => %sMP",numberOne,numberTwo, megaPixels.toPlainString());


    }
}

