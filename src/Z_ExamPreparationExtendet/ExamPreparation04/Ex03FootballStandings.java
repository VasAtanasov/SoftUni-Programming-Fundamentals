package Z_ExamPreparationExtendet.ExamPreparation04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Ex03FootballStandings {
    private static BufferedReader reader;
    private static Map<String, Team> teams;
    private static String key;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        teams = new LinkedHashMap<>();
    }

    public static void main(String[] args) throws IOException {
        key = reader.readLine();

        String input;
        while (! "final".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");
            String teamOne = decrypt(tokens[0]);
            long teamOneScore = Integer.parseInt(tokens[2].split(":")[0]);
            putIfAbsent(teamOne);
            teams.get(teamOne).setGoals(teamOneScore);

            String teamTwo = decrypt(tokens[1]);
            long teamTwoScore = Integer.parseInt(tokens[2].split(":")[1]);
            putIfAbsent(teamTwo);
            teams.get(teamTwo).setGoals(teamTwoScore);

            if (teamOneScore == teamTwoScore) {
                setPoints(teamOne, 1);
                setPoints(teamTwo, 1);
            } else if (teamOneScore > teamTwoScore) {
                setPoints(teamOne, 3);
            } else {
                setPoints(teamTwo, 3);
            }
        }

        System.out.println("League standings:");
        int[] rank = {1};
        teams.values().stream()
                .sorted()
                .forEach(team -> System.out.println(String.format("%d. %s",rank[0]++,team.getPointsString())));
        System.out.println("Top 3 scored goals:");
        teams.values()
                .stream()
                .sorted((t1,t2) -> {
                    int index = Long.compare(t2.getGoals(), t1.getGoals());
                    return index != 0 ? index : t1.getName().compareTo(t2.getName());
                })
                .limit(3)
                .forEach(team -> System.out.println(String.format("- %s",team.getGoalsString())));


    }

    private static void setPoints(String teamTwo, int points) {
        teams.get(teamTwo).setPoints(points);
    }

    private static void putIfAbsent(String teamName) {
        teams.putIfAbsent(teamName, new Team(teamName));
    }

    private static String decrypt(String team) {
        while (team.contains(key)) {
            int leftIndex = team.indexOf(key) + key.length();
            int rightIndex = team.lastIndexOf(key);
            team = team.substring(leftIndex, rightIndex);
        }
        return new StringBuilder(team).reverse().toString().toUpperCase();
    }
}

class Team implements Comparable<Team> {
    private String name;
    private int points;
    private long goals;

    Team(String name) {
        this.name = name;
        this.points = 0;
        this.goals = 0;
    }

    void setGoals(long goals) {
        this.goals += goals;
    }

    void setPoints(int points) {
        this.points += points;
    }

    String getPointsString() {
        return String.format("%s %s", this.name, this.points);
    }

    String getGoalsString() {
        return String.format("%s -> %s", this.name, this.goals);
    }

    String getName() {
        return this.name;
    }

    int getPoints() {
        return this.points;
    }

    long getGoals() {
        return this.goals;
    }

    @Override
    public int compareTo(Team otherTeam) {
        int index = Integer.compare(otherTeam.getPoints(), this.getPoints());
        return index != 0 ? index : this.getName().compareTo(otherTeam.getName());
    }
}
