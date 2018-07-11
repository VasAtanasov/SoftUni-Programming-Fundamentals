package Z_Exams.exam26Feb2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex01HornetWings {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long wingFlaps = Long.parseLong(reader.readLine());
        double distanceForOneFlap = Double.parseDouble(reader.readLine()) / 1000.0;
        long endurance = Long.parseLong(reader.readLine());

        System.out.println(String.format("%.2f m.", wingFlaps * distanceForOneFlap));

        long restPeriod = (wingFlaps / endurance) * 5;
        long flapTime = wingFlaps / 100;

        long totalTime = restPeriod + flapTime;
        System.out.println(String.format("%d s.",totalTime));
    }
}
