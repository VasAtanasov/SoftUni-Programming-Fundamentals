package L18ObjectsAndClassesMore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Ex02VehicleCatalogue {
    private static Catalogue catalogue;
    private static BufferedReader reader;

    static {
        catalogue = new Catalogue();
        reader = new BufferedReader(new InputStreamReader(System.in));
    }


    public static void main(String[] args) throws IOException {
        registerVehicles();
        printModelInfo();
        System.out.println(catalogue);


    }

    private static void printModelInfo() throws IOException {
        String model;
        while (! "Close the Catalogue".equals(model = reader.readLine())) {
            System.out.println(catalogue.getInfo(model));
        }
    }

    private static void registerVehicles() throws IOException {
        String input;
        while (! "End".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");
            String type = tokens[0].toLowerCase();
            String model = tokens[1];
            String colour = tokens[2];
            int horsepower = Integer.parseInt(tokens[3]);

            Drivable vehicle = null;
            switch (type) {
                case "truck":
                    vehicle = new Truck(type, model, colour, horsepower);
                    break;
                case "car":
                    vehicle = new Car(type, model, colour, horsepower);

                    break;
            }
            catalogue.registerVehicle(vehicle);
        }
    }

}

class Catalogue {
    private Map<String, Drivable> vehicles;

    Catalogue() {
        this.vehicles = new LinkedHashMap<>();
    }

    void registerVehicle(Drivable drivable) {
        this.vehicles.put(drivable.getModel(), drivable);
    }

    String getInfo(String model) {
        if (vehicles.containsKey(model)) {
            return this.vehicles.get(model).toString();
        }
        return "";
    }

    private long carsCount() {
        return this.vehicles.values()
                .stream()
                .filter(v -> v.getType().equals("car"))
                .count();
    }

    private long trucksCount() {
        return this.vehicles.values()
                .stream()
                .filter(v -> v.getType().equals("truck"))
                .count();
    }

    private double getCarsAverageHorsepower() {
        if (this.carsCount() == 0) {
            return 0;
        }
        return vehicles.values()
                .stream()
                .filter(v -> v.getType().equals("car"))
                .mapToDouble(Drivable::getHorsepower)
                .sum() / this.carsCount();
    }

    private double getTrucksAverageHorsepower() {
        if (this.trucksCount() == 0) {
            return 0;
        }
        return vehicles.values()
                .stream()
                .filter(v -> v.getType().equals("truck"))
                .mapToDouble(Drivable::getHorsepower)
                .sum() / this.trucksCount();
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("Cars have average horsepower of: %.2f.", this.getCarsAverageHorsepower()))
                .append(System.lineSeparator())
                .append(String.format("Trucks have average horsepower of: %.2f.", this.getTrucksAverageHorsepower()));
        return output.toString();
    }
}

interface Drivable {


    String getType();

    String getModel();

    String getColour();

    int getHorsepower();
}

abstract class Vehicle implements Drivable {
    private String type;
    private String model;
    private String colour;
    private int horsepower;

    Vehicle(String type, String model, String colour, int horsepower) {
        this.type = type;
        this.model = model;
        this.colour = colour;
        this.horsepower = horsepower;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColour() {
        return this.colour;
    }

    @Override
    public int getHorsepower() {
        return this.horsepower;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("Type: %s", this.getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append(String.format("Model: %s", this.getModel()))
                .append(System.lineSeparator())
                .append(String.format("Color: %s", this.getColour()))
                .append(System.lineSeparator())
                .append(String.format("Horsepower: %d", this.getHorsepower()));
        return output.toString();
    }
}

class Car extends Vehicle {

    Car(String type, String model, String colour, int horsepower) {
        super(type, model, colour, horsepower);
    }
}

class Truck extends Vehicle {

    Truck(String type, String model, String colour, int horsepower) {
        super(type, model, colour, horsepower);
    }
}
