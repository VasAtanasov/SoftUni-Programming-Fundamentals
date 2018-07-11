package L04IntroAndSyntaxExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex05CharacterStats {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        int currentHealth = Integer.parseInt(reader.readLine());
        int maxHealth = Integer.parseInt(reader.readLine());
        int currentEnergy = Integer.parseInt(reader.readLine());
        int maxEnergy = Integer.parseInt(reader.readLine());

        System.out.println(String.format("Name: %s", name));
        System.out.println("Health: |" + generateFrom("|", currentHealth) + generateFrom(".", maxHealth - currentHealth) + "|");
        System.out.println("Energy: |" + generateFrom("|", currentEnergy) + generateFrom(".", maxEnergy - currentEnergy) + "|");

    }

    private static String generateFrom(String input, int times) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < times; i++) {
            builder.append(input);
        }
        return builder.toString();
    }
}
