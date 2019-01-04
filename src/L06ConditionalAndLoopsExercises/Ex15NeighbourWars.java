package L06ConditionalAndLoopsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex15NeighbourWars {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int peshoDamage = Integer.parseInt(reader.readLine());
        int goshoDamage = Integer.parseInt(reader.readLine());
        int round = 1;
        int peshoHealth = 100;
        int goshoHealth = 100;

        while (true) {
            if (round % 2 != 0) {
                goshoHealth -= peshoDamage;
                if (goshoHealth <= 0) {
                    System.out.println(String.format("Pesho won in %dth round.", round));
                    return;
                }
                System.out.println(String.format("Pesho used Roundhouse kick and reduced Gosho to %d health.", goshoHealth));

            } else if (round % 2 == 0) {
                peshoHealth -= goshoDamage;
                if (peshoHealth <= 0) {
                    System.out.println(String.format("Gosho won in %dth round.", round));
                    return;
                }
                System.out.println(String.format("Gosho used Thunderous fist and reduced Pesho to %d health.", peshoHealth));
            }

            if (round % 3 == 0) {
                goshoHealth += 10;
                peshoHealth += 10;
            }
            round++;
        }
    }
}
