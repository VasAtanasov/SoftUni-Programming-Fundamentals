package L16DictionariesExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Ex06UserLogs {
    private static Map<String, User> users;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        users = new TreeMap<>();

        String input;
        while (! "end".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");
            String ip = tokens[0].substring(tokens[0].indexOf("=") + 1);
            String user = tokens[2].substring(tokens[2].indexOf("=") + 1);

            users.putIfAbsent(user, new User(user));
            users.get(user).addIP(ip);
        }

        users.values().forEach(System.out::println);

    }
}

class User {
    private String name;
    private Map<String, Integer> ips;

    User(String name) {
        this.name = name;
        this.ips = new LinkedHashMap<>();
    }

    void addIP(String ip) {
        this.ips.putIfAbsent(ip, 0);
        this.ips.put(ip, this.ips.get(ip) + 1);
    }

    private String getIPsString() {
        return this.ips.entrySet().stream()
                .map(s -> String.format("%s => %s", s.getKey(), s.getValue()))
                .collect(Collectors.joining(", "));
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("%s:", this.name))
                .append(System.lineSeparator())
                .append(this.getIPsString())
                .append(".");
        return output.toString();
    }
}

