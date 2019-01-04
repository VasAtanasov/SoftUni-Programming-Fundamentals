package L18ObjectsAndClassesExercises;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Ex10StudentGroups01 {
    private static DateTimeFormatter dataFormat = DateTimeFormatter.ofPattern("d-MMM-y");

    private static class Town {
        private String townName;
        private long seatCount;
        private List<Student> students;
        private List<Group> groups;

        private Town(String name, long seats) {
            this.townName = name;
            this.seatCount = seats;
            this.students = new ArrayList<>();
            this.groups = new ArrayList<>();
        }

        private List<Student> getStudentsSorted() {
            return students.stream()
                    .sorted((a, b) -> {
                        int index = a.getRegistrationDate().compareTo(b.getRegistrationDate());
                        index = (index != 0) ? index : String.CASE_INSENSITIVE_ORDER.compare(a.getStudentName(), b.getStudentName());
                        index = (index != 0) ? index : a.getStudentName().compareTo(b.getStudentName());
                        index = (index != 0) ? index : String.CASE_INSENSITIVE_ORDER.compare(a.getStudentEmail(), b.getStudentEmail());
                        index = (index != 0) ? index : a.getStudentEmail().compareTo(b.getStudentEmail());
                        return index;
                    })
                    .collect(Collectors.toCollection(ArrayList::new));
        }

        private List<Group> getGroups() {
            return groups;
        }

        private void addGroup(Group group) {
            groups.add(group);
        }

        private void addStudent(Student student) {
            students.add(student);
        }

        private long getSeatCount() {
            return seatCount;
        }

        private String getTownName() {
            return townName;
        }
    }


    private static class Student {
        private String studentName;
        private String studentEmail;
        private LocalDate registrationDate;

        private Student(String name, String email, LocalDate date) {
            this.studentName = name;
            this.studentEmail = email;
            this.registrationDate = date;
        }

        private LocalDate getRegistrationDate() {
            return registrationDate;
        }

        private String getStudentEmail() {
            return studentEmail;
        }

        private String getStudentName() {
            return studentName;
        }
    }

    private static class Group {
        private List<Student> students;

        private Group() {
            this.students = new ArrayList<>();
        }

        private List<Student> getGroupedStudents() {
            return students;
        }

        private void addStudent(Student student) {
            this.students.add(student);
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Town> towns = new ArrayList<>();
        allocateTowns(reader, towns);
        createGroupsInTowns(towns);
        printStatistics(towns);
        printTownInformation(towns);


    }

    private static void printStatistics(List<Town> towns) {
        int groupCount = 0;
        for (Town town : towns) {
            groupCount += town.getGroups().size();
        }
        System.out.println(String.format("Created %d groups in %d towns:",groupCount,towns.size()));
    }

    private static void printTownInformation(List<Town> towns) {
        towns.stream()
                .sorted((a, b) -> {
                    int index = String.CASE_INSENSITIVE_ORDER.compare(a.getTownName(), b.getTownName());
                    index = (index != 0) ? index : a.getTownName().compareTo(b.getTownName());
                    return index;
                })
                .forEach(town -> {
                    town.getGroups().forEach(group -> {
                        System.out.print(String.format("%s => ", town.getTownName()));
                        printEmails(group);
                    });
                });
    }

    private static void printEmails(Group group) {
        List<Student> students = new ArrayList<>(group.getGroupedStudents());
        StringBuilder print = new StringBuilder();
        for (int i = 0; i < students.size(); i++) {
            print.append(students.get(i).getStudentEmail());
            if (i == students.size() - 1) {
                break;
            }
            print.append(", ");
        }
        System.out.println(print.toString());
    }

    private static void createGroupsInTowns(List<Town> towns) {
        for (Town town : towns) {
            List<Student> students = town.getStudentsSorted();
            long groupCount;
            long studentCount = students.size();
            long seatCount = town.getSeatCount();

            groupCount = (studentCount % seatCount == 0) ? studentCount / seatCount : (studentCount / seatCount) + 1;
            groupCount = (groupCount == 0) ? 1 : groupCount;

            int studentIndex = 0;
            int studentsInGroup = 0;
            for (int i = 0; i < groupCount; i++) {
                Group group = new Group();
                for (int j = studentIndex; j < students.size(); j++) {
                    group.addStudent(students.get(j));
                    studentsInGroup++;

                    if (studentsInGroup == seatCount) {
                        studentIndex = j + 1;
                        studentsInGroup = 0;
                        break;
                    }
                }
                town.addGroup(group);
            }
        }
    }

    private static void allocateTowns(BufferedReader reader, List<Town> towns) throws IOException {
        Pattern townPattern = Pattern.compile("^(?<town>[^\\n]+) => (?<seats>[0-9]+) seats$");
        Pattern studentPattern = Pattern.compile("^\\s*(?<studentName>[^\\n]*)\\s*\\|\\s*(?<studentEmail>[^\\n\\s]*)\\s*\\|\\s*(?<date>[0-9A-Za-z-]*)\\s*$");

        String input = reader.readLine();
        while (! "End".equals(input)) {

            Matcher townMatcher = townPattern.matcher(input);

            if (townMatcher.find()) {
                String townName = townMatcher.group("town");
                long seats = Long.valueOf(townMatcher.group("seats"));

                Town town = new Town(townName, seats);
                input = registerStudents(reader, studentPattern, input, town);
                towns.add(town);
            }
        }
    }

    private static String registerStudents(BufferedReader reader, Pattern studentPattern, String input, Town town) throws IOException {
        boolean isStudent = true;
        while (isStudent) {
            input = reader.readLine();
            Matcher studentMatcher = studentPattern.matcher(input);

            if (studentMatcher.find()) {
                String studentName = studentMatcher.group("studentName").trim();
                String studentEmail = studentMatcher.group("studentEmail").trim();
                LocalDate date = LocalDate.parse(studentMatcher.group("date").trim(), dataFormat);

                Student student = new Student(studentName, studentEmail, date);
                town.addStudent(student);

            } else {
                isStudent = false;
            }
        }
        return input;
    }
}

