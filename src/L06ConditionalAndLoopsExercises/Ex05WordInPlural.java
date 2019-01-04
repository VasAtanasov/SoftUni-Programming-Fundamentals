package L06ConditionalAndLoopsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Ex05WordInPlural {
    private static List<String> es = Arrays.asList("o", "ch", "s", "sh", "x", "z");

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();


        if (input.endsWith("y")) {
            input = input.substring(0, input.length() - 1) + "ies";
        } else if (isES(input)) {
            input = input + "es";
        } else {
            input = input + "s";
        }

        System.out.println(input);

    }

    private static boolean isES(String input) {
        for (String suffix : es) {
            if (input.endsWith(suffix)) {
                return true;
            }
        }
        return false;
    }
}
