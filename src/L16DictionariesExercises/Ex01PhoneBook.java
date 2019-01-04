package L16DictionariesExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Ex01PhoneBook {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, String> phoneBook = new LinkedHashMap<>();

        String input;
        while (! "END".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String name = tokens[1];
            String number;

            switch (command) {
                case "A":
                    number = tokens[2];
                    phoneBook.put(name, number);
                    break;
                case "S":
                    String output = phoneBook.containsKey(name) ?
                            String.format("%s -> %s",name,phoneBook.get(name)) :
                            String.format("Contact %s does not exist.",name);
                    System.out.println(output);
                    break;

            }

        }
    }
}
