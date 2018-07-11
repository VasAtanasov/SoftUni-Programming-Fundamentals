package Exam01Jul2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex01SoftUniReception {
    private static BufferedReader reader;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        int employeeOne = Integer.parseInt(reader.readLine());
        int employeeTwo = Integer.parseInt(reader.readLine());
        int employeeThree = Integer.parseInt(reader.readLine());
        int studentsCount = Integer.parseInt(reader.readLine());

        int answersPerHour = employeeOne + employeeTwo + employeeThree;

        int totalHours = 0;

        while (studentsCount > 0) {
            totalHours++;
            if (totalHours % 4 != 0) {
                studentsCount -= answersPerHour;
            }
        }

        System.out.println(String.format("Time needed: %dh.",totalHours));

    }
}
