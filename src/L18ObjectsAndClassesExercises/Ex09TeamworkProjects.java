package L18ObjectsAndClassesExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ex09TeamworkProjects {
    private static BufferedReader reader;
    private static Map<String, Team> teams;
    private static List<String> creators = new ArrayList<>();

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        teams = new LinkedHashMap<>();
    }

    public static void main(String[] args) throws IOException {
        createTeams();
        addMembers();
        printResult();
    }

    private static void printResult() {
        StringBuilder output = new StringBuilder();

        teams.values().stream()
                .filter(t -> t.getMembersCount() > 0)
                .sorted((t1, t2) -> {
                    int index = Integer.compare(t2.getMembersCount(), t1.getMembersCount());
                    return index != 0 ? index : t1.getName().compareTo(t2.getName());
                })
                .forEach(output::append);
        output
                .append("Teams to disband:")
                .append(System.lineSeparator());

        teams.values()
                .stream()
                .filter(t -> t.getMembersCount() == 0)
                .map(Team::getName)
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .forEach(team -> output.append(team).append(System.lineSeparator()));

        System.out.println(output.toString());
    }

    private static void addMembers() throws IOException {
        String input;
        while (! "end of assignment".equals(input = reader.readLine())) {
            String[] tokens = input.split("->");
            String member = tokens[0];
            String team = tokens[1];

            if (! teams.containsKey(team)) {
                System.out.println(String.format("Team %s does not exist!", team));
                continue;
            }

            if (teams.values().stream().anyMatch(t -> t.containsMember(member) || t.getCreator().equals(member))) {
                System.out.println(String.format("Member %s cannot join team %s!", member, team));
                continue;
            }

            teams.get(team).addMember(member);
        }
    }

    private static void createTeams() throws IOException {
        int count = Integer.parseInt(reader.readLine());
        for (int i = 0; i < count; i++) {
            String[] tokens = reader.readLine().split("-");
            String creator = tokens[0];
            String team = tokens[1];

            if (teams.containsKey(team)) {
                System.out.println(String.format("Team %s was already created!", team));
                continue;
            }

            if (creators.contains(creator)) {
                System.out.println(String.format("%s cannot create another team!", creator));
                continue;
            }

//            if (teams.values().stream().map(Team::getCreator).anyMatch(c -> c.equals(creator))) {
//                System.out.println(String.format("%s cannot create another team!", creator));
//                continue;
//            }

            teams.put(team, new Team(team, creator));
            System.out.println(String.format("Team %s has been created by %s!", team, creator));
            creators.add(creator);
        }
    }
}

class Team {
    private String name;
    private String creator;
    private List<String> members;

    Team(String name, String creator) {
        this.name = name;
        this.creator = creator;
        this.members = new ArrayList<>();
    }

    String getCreator() {
        return this.creator;
    }

    String getName() {
        return this.name;
    }

    int getMembersCount() {
        return this.members.size();
    }

    void addMember(String member) {
        this.members.add(member);
    }

    boolean containsMember(String member) {
        return this.members.contains(member);
    }

    private String getMembers() {
        StringBuilder members = new StringBuilder();
        this.members.stream()
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .forEach(m -> members.append(String.format("-- %s%n", m)));
        return members.toString();
    }

    @Override
    public String toString() {
        return String.format("%s%n", this.name) +
                String.format("- %s%n", this.creator) +
                this.getMembers();
    }
}
