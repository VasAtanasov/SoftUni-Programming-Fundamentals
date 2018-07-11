package L16DictionariesExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Ex04FixEmails {
    private static Map<String, String> mails;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        mails = new LinkedHashMap<>();

        String name;
        while (! "stop".equals(name = reader.readLine())) {
            String email = reader.readLine();
            mails.put(name, email);
        }

        mails.entrySet().stream()
                .filter(e -> ! e.getValue().toLowerCase().endsWith("us") && ! e.getValue().toLowerCase().endsWith("uk"))
                .forEach(m -> System.out.println(String.format("%s -> %s", m.getKey(), m.getValue())));

    }
}
