package L17ObjectsAndClasses;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Ex02RandomizeWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Random random = new Random();
        String[] input = reader.readLine().split("\\s+");

        for (int i = 0; i < input.length; i++) {
            int index = random.nextInt(input.length);

            String temp = input[i];
            input[i] = input[index];
            input[index] = temp;

        }
        Arrays.stream(input).forEach(System.out::println);


    }
}
