package L11Arrays;

import java.util.Scanner;

public class Ex06ReverseArray {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] input = scanner.nextLine().split("\\s+");
        reverseStringArray(input);
        printStringArray(input);


    }

    private static void reverseStringArray(String[] input) {
              String temp = "";
        int n = input.length - 1;
        for (int i = 0; i < input.length / 2; i++) {
            temp = input[i];
            input[i] = input[n - i];
            input[n - i] = temp;
        }

    }

    private static void printStringArray(String[] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i]);
            if (i == input.length - 1) {
                break;
            }
            System.out.print(" ");
        }
    }
}
