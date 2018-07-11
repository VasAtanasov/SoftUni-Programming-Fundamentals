package L09MethodsAndDebugging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Ex11PriceChangeAlert {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        double bound = Double.parseDouble(reader.readLine());
        double lastPrice = Double.parseDouble(reader.readLine());

        for (int i = 0; i < n - 1; i++) {
            double prices = Double.parseDouble(reader.readLine());
            double div = process(lastPrice, prices);
            boolean isSignificantDifference = isDiff(div, bound);
            String message = get(prices, lastPrice, div, isSignificantDifference);
            System.out.println(message);
            lastPrice = prices;
        }
    }

    private static String get(double price, double lastPrice, double diff, boolean etherTrueOrFalse) {
        DecimalFormat df = new DecimalFormat("0.###");
        String to = "";
        if (diff == 0) {
            to = String.format("NO CHANGE: %s", df.format(price));
        } else if (! etherTrueOrFalse) {
            to = String.format("MINOR CHANGE: %s to %s (%.2f%%)", df.format(lastPrice), df.format(price), diff * 100);
        } else if (diff > 0) {
            to = String.format("PRICE UP: %s to %s (%.2f%%)", df.format(lastPrice), df.format(price), diff * 100);
        } else if (diff < 0)
            to = String.format("PRICE DOWN: %s to %s (%.2f%%)", df.format(lastPrice), df.format(price), diff * 100);
        return to;
    }

    private static boolean isDiff(double bound, double isDiff) {
        return Math.abs(bound) >= isDiff;
    }

    private static double process(double l, double c) {
        return (c - l) / l;
    }
}
