package Z_ExamPreparationExtendet.ExamPreparation04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex01SweetDessert {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double money = Double.parseDouble(reader.readLine());
        double guestCount = Double.parseDouble(reader.readLine());
        double priceOfBananas = Double.parseDouble(reader.readLine());
        double priceOfEggs = Double.parseDouble(reader.readLine());
        double priceOfBerries = Double.parseDouble(reader.readLine());

        double sets = Math.ceil(guestCount / 6.0);
        double moneyForBanana = (2 * sets) * priceOfBananas;
        double moneyForEggs = (4 * sets) * priceOfEggs;
        double moneyForBerries = (0.2 * sets) * priceOfBerries;

        double moneyNeeded = moneyForBanana + moneyForEggs + moneyForBerries;


        if (money - moneyNeeded >= 0) {
            System.out.println(String.format("Ivancho has enough money - it would cost %.2flv.", moneyNeeded));
        } else {
            System.out.println(String.format("Ivancho will have to withdraw money - he will need %.2flv more.", moneyNeeded - money));
        }
    }
}
