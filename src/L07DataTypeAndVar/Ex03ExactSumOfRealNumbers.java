package L07DataTypeAndVar;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Ex03ExactSumOfRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        BigDecimal sum = new BigDecimal("0");

        for (int i = 0; i < n; i++) {
            BigDecimal number = new BigDecimal(scanner.nextLine());
            sum = sum.add(number);
        }

        DecimalFormat df = new DecimalFormat("#.##################################");

        System.out.printf("%s",df.format(sum));

    }
}
