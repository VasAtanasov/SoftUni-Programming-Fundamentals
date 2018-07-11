package L12ArraysMoreExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

public class Ex08UpgradedMatcher01 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] products = reader.readLine().split("\\s+");

        BigInteger[] quantities = new BigInteger[products.length];
        String[] inputQuantities = reader.readLine().split("\\s+");
        for (int i = 0; i < quantities.length; i++) {
            if (i < inputQuantities.length) {
                quantities[i] = new BigInteger(inputQuantities[i]);
            } else {
                quantities[i] = BigInteger.ZERO;
            }
        }

        BigDecimal[] prices = Arrays.stream(reader.readLine().split("\\s+"))
                .map(BigDecimal::new)
                .toArray(BigDecimal[]::new);

        String input;
        while (! "done".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");
            String product = tokens[0];
            BigInteger quantityOrdered = new BigInteger(tokens[1]);
            int i = getIndex(products, product);

            if ((quantities[i].subtract(quantityOrdered)).compareTo(BigInteger.ZERO) >= 0) {
                System.out.println(String.format("%s x %d costs %.2f",
                        products[i],
                        quantityOrdered,
                        prices[i].multiply(BigDecimal.valueOf(quantityOrdered.doubleValue()))));
                quantities[i] = quantities[i].subtract(quantityOrdered);
            } else {
                System.out.println(String.format("We do not have enough %s", product));
            }


        }

    }

    private static int getIndex(String[] products, String product) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].equals(product)) {
                return i;
            }
        }
        return - 1;
    }
}
