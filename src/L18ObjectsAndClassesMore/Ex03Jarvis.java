package L18ObjectsAndClassesMore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ex03Jarvis {
    private static Jarvis jarvis;
    private static BufferedReader reader;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        jarvis = new Jarvis(Long.parseLong(reader.readLine()));

        String input;
        while (! "Assemble!".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");
            String component = tokens[0];
            int energyConsumption = Integer.parseInt(tokens[1]);
            String parameter1 = tokens[2];
            String parameter2 = tokens[3];

            switch (component) {
                case "Head":
                    int IQ = Integer.parseInt(parameter1);
                    jarvis.setHead(new Head(energyConsumption, IQ, parameter2));
                    break;
                case "Torso":
                    double CPUSize = Double.parseDouble(parameter1);
                    jarvis.setTorso(new Torso(energyConsumption, CPUSize, parameter2));
                    break;
                case "Leg":
                    int strength = Integer.parseInt(parameter1);
                    int speed = Integer.parseInt(parameter2);
                    jarvis.setLeg(new Leg(energyConsumption, strength, speed));
                    break;
                case "Arm":
                    int reach = Integer.parseInt(parameter1);
                    int fingers = Integer.parseInt(parameter2);
                    jarvis.setArm(new Arm(energyConsumption, reach, fingers));
                    break;
            }
        }


        System.out.println(jarvis);


    }
}

class Jarvis {
    private long power;
    private Head head;
    private Torso torso;
    private List<Arm> arms;
    private List<Leg> legs;

    Jarvis(long power) {
        this.power = power;
        this.arms = new ArrayList<>();
        this.legs = new ArrayList<>();
    }

    public void setHead(Head head) {
        if (this.head == null || this.head.getEnergyConsumption() > head.getEnergyConsumption()) {
            this.head = head;
        }
    }

    public void setTorso(Torso torso) {
        if (this.torso == null || this.torso.getEnergyConsumption() > torso.getEnergyConsumption()) {
            this.torso = torso;
        }
    }

    public void setArm(Arm arm) {
        if (this.arms.size() == 0) {
            this.arms.add(arm);
        } else if (this.arms.size() == 1) {
            this.arms.add(arm);
        } else if (this.arms.get(0).getEnergyConsumption() > arm.getEnergyConsumption() &&
                this.arms.get(1).getEnergyConsumption() > arm.getEnergyConsumption()) {
            this.arms.set(0, arm);
        } else if (this.arms.get(0).getEnergyConsumption() > arm.getEnergyConsumption()) {
            this.arms.set(0, arm);
        } else if (this.arms.get(1).getEnergyConsumption() > arm.getEnergyConsumption()) {
            this.arms.set(1, this.arms.get(0));
            this.arms.set(0, arm);
        }
    }

    public void setLeg(Leg leg) {
        if (this.legs.size() == 0) {
            this.legs.add(leg);
        } else if (this.legs.size() == 1) {
            this.legs.add(leg);
        } else if (this.legs.get(0).getEnergyConsumption() > leg.getEnergyConsumption() &&
                this.legs.get(1).getEnergyConsumption() > leg.getEnergyConsumption()) {
            this.legs.set(0, leg);
        } else if (this.legs.get(0).getEnergyConsumption() > leg.getEnergyConsumption()) {
            this.legs.set(0, leg);
        } else if (this.legs.get(1).getEnergyConsumption() > leg.getEnergyConsumption()) {
            this.legs.set(1, this.legs.get(0));
            this.legs.set(0, leg);
        }
    }

    private Head getHead() {
        return this.head;
    }

    private Torso getTorso() {
        return this.torso;
    }

    private String getArms() {
        StringBuilder arms = new StringBuilder();
        this.arms.stream()
                .sorted(Comparator.comparingInt(Arm::getEnergyConsumption))
                .forEach(arm -> arms.append(arm).append(System.lineSeparator()));
        return arms.toString();
    }

    private String getLegs() {
        StringBuilder legs = new StringBuilder();
        this.legs.stream()
                .sorted(Comparator.comparingInt(Leg::getEnergyConsumption))
                .forEach(arm -> legs.append(arm).append(System.lineSeparator()));
        return legs.toString();
    }

    private long getTotalEnergyConsumption() {
        return this.getHead().getEnergyConsumption() +
                this.getTorso().getEnergyConsumption() +
                this.arms.stream().mapToLong(Arm::getEnergyConsumption).sum() +
                this.legs.stream().mapToLong(Leg::getEnergyConsumption).sum();
    }

    private long getPower() {
        return this.power;
    }

    private boolean isEnoughPower() {
        return this.getPower() - this.getTotalEnergyConsumption() >= 0;
    }

    private boolean isAssembled() {
        return this.getTorso() != null && this.getHead() != null &&
                this.arms.size() == 2 && this.legs.size() == 2;
    }


    @Override
    public String toString() {
        if (this.isAssembled() && this.isEnoughPower()) {
            StringBuilder output = new StringBuilder();
            output.append("Jarvis:")
                    .append(System.lineSeparator())
                    .append(this.getHead())
                    .append(System.lineSeparator())
                    .append(this.getTorso())
                    .append(System.lineSeparator())
                    .append(this.getArms())
                    .append(this.getLegs());
            return output.toString();
        } else if (isAssembled() && ! this.isEnoughPower()) {
            return "We need more power!";
        } else {
            return "We need more parts!";
        }
    }
}

class Arm {
    private int energyConsumption;
    private int reach;
    private int fingers;

    public Arm(int energyConsumption, int reach, int fingers) {
        this.energyConsumption = energyConsumption;
        this.reach = reach;
        this.fingers = fingers;
    }

    public int getEnergyConsumption() {
        return this.energyConsumption;
    }

    public int getReach() {
        return this.reach;
    }

    public int getFingers() {
        return this.fingers;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("#%s:", this.getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append(String.format("###Energy consumption: %d", this.getEnergyConsumption()))
                .append(System.lineSeparator())
                .append(String.format("###Reach: %d", this.getReach()))
                .append(System.lineSeparator())
                .append(String.format("###Fingers: %d", this.getFingers()));
        return output.toString();
    }
}

class Head {
    private int energyConsumption;
    private int IQ;
    private String skinMaterial;

    public Head(int energyConsumption, int IQ, String skinMaterial) {
        this.energyConsumption = energyConsumption;
        this.IQ = IQ;
        this.skinMaterial = skinMaterial;
    }

    public int getEnergyConsumption() {
        return this.energyConsumption;
    }

    public int getIQ() {
        return this.IQ;
    }

    public String getSkinMaterial() {
        return this.skinMaterial;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("#%s:", this.getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append(String.format("###Energy consumption: %d", this.getEnergyConsumption()))
                .append(System.lineSeparator())
                .append(String.format("###IQ: %d", this.getIQ()))
                .append(System.lineSeparator())
                .append(String.format("###Skin material: %s", this.getSkinMaterial()));
        return output.toString();
    }
}

class Leg {
    private int energyConsumption;
    private int strength;
    private int speed;

    public Leg(int energyConsumption, int strength, int speed) {
        this.energyConsumption = energyConsumption;
        this.strength = strength;
        this.speed = speed;
    }

    public int getEnergyConsumption() {
        return this.energyConsumption;
    }

    public int getStrength() {
        return this.strength;
    }

    public int getSpeed() {
        return this.speed;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("#%s:", this.getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append(String.format("###Energy consumption: %d", this.getEnergyConsumption()))
                .append(System.lineSeparator())
                .append(String.format("###Strength: %d", this.getStrength()))
                .append(System.lineSeparator())
                .append(String.format("###Speed: %d", this.getSpeed()));
        return output.toString();
    }
}

class Torso {
    private int energyConsumption;
    private double CPUSize;
    private String housingMaterial;

    public Torso(int energyConsumption, double CPUSize, String housingMaterial) {
        this.energyConsumption = energyConsumption;
        this.CPUSize = CPUSize;
        this.housingMaterial = housingMaterial;
    }

    public int getEnergyConsumption() {
        return this.energyConsumption;
    }

    public double getCPUSize() {
        return this.CPUSize;
    }

    public String getHousingMaterial() {
        return this.housingMaterial;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("#%s:", this.getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append(String.format("###Energy consumption: %d", this.getEnergyConsumption()))
                .append(System.lineSeparator())
                .append(String.format("###Processor size: %.1f", this.getCPUSize()))
                .append(System.lineSeparator())
                .append(String.format("###Corpus material: %s", this.getHousingMaterial()));
        return output.toString();
    }
}