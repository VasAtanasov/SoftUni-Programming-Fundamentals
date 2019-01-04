package L12ArraysExercises;

import java.util.Scanner;

public class Ex01LargestCommonEnd {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] arrayOne = scanner.nextLine().split("\\s+");
        String[] arrayTwo = scanner.nextLine().split("\\s+");

        int shortestArray = Math.min(arrayOne.length, arrayTwo.length);

        int commonEndLeft = 0;
        int commonEndRight = 0;

        for (int i = 0; i < shortestArray; i++) {
            if (arrayOne[i].equals(arrayTwo[i])) {
                commonEndLeft++;
            }
            if (arrayOne[arrayOne.length-i-1].equals(arrayTwo[arrayTwo.length-i-1])) {
                commonEndRight++;
            }
        }

        System.out.println(Math.max(commonEndLeft, commonEndRight));
    }
}
