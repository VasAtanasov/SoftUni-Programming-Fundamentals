package L07DataTypeAndVar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Ex05SpecialNumbers01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> specialNumbers = Arrays.asList(5, 7, 11);
        int n = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= n; i++) {
            int sum = String.valueOf(i)
                    .chars()
                    .map(c -> c - 48)
                    .sum();

            if (specialNumbers.contains(sum)) {
                System.out.println(String.format("%d - > True",i));
            } else {
                System.out.println(String.format("%d - > False",i));
            }
        }
    }
}
