package L22RegexMore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex06EmailStatistics {
    private static final String REGEX;
    private static Pattern pattern;
    private static Map<String, Set<String>> domains;
    private static BufferedReader reader;

    static {
        REGEX = "^(?<username>[A-Za-z]{5,})@(?<domain>[a-z]{3,}\\.(com|bg|org))$";
        pattern = Pattern.compile(REGEX);
        domains = new LinkedHashMap<>();
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(reader.readLine());

        for (int i = 0; i < count; i++) {
            String input = reader.readLine();
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String username = matcher.group("username");
                String domain = matcher.group("domain");
                domains.putIfAbsent(domain, new LinkedHashSet<>());
                domains.get(domain).add(username);
            }
        }

        domains.entrySet().stream()
                .sorted((a, b) -> Integer.compare(b.getValue().size(), a.getValue().size()))
                .forEach(domain -> {
                    System.out.println(domain.getKey() + ":");
                    domain.getValue()
                            .forEach(user -> System.out.println(String.format("### %s",user)));
                });

    }
}
