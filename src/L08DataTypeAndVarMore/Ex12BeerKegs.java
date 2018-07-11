package L08DataTypeAndVarMore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Ex12BeerKegs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(reader.readLine());

        String bestType = "";
        BigDecimal bestVolume = BigDecimal.valueOf(Long.MIN_VALUE);

        for (int i = 0; i < lines; i++) {
            String kegType = reader.readLine();
            BigDecimal radius = new BigDecimal(reader.readLine());
            BigDecimal height = new BigDecimal(reader.readLine());

            BigDecimal volume = BigDecimal.valueOf(Math.PI).multiply(radius.multiply(radius)).multiply(height);
            if (volume.compareTo(bestVolume) > 0) {
                bestType = kegType;
                bestVolume = volume;
            }
        }

        System.out.println(bestType);
    }
}
