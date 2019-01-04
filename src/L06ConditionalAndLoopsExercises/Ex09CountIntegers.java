package L06ConditionalAndLoopsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex09CountIntegers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;

        try {
            while (true) {
                int num = Integer.parseInt(reader.readLine());
                count++;
            }

        } catch (Exception ex) {
            System.out.println(count);

        }
    }
}
