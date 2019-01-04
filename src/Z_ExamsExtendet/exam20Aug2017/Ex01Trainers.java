package Z_ExamsExtendet.exam20Aug2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Ex01Trainers {
    private static BufferedReader reader;
    private static Map<String, Team> teams;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        teams = new LinkedHashMap<>();
    }

    public static void main(String[] args) throws IOException {
        createTeams();
        receiveInput();
        printResult();
    }

    private static void createTeams() {
        teams.put("Technical", new Team("Technical"));
        teams.put("Theoretical", new Team("Theoretical"));
        teams.put("Practical", new Team("Practical"));
    }

    private static void receiveInput() throws IOException {
        int count = Integer.parseInt(reader.readLine());
        for (int i = 0; i < count; i++) {
            double miles = Double.parseDouble(reader.readLine());
            double tonsOfCargo = Double.parseDouble(reader.readLine());
            String team = reader.readLine();

            teams.get(team).setMeters(miles);
            teams.get(team).setKilograms(tonsOfCargo);
        }
    }

    private static void printResult() {
        teams.values()
                .stream()
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);
    }
}

class Team implements Comparable<Team> {
    private String name;
    private double meters;
    private double kilograms;

    Team(String name) {
        this.name = name;
        this.kilograms = 0.0;
        this.meters = 0.0;
    }

    void setMeters(double miles) {
        this.meters += (miles * 1600);
    }

    void setKilograms(double tones) {
        this.kilograms += (tones * 1000);
    }

    private String getName() {
        return this.name;
    }

    private double getEarnedMoney() {
        return (this.kilograms * 1.5) - (0.7 * this.meters * 2.5);
    }

    @Override
    public int compareTo(Team other) {
        return Double.compare(other.getEarnedMoney(), this.getEarnedMoney());
    }

    @Override
    public String toString() {
        return String.format("The %s Trainers win with $%.3f.", this.getName(), this.getEarnedMoney());
    }
}




