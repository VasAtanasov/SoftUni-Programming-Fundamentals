package L05ConditionalAndLoops;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex10MultiplicationTable2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int min = Integer.parseInt(reader.readLine());

        if (min > 10) {
            System.out.println(String.format("%d X %d = %d", n, min, min * n));
            return;
        }

        for (int i = min; i <= 10; i++) {
            System.out.println(String.format("%d X %d = %d", n, i, i * n));
        }
    }
}
