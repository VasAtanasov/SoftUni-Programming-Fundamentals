package L22RegexExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex04Weather {
    private static final String REGEX_SENTENCE;
    private static Map<String, City> cities;
    private static Pattern pattern;
    private static BufferedReader reader;

    static {
        REGEX_SENTENCE = "(?<city>[A-Z]{2})(?<temp>[0-9]+.[0-9]+)(?<weather>[A-Za-z]+)(?=\\|)";
        cities = new LinkedHashMap<>();
        pattern = Pattern.compile(REGEX_SENTENCE);
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        String input;
        while (! "end".equals(input = reader.readLine())) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String cityCode = matcher.group("city");
                double temp = Double.parseDouble(matcher.group("temp"));
                String weather = matcher.group("weather");
                cities.put(cityCode, new City(cityCode, temp, weather));
            }
        }

        printResult();
    }

    private static void printResult() {
        cities.values().stream()
                .sorted(Comparator.comparingDouble(City::getTemp))
                .forEach(System.out::println);
    }
}

class City {
    private String code;
    private double temp;
    private String weather;

    City(String code, double temp, String weather) {
        this.code = code;
        this.temp = temp;
        this.weather = weather;
    }

    private String getCode() {
        return this.code;
    }

    double getTemp() {
        return this.temp;
    }

    private String getWeather() {
        return this.weather;
    }

    @Override
    public String toString() {
        return String.format("%s => %.2f => %s", this.getCode(), this.getTemp(), this.getWeather());
    }
}
