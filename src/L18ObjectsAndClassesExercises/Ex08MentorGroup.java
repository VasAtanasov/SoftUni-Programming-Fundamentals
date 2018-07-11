package L18ObjectsAndClassesExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Ex08MentorGroup {
    private static Map<String, User> users;
    private static BufferedReader reader;

    static {
        users = new TreeMap<>();
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        addDates();
        addComments();
        printResult();
    }

    private static void printResult() {
        users.values().forEach(System.out::print);
    }

    private static void addComments() throws IOException {
        String input;
        while (! "end of comments".equals(input = reader.readLine())) {
            String[] tokens = input.split("-");
            String user = tokens[0];
            String comment = tokens[1];

            if (users.containsKey(user)) {
                users.get(user).addComment(comment);
            }
        }
    }

    private static void addDates() throws IOException {
        String input;
        while (! "end of dates".equals(input = reader.readLine())) {
            String[] tokens = input.split("[,\\s]+");
            String user = tokens[0];
            users.putIfAbsent(user, new User(user));

            for (int i = 1; i < tokens.length; i++) {
                users.get(user).addDate(tokens[i]);
            }
        }
    }
}

class User {
    private String name;
    private List<String> comments;
    private List<String> dates;

    User(String name) {
        this.name = name;
        this.comments = new ArrayList<>();
        this.dates = new ArrayList<>();
    }

    void addDate(String date) {
        this.dates.add(date);
    }

    void addComment(String comment) {
        this.comments.add(comment);
    }

    private String getComments() {
        StringBuilder comments = new StringBuilder();
        this.comments.forEach(c -> comments.append(String.format("- %s%n", c)));
        return comments.toString();
    }

    private String getDates() {
        StringBuilder dates = new StringBuilder();
        this.dates.stream()
                .sorted(String::compareTo)
                .forEach(d -> dates.append(String.format("-- %s%n", d)));
        return dates.toString();
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("%s%n", this.name))
                .append(String.format("Comments:%n"))
                .append(this.getComments())
                .append(String.format("Dates attended:%n"))
                .append(this.getDates());
        return output.toString();
    }
}
