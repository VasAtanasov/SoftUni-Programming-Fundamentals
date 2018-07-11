package Z_ExamsExtendet.exam20Aug2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Ex02EnterTrain01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int power = Integer.valueOf(reader.readLine());

        List<Integer> train = new ArrayList<>();

        String input = reader.readLine();
        while (! "All ofboard!".equals(input)) {
            int wagon = Integer.valueOf(input);
            train.add(wagon);

            int sum = train.stream()
                    .mapToInt(Integer::valueOf)
                    .sum();

            if (sum > power) {
                int average = sum / train.size();
                int element = train.stream()
                        .sorted(Comparator.comparingInt(a -> Math.abs(a - average)))
                        .findFirst().get();
                train.remove(train.indexOf(element));
            }

            input = reader.readLine();
        }

        Collections.reverse(train);
        train.add(power);
        System.out.println(train.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));

    }
}

