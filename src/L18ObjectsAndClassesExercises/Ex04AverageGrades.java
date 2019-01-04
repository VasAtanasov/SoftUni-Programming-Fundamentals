package L18ObjectsAndClassesExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Ex04AverageGrades {
    private static List<Student> students;

    static {
        students = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        for (int i = 0; i < count; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            String name = tokens[0];
            Student student = new Student(name);
            for (int j = 1; j < tokens.length; j++) {
                student.addGrade(Double.parseDouble(tokens[j]));
            }
            students.add(student);
        }

        students.stream()
                .filter(student -> student.getAverageGrade() >= 5.0)
                .sorted()
                .forEach(System.out::println);

    }

    static class Student implements Comparable<Student> {
        private String name;
        private List<Double> grades;

        Student(String name) {
            this.name = name;
            this.grades = new ArrayList<>();
        }

        private String getName() {
            return this.name;
        }

        void addGrade(double grade) {
            this.grades.add(grade);
        }

        double getAverageGrade() {
            return this.grades.stream().reduce(0D, (a, b) -> a + b) / grades.size();
        }

        @Override
        public int compareTo(Student otherStudent) {
            int index = this.getName().compareTo(otherStudent.getName());
            return index != 0 ? index : Double.compare(otherStudent.getAverageGrade(), this.getAverageGrade());
        }

        @Override
        public String toString() {
            return String.format("%s -> %.2f", this.getName(), this.getAverageGrade());
        }
    }
}



