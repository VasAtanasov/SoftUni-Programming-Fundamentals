package L12ArraysExercises;

import java.util.Scanner;

public class Ex09IndexOfLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] letters = scanner.nextLine().toLowerCase().toCharArray();

        for (char letter : letters) {
            int value = letter - 97;
            System.out.printf("%c -> %d%n", letter, value);
        }
    }
}
