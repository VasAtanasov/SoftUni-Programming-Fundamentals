package Z_ExamsExtendet.exam15Apr2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex03FirstAlbum01 {
    private static String nameRegex = "(?:\\[(?<name>[^-\\s][a-zA-Z\\s-]+[^-\\s])])";
    private static String lyricsRegex = "(?:\"(?<lyrics>[A-Za-z-\\s]{3,})\")";
    private static String lengthRegex = "(?<length>(?:[0-9]{1,2}:[0-9]{1,2}m)|(?:[0-9]+s))";
    private static Pattern namePattern = Pattern.compile(nameRegex);
    private static Pattern lyricsPattern = Pattern.compile(lyricsRegex);
    private static Pattern lengthPattern = Pattern.compile(lengthRegex);

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int songCount = 0;

        String input;
        while (! "Rock on!".equals(input = reader.readLine()) && songCount < 4) {
            Matcher nameMatcher = namePattern.matcher(input);
            Matcher lyricsMatcher = lyricsPattern.matcher(input);
            Matcher lengthMatcher = lengthPattern.matcher(input);

            if (! nameMatcher.find() || ! lyricsMatcher.find() || ! lengthMatcher.find()) {
                continue;
            }

            String songName = nameMatcher.group("name");
            String lyrics = lyricsMatcher.group("lyrics");
            String length = lengthMatcher.group("length");

            int lengthInSeconds;
            if (length.contains(":")) {
                String[] tokens = length.replace("m", "").split(":");
                lengthInSeconds = Integer.parseInt(tokens[0]) * 60;
                lengthInSeconds += Integer.parseInt(tokens[1]);

            } else {
                lengthInSeconds = Integer.parseInt(length.replace("s", ""));
            }

            if (lengthInSeconds > 3600) {
                continue;
            }

            System.out.println(String.format("%s -> %s => %s", songName, calculateTime(lengthInSeconds), lyrics));
            songCount++;
        }

    }

    private static String calculateTime(long seconds) {
        DecimalFormat df = new DecimalFormat("00");
        long sec = seconds % 60;
        long minutes = seconds / 60;
        return String.format("%s:%s", df.format(minutes), df.format(sec));
    }
}

