package L11Arrays;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Ex05RoundAwayFromZero {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double[] numbers = parseDouble(scanner.nextLine().split("\\s+"));

        for (int i = 0; i < numbers.length; i++) {
            roundAwayFromZero(numbers, i);

        }
    }

    private static void roundAwayFromZero(double[] numbers, int i) {
        BigDecimal beforeRound = new BigDecimal(numbers[i]);
        BigDecimal afterRound = new BigDecimal(numbers[i]);
        afterRound = afterRound.setScale(0, RoundingMode.HALF_UP);
        DecimalFormat df = new DecimalFormat("#.####");
        System.out.printf("%s => %s%n",df.format(beforeRound), df.format(afterRound));
    }

    private static double[] parseDouble(String[] split) {
        double[] result = new double[split.length];
        for (int i = 0; i < split.length; i++) {
            result[i] = Double.parseDouble(split[i]);
        }
        return result;
    }
}
