package L05ConditionalAndLoops;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Ex03BackIn30Min {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        DecimalFormat df = new DecimalFormat("00");
        int hours = Integer.parseInt(reader.readLine());
        int minutes = Integer.parseInt(reader.readLine());
        int totalMinutes = (hours * 60) + minutes + 30;

        System.out.println(String.format("%d:%s", (totalMinutes / 60) % 24,
                df.format(totalMinutes % 60)));

    }
}
