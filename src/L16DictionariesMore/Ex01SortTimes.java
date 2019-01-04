package L16DictionariesMore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Ex01SortTimes { // in judge gives 90/100 due to time limit of last test
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(Arrays.stream(reader.readLine().split("\\s+"))
                .map(t -> {
                    String[] tokens = t.split(":");
                    int hours = Integer.parseInt(tokens[0]);
                    int minutes = Integer.parseInt(tokens[1]);
                    return LocalTime.of(hours, minutes);
                })
                .sorted(LocalTime::compareTo)
                .map(t -> t.format(DateTimeFormatter.ofPattern("HH:mm")))
                .collect(Collectors.joining(", ")));
    }
}
