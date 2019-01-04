package L08DataTypeAndVarExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Ex19TheaThePhotographer {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long numberOfPictures = Long.parseLong(reader.readLine());
        long filterPerPictureSeconds = Long.parseLong(reader.readLine());
        long percentageOfGoodPhotos = Long.parseLong(reader.readLine());
        long timeToUploadSeconds = Long.parseLong(reader.readLine());

        long filterTime = numberOfPictures * filterPerPictureSeconds;
        long goodPhotos = (long) Math.ceil((numberOfPictures * percentageOfGoodPhotos) / 100.0);
        long uploadTime = goodPhotos * timeToUploadSeconds;

        long totalSeconds = filterTime + uploadTime;
        calculateTime(totalSeconds);
    }

    private static void calculateTime(long seconds) {
        DecimalFormat df = new DecimalFormat("00");
        long sec = seconds % 60;
        long minutes = seconds % 3600 / 60;
        long hours = seconds % 86400 / 3600;
        long days = seconds / 86400;
        System.out.println(String.format("%s:%s:%s:%s", days, df.format(hours), df.format(minutes), df.format(sec)));
    }
}
