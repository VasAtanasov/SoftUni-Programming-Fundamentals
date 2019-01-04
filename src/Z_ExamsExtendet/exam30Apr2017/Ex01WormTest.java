package Z_ExamsExtendet.exam30Apr2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Ex01WormTest {
    private static BufferedReader reader;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        BigDecimal length = new BigDecimal(reader.readLine()).multiply(BigDecimal.valueOf(100));
        BigDecimal width = new BigDecimal(reader.readLine());
        if (width.compareTo(BigDecimal.ZERO) == 0 || length.remainder(width).compareTo(BigDecimal.ZERO) == 0) {
            System.out.println(length.multiply(width).setScale(2, RoundingMode.HALF_EVEN));
        } else {
            System.out.println(length.divide(width, 10, RoundingMode.HALF_EVEN)
                    .multiply(BigDecimal.valueOf(100)).setScale(2, RoundingMode.HALF_EVEN)+ "%");
        }

    }
}
