package Z_Exams.exam11Sep2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Ex01TheaThePhotographer {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double pictures = Double.parseDouble(reader.readLine());
        double filterTime = Double.parseDouble(reader.readLine());
        double percentage = Double.parseDouble(reader.readLine());
        double uploadTime = Double.parseDouble(reader.readLine());

        double filteredTime = pictures * filterTime;
        pictures = Math.ceil((pictures * percentage) / 100);
        double uploadedTime = pictures * uploadTime;
        long totalTime = (long) (filteredTime + uploadedTime);
        String output = calculateTime(totalTime);
        System.out.println(output);

    }

    private static String calculateTime(long seconds) {
        DecimalFormat df = new DecimalFormat("00");
        long sec = seconds % 60;
        long minutes = seconds % 3600 / 60;
        long hours = seconds % 86400 / 3600;
        long days = seconds / 86400;
        return String.format("%d:%s:%s:%s", days, df.format(hours), df.format(minutes), df.format(sec));
    }
}
