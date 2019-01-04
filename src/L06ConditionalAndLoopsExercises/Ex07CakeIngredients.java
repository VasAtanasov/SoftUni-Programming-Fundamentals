package L06ConditionalAndLoopsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex07CakeIngredients {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        int count = 0;
        while (! "Bake!".equals(input = reader.readLine())) {
            System.out.println(String.format("Adding ingredient %s.", input));
            count++;
        }

        System.out.println(String.format("Preparing cake with %d ingredients.", count));
    }
}
