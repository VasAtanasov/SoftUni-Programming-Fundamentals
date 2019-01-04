package L05ConditionalAndLoops;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12NumberChecker {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(reader.readLine());
            System.out.println("It is a number.");
        } catch (Exception ex) {
            System.out.println("Invalid input!");
        }
    }
}
