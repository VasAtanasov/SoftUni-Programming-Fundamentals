package Exam01Jul2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Ex02SoftUniCoursePlanning01 {
    private static BufferedReader reader;
    private static List<Lesson> lessons;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        getInitialList();
        String input;
        while (! "course start".equals(input = reader.readLine())) {
            String[] tokens = input.split(":");
            String command = tokens[0];
            String lessonTitle = tokens[1];

            switch (command) {
                case "Add":
                    addLesson(lessonTitle);
                    break;
                case "Insert":
                    insertLesson(tokens[2], lessonTitle);
                    break;
                case "Remove":
                    removeLessons(lessonTitle);
                    break;
                case "Swap":
                    swapLessons(tokens[2], lessonTitle);
                    break;
                case "Exercise":
                    setExercise(lessonTitle);
                    break;
            }
        }

        printLessons();
    }

    private static void swapLessons(String otherLessonTitle, String lessonTitle) {
        if (isLesson(lessonTitle) && isLesson(otherLessonTitle)) {
            int[] indexes = new int[2];
            for (int i = 0; i < lessons.size(); i++) {
                if (lessons.get(i).getTitle().equals(lessonTitle)) {
                    indexes[0] = i;
                }
                if (lessons.get(i).getTitle().equals(otherLessonTitle)) {
                    indexes[1] = i;
                }
            }

            Lesson temp = lessons.get(indexes[0]);
            lessons.set(indexes[0], lessons.get(indexes[1]));
            lessons.set(indexes[1], temp);
        }
    }

    private static void printLessons() {
        int rank = 1;
        for (Lesson lesson : lessons) {
            System.out.println(String.format("%d.%s", rank++, lesson));
            if (lesson.hasExercise()) {
                System.out.println(String.format("%d.%s-Exercise", rank++, lesson));
            }
        }
    }

    private static void setExercise(String lessonTitle) {
        if (isLesson(lessonTitle)) {
            lessons.forEach(lesson -> {
                if (lesson.getTitle().equals(lessonTitle)) {
                    lesson.setExercise();
                }
            });
        } else {
            Lesson lesson = new Lesson(lessonTitle);
            lesson.setExercise();
            lessons.add(lesson);
        }
    }

    private static void removeLessons(String lessonTitle) {
        lessons.removeIf(lesson -> lesson.getTitle().startsWith(lessonTitle));
    }

    private static void insertLesson(String token, String lessonTitle) {
        int insertIndex = Integer.parseInt(token);
        if (isValid(insertIndex) && lessons.stream().noneMatch(lesson -> lesson.getTitle().equals(lessonTitle))) {
            lessons.add(insertIndex, new Lesson(lessonTitle));
        }
    }

    private static void addLesson(String lessonTitle) {
        if (lessons.stream().noneMatch(lesson -> lesson.getTitle().equals(lessonTitle))) {
            lessons.add(new Lesson(lessonTitle));
        }
    }

    private static boolean isLesson(String lessonTitle) {
        return lessons.stream().anyMatch(lesson -> lesson.getTitle().equals(lessonTitle));
    }

    private static boolean isValid(int index) {
        return index >= 0;
    }

    private static void getInitialList() throws IOException {
        lessons = Arrays.stream(reader.readLine().split("[,\\s]+"))
                .filter(s -> ! s.isEmpty())
                .map(Lesson::new)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}

class Lesson {
    private String title;
    private boolean hasExercise;

    Lesson(String title) {
        this.title = title;
        this.hasExercise = false;
    }

    String getTitle() {
        return this.title;
    }

    boolean hasExercise() {
        return this.hasExercise;
    }

    void setExercise() {
        this.hasExercise = true;
    }

    @Override
    public String toString() {
        return title;
    }
}