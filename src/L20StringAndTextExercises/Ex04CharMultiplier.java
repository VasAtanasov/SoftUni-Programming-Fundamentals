package L20StringAndTextExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex04CharMultiplier {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        int totalSum = 0;

        for (int i = 0; i < Math.max(input[0].length(), input[1].length()); i++) {
            int ch1 = i < input[0].length() ? input[0].charAt(i) : 1;
            int ch2 = i < input[1].length() ? input[1].charAt(i) : 1;
            totalSum += (ch1 * ch2);
        }
        System.out.println(totalSum);
    }
}
