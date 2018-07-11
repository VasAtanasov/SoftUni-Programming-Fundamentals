package L08DataTypeAndVarExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Ex11ConvertSpeedUnits {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double meters = Double.parseDouble(reader.readLine());
        double hours = Double.parseDouble(reader.readLine());
        double minutes = Double.parseDouble(reader.readLine());
        double seconds = Double.parseDouble(reader.readLine());
        DecimalFormat df = new DecimalFormat("0.######");

        double totalSeconds = (hours * 60 * 60) + (minutes * 60) + seconds;
        double totalHours = totalSeconds / 3600.0;

        double mPerS = meters / totalSeconds;
        double kmPerH = (meters / totalHours) / 1000;
        double mPerH = (meters / totalHours) / 1609;

        System.out.println(df.format(mPerS));
        System.out.println(df.format(kmPerH));
        System.out.println(df.format(mPerH));

    }
}
