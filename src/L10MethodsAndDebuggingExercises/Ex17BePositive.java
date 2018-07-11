package L10MethodsAndDebuggingExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex17BePositive {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int countSequences = Integer.parseInt(reader.readLine().trim());

        for (int i = 0; i < countSequences; i++) {
            List<Double> numbers = Arrays.stream(reader.readLine().trim().split("\\s+"))
                    .map(Double::parseDouble)
                    .collect(Collectors.toCollection(ArrayList::new));
            List<Double> foundNumbers = new ArrayList<>();

            try {
                for (int j = 0; j < numbers.size(); j++) {
                    double currentNum = numbers.get(j);
                    if (currentNum >= 0) {
                        foundNumbers.add(numbers.get(j));
                    } else if (i <= numbers.size() - 1) {
                        currentNum += numbers.get(j + 1);
                        if (currentNum >= 0) {
                            foundNumbers.add(currentNum);
                        }
                        j++;
                    }
                }
            } catch (Exception ex) {}

            DecimalFormat df = new DecimalFormat("0.###########");

            if (foundNumbers.isEmpty()) {
                System.out.println("(empty)");
            } else {
                System.out.println(foundNumbers.stream().map(df::format).collect(Collectors.joining(" ")));
            }
        }
    }
}
