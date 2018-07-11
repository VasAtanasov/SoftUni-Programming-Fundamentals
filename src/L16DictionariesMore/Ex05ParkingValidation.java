package L16DictionariesMore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Ex05ParkingValidation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ParkingLog parking = new ParkingLog();
        int lines = Integer.parseInt(reader.readLine());
        for (int i = 0; i < lines; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            String command = tokens[0];
            String name = tokens[1];
            String plate;
            try {
                switch (command) {
                    case "register":
                        plate = tokens[2];
                        System.out.println(parking.register(name, plate));
                        break;
                    case "unregister":
                        System.out.println(parking.unregister(name));
                        break;
                }
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }

        printParkingLotUsers(parking);

    }

    private static void printParkingLotUsers(ParkingLog parking) {
        if (! parking.getUsers().isEmpty()) {
            System.out.println(parking);
        }
    }
}


class ParkingLog {
    private Map<String, String> users;

    ParkingLog() {
        this.users = new LinkedHashMap<>();
    }

    Map<String, String> getUsers() {
        return this.users;
    }

    String register(String username, String plate) {
        if (this.users.containsKey(username)) {
            throw new IllegalArgumentException(String.format("ERROR: already registered with plate number %s", this.users.get(username)));
        }
        if (! Pattern.matches("[A-Z]{2}[0-9]{4}[A-Z]{2}", plate)) {
            throw new IllegalArgumentException(String.format("ERROR: invalid license plate %s", plate));
        }
        if (this.users.containsValue(plate)) {
            throw new IllegalArgumentException(String.format("ERROR: license plate %s is busy", plate));
        }
        this.users.put(username, plate);
        return String.format("%s registered %s successfully", username, plate);
    }

    String unregister(String username) {
        if (! this.users.containsKey(username)) {
            throw new IllegalArgumentException(String.format("ERROR: user %s not found", username));
        }
        this.users.remove(username);
        return String.format("user %s unregistered successfully", username);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        this.users.forEach((u, p) -> output.append(String.format("%s => %s%n", u, p)));
        return output.toString();
    }
}