package Z_ExamPreparationExtendet.ExamPreparation02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex01CharityMarathon {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long dayCount = Long.parseLong(reader.readLine());
        long runnersCount = Long.parseLong(reader.readLine());
        long lapCount = Long.parseLong(reader.readLine());
        long lapLength = Long.parseLong(reader.readLine());
        long trackCapacity = Long.parseLong(reader.readLine());
        double moneyPerKilometer = Double.parseDouble(reader.readLine());

        runnersCount = dayCount * trackCapacity > runnersCount ? runnersCount : dayCount * trackCapacity;

        long totalKm = (runnersCount * lapCount * lapLength) / 1000;
        double moneyRaised = moneyPerKilometer * totalKm;
        System.out.println(String.format("Money raised: %.2f",moneyRaised));
    }
}
