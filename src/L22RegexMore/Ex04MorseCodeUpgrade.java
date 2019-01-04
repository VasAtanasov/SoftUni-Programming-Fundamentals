package L22RegexMore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex04MorseCodeUpgrade {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\|");

        for (int i = 0; i < input.length; i++) {
            int sum = Arrays.stream(input[i].split(""))
                    .mapToInt(s -> Integer.parseInt(s.equals("0") ? "3" : "5"))
                    .sum();
            int toAdd = getToAdd(input[i]);
            input[i] = String.format("%c", sum + toAdd);
        }

        System.out.println(String.join("",input));
    }

    private static int getToAdd(String string) {
        int sequencesOfOne = Arrays.stream(string.split("[0]+"))
                .mapToInt(String::length)
                .filter(value -> value > 1)
                .sum();
        int sequencesOfZero = Arrays.stream(string.split("[1]+"))
                .mapToInt(String::length)
                .filter(value -> value > 1)
                .sum();
        return sequencesOfOne + sequencesOfZero;
    }
}
