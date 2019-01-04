package L05ConditionalAndLoops;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex09MultiplicationTable {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= 10; i++) {
            System.out.println(String.format("%d X %d = %d", n, i, i * n));
        }
    }
}
