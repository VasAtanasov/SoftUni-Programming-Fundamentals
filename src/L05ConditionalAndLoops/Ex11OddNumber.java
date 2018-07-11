package L05ConditionalAndLoops;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex11OddNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int n = Integer.parseInt(reader.readLine());
            if (n % 2 != 0) {
                System.out.println(String.format("The number is: %d", Math.abs(n)));
                break;
            } else {
                System.out.println("Please write an odd number.");
            }
        }
    }
}
