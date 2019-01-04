package L07DataTypeAndVar;

import java.util.Scanner;

public class Ex04Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double numberOfPeople = Double.parseDouble(scanner.nextLine());
        double capacity = Double.parseDouble(scanner.nextLine());

        double courses = Math.ceil(numberOfPeople/capacity);

        System.out.printf("%.0f", courses);

    }
}
