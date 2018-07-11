package L07DataTypeAndVar;

import java.util.Scanner;

public class Ex02CircleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double r = Double.parseDouble(scanner.nextLine());
        double circleArea = Math.PI * r * r;
        System.out.printf("%.12f",circleArea);

    }
}
