package Z_Exams.exam04Mar2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex01PadawanEquipment {
    private static BufferedReader reader;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        double money = Double.parseDouble(reader.readLine());
        int studentCount = Integer.parseInt(reader.readLine());
        double lightSaberPrice = Double.parseDouble(reader.readLine());
        double robePrice = Double.parseDouble(reader.readLine());
        double beltPrice = Double.parseDouble(reader.readLine());

        int beltsCount = studentCount - (studentCount / 6);
        int lightSabersCount = (int) Math.ceil(studentCount * 1.1);

        double totalMoney = (lightSabersCount * lightSaberPrice) +
                (studentCount * robePrice) +
                (beltsCount * beltPrice);

        if (money - totalMoney >= 0) {
            System.out.println(String.format("The money is enough - it would cost %.2flv.", totalMoney));
        } else {
            System.out.println(String.format("Ivan Cho will need %.2flv more.", totalMoney - money));
        }

    }
}
