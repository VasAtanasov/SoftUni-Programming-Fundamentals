package L06ConditionalAndLoopsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex06IntervalOfNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int start = Math.min(a,b);
        int end = Math.max(a,b);
        for (int i = start; i <= end; i++) {
            System.out.println(i);
        }
    }
}
