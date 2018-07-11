package L06ConditionalAndLoopsMore;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Ex05BPMCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double beatsPM = Double.parseDouble(scanner.nextLine());
        double numberOfBeats = Double.parseDouble(scanner.nextLine());

        BigDecimal bars = BigDecimal.valueOf(numberOfBeats).divide(BigDecimal.valueOf(4.0), 1, RoundingMode.HALF_EVEN).stripTrailingZeros();
        BigDecimal time = (BigDecimal.valueOf(numberOfBeats).divide(BigDecimal.valueOf(beatsPM), 2, RoundingMode.HALF_EVEN)).multiply(BigDecimal.valueOf(60.0)).setScale(0, RoundingMode.FLOOR);
        BigDecimal min = time.divide(BigDecimal.valueOf(60.0), 0, RoundingMode.FLOOR);
        BigDecimal sec = time.remainder(BigDecimal.valueOf(60.0)).setScale(0, RoundingMode.FLOOR);

        DecimalFormat df = new DecimalFormat("0.#");
        DecimalFormat dfMinHour = new DecimalFormat("0");

        System.out.printf("%s bars - %sm %ss", df.format(bars), df.format(min), df.format(sec));

    }
}

