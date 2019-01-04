package L12ArraysExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex09IndexOfLetters01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] input = reader.readLine().toCharArray();

        for (char character : input) {
            System.out.println(String.format("%c -> %d", character, (character - 97)));
        }
    }
}
