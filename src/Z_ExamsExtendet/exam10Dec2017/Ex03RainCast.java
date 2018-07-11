package Z_ExamsExtendet.exam10Dec2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex03RainCast {
    private static BufferedReader reader;
    private static final String TYPE_REGEX;
    private static final String SOURCE_REGEX;
    private static final String FORECAST_REGEX;
    private static Pattern pattern;
    private static boolean typeSearching;
    private static boolean sourceSearching;
    private static boolean forecastSearching;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        TYPE_REGEX = "^Type: (?<type>Normal|Danger|Warning)$";
        SOURCE_REGEX = "^Source: (?<source>[A-Za-z0-9]+)$";
        FORECAST_REGEX = "^Forecast: (?<forecast>[^!.,?\\n]+)$";
        pattern = Pattern.compile(TYPE_REGEX);
        typeSearching = true;
        sourceSearching = false;
        forecastSearching = false;
    }

    public static void main(String[] args) throws IOException {
        Forecast forecast = new Forecast();
        String input;
        while (! "Davai Emo".equals(input = reader.readLine())) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                if (typeSearching) {
                    processType(forecast, matcher);
                } else if (sourceSearching) {
                    processSource(forecast, matcher);
                } else if (forecastSearching) {
                    processForecast(forecast, matcher);
                    System.out.println(forecast);
                    forecast = new Forecast();
                }
            }
        }

    }

    private static void processForecast(Forecast forecast, Matcher matcher) {
        forecast.setForecast(matcher.group("forecast"));
        forecastSearching = false;
        typeSearching = true;
        pattern = Pattern.compile(TYPE_REGEX);
    }

    private static void processSource(Forecast forecast, Matcher matcher) {
        forecast.setSource(matcher.group("source"));
        sourceSearching = false;
        forecastSearching = true;
        pattern = Pattern.compile(FORECAST_REGEX);
    }

    private static void processType(Forecast forecast, Matcher matcher) {
        forecast.setType(matcher.group("type"));
        typeSearching = false;
        sourceSearching = true;
        pattern = Pattern.compile(SOURCE_REGEX);
    }
}

class Forecast {
    private String type;
    private String source;
    private String forecast;

    void setType(String type) {
        this.type = type;
    }

    void setSource(String source) {
        this.source = source;
    }

    void setForecast(String forecast) {
        this.forecast = forecast;
    }

    @Override
    public String toString() {
        return String.format("(%s) %s ~ %s", this.type, this.forecast, this.source);
    }
}