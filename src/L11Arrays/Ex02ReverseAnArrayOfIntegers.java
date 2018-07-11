package L11Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Ex02ReverseAnArrayOfIntegers {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = Integer.parseInt(scanner.nextLine());
        int[] array = assignReversedIntArray(n);
        System.out.println(Arrays.toString(array));
    }

    private static int[] assignReversedIntArray(int n) {
        int[] array = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int number = Integer.parseInt(scanner.nextLine());
            array[i] = number;
        }
        return array;
    }
}
