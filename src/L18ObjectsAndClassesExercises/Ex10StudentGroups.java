package L18ObjectsAndClassesExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class Ex10StudentGroups {
    private static BufferedReader reader;
    private static Deque<Town> towns;
    private static List<Group> groups;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        towns = new ArrayDeque<>();
        groups = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        registerStudents();

        distributeStudentsIntoGroups();

        System.out.println(String.format("Created %d groups in %d towns:", groups.size(), towns.stream().map(Town::getName).distinct().count()));
        groups.stream()
                .sorted()
                .forEach(System.out::println);
    }

    private static void distributeStudentsIntoGroups() {
        for (Town town : towns) {
            List<Student> students = town.getStudents();
            int seatsCount = town.getSeatsCount();
            while (! students.isEmpty()) {
                Group group = new Group(town);
                group.addAll(students.stream().limit(seatsCount).collect(Collectors.toCollection(ArrayList::new)));
                students = students.stream().skip(seatsCount).collect(Collectors.toCollection(ArrayList::new));
                groups.add(group);
            }
        }
    }

    private static void registerStudents() throws IOException {
        String input;
        while (! "End".equals(input = reader.readLine())) {
            if (input.contains("=>")) {
                String[] tokens = input.split("=>");
                String town = tokens[0].trim();
                int seatsCount = Integer.parseInt(tokens[1].trim().split("\\s+")[0].trim());
                towns.addLast(new Town(town, seatsCount));
            } else if (! towns.isEmpty()) {
                String[] tokens = input.split("\\|");
                String name = tokens[0].trim();
                String email = tokens[1].trim();
                String date = tokens[2].trim();
                towns.peekLast().add(new Student(name, email, date));
            }
        }
    }

}

class Town {
    private String name;
    private int seatsCount;
    private List<Student> students;

    Town(String name, int seatsCount) {
        this.name = name;
        this.seatsCount = seatsCount;
        this.students = new ArrayList<>();
    }

    String getName() {
        return this.name;
    }

    int getSeatsCount() {
        return this.seatsCount;
    }

    void add(Student student) {
        this.students.add(student);
    }

    List<Student> getStudents() {
        return this.students
                .stream()
                .sorted()
                .collect(Collectors.toCollection(ArrayList::new));
    }
}

class Student implements Comparable<Student> {
    private static DateTimeFormatter dtf;

    static {
        dtf = DateTimeFormatter.ofPattern("d-MMM-yyyy");
    }

    private String name;
    private String email;
    private LocalDate registrationDate;

    Student(String name, String email, String date) {
        this.name = name;
        this.email = email;
        this.registrationDate = LocalDate.parse(date, dtf);
    }

    String getName() {
        return this.name;
    }

    private String getEmail() {
        return this.email;
    }

    private LocalDate getRegistrationDate() {
        return this.registrationDate;
    }

    @Override
    public int compareTo(Student other) {
        int index = this.getRegistrationDate().compareTo(other.getRegistrationDate());
        index = (index != 0) ? index : this.getName().compareTo(other.getName());
        index = (index != 0) ? index : this.getEmail().compareTo(other.getEmail());
        return index;
    }

    @Override
    public String toString() {
        return this.getEmail();
    }
}

class Group implements Comparable<Group> {
    private Town town;
    private List<Student> students;

    Group(Town town) {
        this.town = town;
        this.students = new ArrayList<>();
    }

    private String getTown() {
        return this.town.getName();
    }

    private String getStudentsString() {
        return this.students.toString().replaceAll("[\\[\\]]", "");
    }

    void addAll(List<Student> students) {
        this.students.addAll(students);
    }

    @Override
    public int compareTo(Group other) {
        return this.getTown().compareTo(other.getTown());
    }

    @Override
    public String toString() {
        return String.format("%s => %s", this.getTown(), this.getStudentsString());
    }
}