package L19StringAndText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex02CountSubstrings {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine().toLowerCase();
        String regex = reader.readLine().toLowerCase();

        int count = 0;
        while (input.contains(regex)) {
            if (input.startsWith(regex)) {
                count++;
            }
            input = input.substring(1);
        }


        System.out.println(count);

    }
}
