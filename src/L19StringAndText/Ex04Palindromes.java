package L19StringAndText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Ex04Palindromes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(Arrays.stream(reader.readLine().split("[\\s,.?!]"))
                .filter(s -> !s.isEmpty())
                .filter(s -> new StringBuilder(s).reverse().toString().equals(s))
                .distinct()
                .sorted(String::compareToIgnoreCase)
                .collect(Collectors.joining(", ")));
    }
}
