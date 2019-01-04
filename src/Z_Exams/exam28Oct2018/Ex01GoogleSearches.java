package Z_Exams.exam28Oct2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Ex01GoogleSearches {

    private static BufferedReader reader;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        runApp();
    }

    private static void runApp() throws IOException {
        BigDecimal totalMoney = BigDecimal.ZERO;

        int totalDays = Integer.parseInt(reader.readLine());
        int usersCount = Integer.parseInt(reader.readLine());
        double moneyPerSearch = Double.parseDouble(reader.readLine());

        for (int i = 1; i <= usersCount; i++) {
            int wordsCount = Integer.parseInt(reader.readLine());
            if (wordsCount > 5) {
                continue;
            }
            double moneyMade = moneyPerSearch * totalDays;

            if (i % 3 == 0) {
                moneyMade *= 3;
            }

            if (wordsCount == 1) {
                moneyMade *= 2;
            }

            totalMoney = totalMoney.add(new BigDecimal(moneyMade));
        }

        System.out.println(String.format("Total money earned for %d days: %.2f", totalDays, totalMoney));
    }
}