package Z_ExamsExtendet.exam04Sep2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Ex01Resurrection {
    private static BufferedReader reader;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(reader.readLine());

        for (int i = 0; i < count; i++) {
            BigDecimal length = new BigDecimal(reader.readLine());
            BigDecimal width = new BigDecimal(reader.readLine());
            BigDecimal wingsLength = new BigDecimal(reader.readLine()).multiply(BigDecimal.valueOf(2));

            BigDecimal totalYears = (length.pow(2)).multiply((width.add(wingsLength)));
            System.out.println(String.format("%s",totalYears));
        }

    }
}
