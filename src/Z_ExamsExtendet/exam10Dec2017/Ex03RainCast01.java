package Z_ExamsExtendet.exam10Dec2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex03RainCast01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String regexType = "^Type: (Normal|Danger|Warning)$";
        String regexSource = "^Source: ([A-Za-z0-9]*)$";
        String regexForecast = "^Forecast: ([^!.,?\\n]*)$";

        Pattern patternType = Pattern.compile(regexType);
        Pattern patternSource = Pattern.compile(regexSource);
        Pattern patternForecast = Pattern.compile(regexForecast);
        String type = "";
        String source = "";
        String forecast = "";
        String searchingFor = "type";

        String input = reader.readLine();
        while (!"Davai Emo".equals(input)) {
            Matcher matcherType = patternType.matcher(input);
            Matcher matcherSource = patternSource.matcher(input);
            Matcher matcherForecast = patternForecast.matcher(input);

            if (matcherType.find() && searchingFor.equals("type")) {
                searchingFor = "source";
                type = matcherType.group(1);
            } else if (matcherSource.find() && searchingFor.equals("source")) {
                searchingFor = "forecast";
                source = matcherSource.group(1);
            } else if (matcherForecast.find() && searchingFor.equals("forecast")) {
                searchingFor = "type";
                forecast = matcherForecast.group(1);
                System.out.println(String.format("(%s) %s ~ %s", type, forecast, source));
            }

            input = reader.readLine();
        }
    }
}
