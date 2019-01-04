package Z_Exams.exam25Apr2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Ex04MOBAChallenger {
    private static BufferedReader reader;
    private static Map<String, Player> players;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        players = new LinkedHashMap<>();
    }

    public static void main(String[] args) throws IOException {
        String input;
        while (! "Season end".equals(input = reader.readLine())) {
            if (input.matches("[^\\s]+ -> [^\\s]+ -> [0-9]+")) {
                processPlayer(input);

            } else if (input.matches("[^\\s]+ vs [^\\s]+")) {
                performDuel(input);

            }
        }

        players.values()
                .stream()
                .sorted()
                .forEach(System.out::print);

    }

    private static void performDuel(String input) {
        String[] tokens = input.split(" vs ");
        String playerOne = tokens[0];
        String playerTwo = tokens[1];
        if (players.containsKey(playerOne) && players.containsKey(playerTwo) && haveInCommon(playerOne, playerTwo)) {
            int playerOneSkills = players.get(playerOne).getTotalSkillPoints();
            int playerTwoSkills = players.get(playerTwo).getTotalSkillPoints();

            if (playerOneSkills > playerTwoSkills) {
                players.remove(playerTwo);
            } else if (playerTwoSkills > playerOneSkills) {
                players.remove(playerOne);
            }

        }
    }

    private static boolean haveInCommon(String playerOne, String playerTwo) {
        Map<String, Position> positionsPlayerOne = players.get(playerOne).getPositions();
        Map<String, Position> positionsPlayerTwo = players.get(playerTwo).getPositions();

        for (String position : positionsPlayerOne.keySet()) {
            if (positionsPlayerTwo.containsKey(position)) {
                return true;
            }
        }

        return false;
    }

    private static void processPlayer(String input) {
        String[] tokens = input.split(" -> ");
        String player = tokens[0];
        String position = tokens[1];
        int skill = Integer.parseInt(tokens[2]);

        players.putIfAbsent(player, new Player(player));
        players.get(player).registerPosition(position, skill);
    }
}

class Player implements Comparable<Player> {
    private String name;
    private Map<String, Position> positions;

    Player(String name) {
        this.name = name;
        this.positions = new LinkedHashMap<>();
    }

    private String getName() {
        return this.name;
    }

    Map<String, Position> getPositions() {
        return this.positions;
    }

    void registerPosition(String position, int skill) {
        this.positions.putIfAbsent(position, new Position(position, skill));
        this.positions.get(position).setSkill(skill);
    }

    int getTotalSkillPoints() {
        return this.positions.values()
                .stream()
                .mapToInt(Position::getSkill)
                .sum();
    }

    @Override
    public int compareTo(Player other) {
        int index = Integer.compare(other.getTotalSkillPoints(), this.getTotalSkillPoints());
        return index != 0 ? index : this.getName().compareTo(other.getName());
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("%s: %d skill%n", this.getName(), this.getTotalSkillPoints()));
        this.positions.values()
                .stream()
                .sorted()
                .forEach(position -> output.append(String.format("%s%n", position)));
        return output.toString();
    }
}

class Position implements Comparable<Position> {
    private String position;
    private int skill;

    Position(String position, int value) {
        this.position = position;
        this.skill = value;
    }

    private String getPosition() {
        return this.position;
    }

    int getSkill() {
        return this.skill;
    }

    void setSkill(int skill) {
        if (skill > this.skill) {
            this.skill = skill;
        }
    }

    @Override
    public int compareTo(Position other) {
        int index = Integer.compare(other.getSkill(), this.getSkill());
        return index != 0 ? index : this.getPosition().compareTo(other.getPosition());
    }

    @Override
    public String toString() {
        return String.format("- %s <::> %d", this.getPosition(), this.getSkill());
    }
}