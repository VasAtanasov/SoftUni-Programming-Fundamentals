package Z_Exams.exam05Nov2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

public class Ex01AnonymousDownsite {
    private static BufferedReader reader;
    private static BigDecimal totalLoss;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        totalLoss = BigDecimal.ZERO;
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        BigInteger key = new BigInteger(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            String website = tokens[0];
            BigDecimal siteVisits = new BigDecimal(tokens[1]);
            BigDecimal pricePerVisit = new BigDecimal(tokens[2]);

            BigDecimal siteLoss = siteVisits.multiply(pricePerVisit);
            System.out.println(website);
            totalLoss = totalLoss.add(siteLoss);
        }

        System.out.println(String.format("Total Loss: %.20f", totalLoss));
        System.out.println(String.format("Security Token: %s", key.pow(n)));
    }
}
