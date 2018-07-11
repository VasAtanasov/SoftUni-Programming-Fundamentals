package Z_ExamsExtendet.exam30Apr2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Ex04WormsParty {
    private static BufferedReader reader;
    private static Map<String, Worm> worms;
    private static Map<String, Team> teams;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        worms = new LinkedHashMap<>();
        teams = new LinkedHashMap<>();
    }

    public static void main(String[] args) throws IOException {
        registerWorms();
        distributeToTeams();
        printResult();
    }

    private static void printResult() {
        int[] rank = {1};
        teams.values()
                .stream()
                .sorted()
                .forEach(team -> {
                    System.out.println(String.format("%d. Team: %s - %d", rank[0]++, team.getName(), team.getTotalScore()));
                    team.getWorms()
                            .stream()
                            .sorted()
                            .forEach(System.out::println);
                });
    }

    private static void registerWorms() throws IOException {
        String input;
        while (! "quit".equals(input = reader.readLine())) {
            String[] tokens = input.split(" -> ");
            String worm = tokens[0];
            String team = tokens[1];
            int score = Integer.parseInt(tokens[2]);
            worms.putIfAbsent(worm, new Worm(worm, team, score));
        }
    }

    private static void distributeToTeams() {
        worms.values()
                .forEach(worm -> {
                    teams.putIfAbsent(worm.getTeam(), new Team(worm.getTeam()));
                    teams.get(worm.getTeam()).add(worm);
                });
    }
}

class Team implements Comparable<Team> {
    private String name;
    private List<Worm> worms;

    Team(String name) {
        this.name = name;
        this.worms = new ArrayList<>();
    }

    String getName() {
        return this.name;
    }

    List<Worm> getWorms() {
        return this.worms;
    }

    void add(Worm worm) {
        this.worms.add(worm);
    }

    long getTotalScore() {
        return worms.stream()
                .mapToLong(Worm::getScore)
                .sum();
    }

    private double getAverageScore() {
        return this.getTotalScore() / this.worms.size();
    }

    @Override
    public int compareTo(Team other) {
        int index = Long.compare(other.getTotalScore(), this.getTotalScore());
        return index != 0 ? index : Double.compare(other.getAverageScore(), this.getAverageScore());
    }
}

class Worm implements Comparable<Worm> {
    private String name;
    private String team;
    private long score;

    Worm(String name, String team, int score) {
        this.name = name;
        this.team = team;
        this.score = score;
    }

    String getName() {
        return this.name;
    }

    String getTeam() {
        return this.team;
    }

    long getScore() {
        return this.score;
    }

    @Override
    public int compareTo(Worm other) {
        return Long.compare(other.getScore(), this.getScore());
    }

    @Override
    public String toString() {
        return String.format("###%s : %d", this.getName(), this.getScore());
    }
}
