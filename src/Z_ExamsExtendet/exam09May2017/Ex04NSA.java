package Z_ExamsExtendet.exam09May2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Ex04NSA {
    private static BufferedReader reader;
    private static Map<String, Country> countries;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        countries = new LinkedHashMap<>();
    }

    public static void main(String[] args) throws IOException {
        String input;
        while (! "quit".equals(input = reader.readLine())) {
            String[] tokens = input.split(" -> ");
            String county = tokens[0];
            String spyName = tokens[1];
            long daysInService = Long.parseLong(tokens[2]);

            countries.putIfAbsent(county,new Country(county));
            countries.get(county).processSpyData(spyName,daysInService);
        }

        countries.values()
                .stream()
                .sorted()
                .forEach(System.out::print);
    }
}

class Country implements Comparable<Country> {
    private String name;
    private Map<String, Spy> spies;

    Country(String name) {
        this.name = name;
        this.spies = new LinkedHashMap<>();
    }

    void processSpyData(String name, long daysInService) {
        spies.putIfAbsent(name, new Spy(name));
        spies.get(name).setDaysInService(daysInService);
    }

    public String getName() {
        return this.name;
    }

    private int getSpyCount() {
        return spies.size();
    }

    @Override
    public int compareTo(Country other) {
        return Integer.compare(other.getSpyCount(), this.getSpyCount());
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("Country: %s%n", this.getName()));
        this.spies.values()
                .stream()
                .sorted()
                .forEach(spy -> output.append(String.format("%s%n", spy)));
        return output.toString();
    }
}

class Spy implements Comparable<Spy> {
    private String name;
    private long daysInService;

    Spy(String name) {
        this.name = name;
        this.daysInService = 0;
    }

    void setDaysInService(long daysInService) {
        this.daysInService = daysInService;
    }

    private String getName() {
        return this.name;
    }

    private long getDaysInService() {
        return this.daysInService;
    }


    @Override
    public int compareTo(Spy other) {
        return Long.compare(other.getDaysInService(), this.getDaysInService());
    }

    @Override
    public String toString() {
        return String.format("**%s : %d", this.getName(), this.daysInService);
    }
}
