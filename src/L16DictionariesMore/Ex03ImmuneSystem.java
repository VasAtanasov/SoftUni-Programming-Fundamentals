package L16DictionariesMore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Ex03ImmuneSystem {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ImmuneSystem immuneSystem = new ImmuneSystem(Integer.parseInt(reader.readLine()));

        String virusName;
        while (! "end".equals(virusName = reader.readLine())) {
            Virus virus = new Virus(virusName);
            immuneSystem.fightVirus(virus);
            System.out.println(immuneSystem.getStats(virus));
            if (immuneSystem.isDefeated()) {
                return;
            }
        }

        System.out.println(immuneSystem);
    }
}

class ImmuneSystem {
    private final int INITIAL_HEALTH;
    private int health;
    private HashMap<String, Virus> viruses;
    private boolean isDefeated;

    ImmuneSystem(int health) {
        this.INITIAL_HEALTH = health;
        this.health = health;
        this.viruses = new LinkedHashMap<>();
        this.isDefeated = false;
    }

    private int getHealth() {
        return this.health;
    }

    boolean isDefeated() {
        return this.isDefeated;
    }

    String getStats(Virus virus) {
        StringBuilder output = new StringBuilder();
        int secondsToDefeat = this.calculateTimeToDefeat(virus);

        output.append(String.format("Virus %s: %d => %d seconds",
                virus.getName(),
                virus.getStrength(),
                secondsToDefeat))
                .append(System.lineSeparator());

        if (this.isDefeated) {
            output.append("Immune System Defeated.");
        } else {
            output.append(String.format("%s defeated in %dm %ds.", virus.getName(), secondsToDefeat / 60, secondsToDefeat % 60))
                    .append(System.lineSeparator())
                    .append(String.format("Remaining health: %d", this.getHealth()));

            this.regenerateHealth();
        }

        this.viruses.putIfAbsent(virus.getName(), virus);

        return output.toString();
    }

    private void regenerateHealth() {
        int regeneration = (int) (this.getHealth() * 1.2);
        this.health = this.health * 1.2 > INITIAL_HEALTH ? INITIAL_HEALTH : regeneration;
    }

    void fightVirus(Virus virus) {
        if (this.getHealth() - this.calculateTimeToDefeat(virus) <= 0) {
            isDefeated = true;
        } else {
            this.health -= this.calculateTimeToDefeat(virus);
        }
    }


    private int calculateTimeToDefeat(Virus virus) {
        int secondsToDefeat;
        if (this.viruses.containsKey(virus.getName())) {
            secondsToDefeat = (virus.getStrength() * virus.getName().length()) / 3;
        } else {
            secondsToDefeat = virus.getStrength() * virus.getName().length();
        }
        return secondsToDefeat;
    }

    @Override
    public String toString() {
        return String.format("Final Health: %d", this.getHealth());
    }
}

class Virus {
    private String name;
    private int strength;

    Virus(String name) {
        this.name = name;
        this.setStrength(name);
    }

    String getName() {
        return this.name;
    }

    int getStrength() {
        return this.strength;
    }

    private void setStrength(String name) {
        this.strength = name.chars().sum() / 3;
    }
}

