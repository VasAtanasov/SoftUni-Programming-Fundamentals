package L05ConditionalAndLoops;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex07DivisibleBy3 {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 3; i <= 100; i +=3) {
            System.out.println(i);
        }
    }
}
