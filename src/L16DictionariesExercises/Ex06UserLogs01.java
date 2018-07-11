package L16DictionariesExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class Ex06UserLogs01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, LinkedHashMap<String, Integer>> data = new LinkedHashMap<>();

        String input = reader.readLine();
        while (! "end".equals(input)) {
            String[] tokens = input.split("\\s+");

            String ip = tokens[0].substring(tokens[0].indexOf("=") + 1);
            String user = tokens[2].substring(tokens[2].indexOf("=") + 1);

            data.putIfAbsent(user, new LinkedHashMap<>());
            data.get(user).putIfAbsent(ip, 0);

            int count = data.get(user).get(ip) + 1;
            data.get(user).put(ip, count);

            input = reader.readLine();
        }

        data.entrySet()
                .stream()
                .sorted((a, b) -> a.getKey().compareToIgnoreCase(b.getKey()))
                .forEach(e -> {
                    StringBuilder output = new StringBuilder();
                    output.append(String.format("%s:", e.getKey()))
                            .append(System.lineSeparator())
                            .append(e.getValue().entrySet().stream()
                                    .map(s -> String.format("%s => %s", s.getKey(), s.getValue()))
                                    .collect(Collectors.joining(", ")))
                            .append(".");
                    System.out.println(output.toString());
                });


    }
}