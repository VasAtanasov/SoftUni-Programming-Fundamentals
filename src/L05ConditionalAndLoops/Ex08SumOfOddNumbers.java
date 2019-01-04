package L05ConditionalAndLoops;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex08SumOfOddNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int times = Integer.parseInt(reader.readLine());
        int sum = 0;
        int i = 1;

        while (times-- > 0) {
            sum += i;
            System.out.println(i);
            i += 2;
        }

        System.out.println(String.format("Sum: %d", sum));
    }
}
