package L16DictionariesExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Ex02PhoneBookUpgrade {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> phoneBook = new TreeMap<>();

        String input;
        while (! "END".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String name;
            String number;

            switch (command) {
                case "A":
                    name = tokens[1];
                    number = tokens[2];
                    phoneBook.put(name, number);
                    break;
                case "S":
                    name = tokens[1];
                    String output = phoneBook.containsKey(name) ?
                            String.format("%s -> %s", name, phoneBook.get(name)) :
                            String.format("Contact %s does not exist.", name);
                    System.out.println(output);
                    break;
                case "ListAll":
                    phoneBook.forEach((key, value) -> System.out.println(String.format("%s -> %s", key, value)));
                    break;

            }

        }
    }
}
