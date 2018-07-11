package L15Dictionaries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Ex05ShortWordsSorted {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(Arrays.stream(reader.readLine().toLowerCase().split("[.,:;()\\[\\]\"'!\\/?\\s\\\\]+"))
                .filter(w -> w.length() < 5)
                .sorted(String::compareTo)
                .distinct()
                .collect(Collectors.joining(", ")));
    }
}
