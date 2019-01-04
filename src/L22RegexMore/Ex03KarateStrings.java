package L22RegexMore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex03KarateStrings {
    private static BufferedReader reader;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        String[] input = reader.readLine().split(">");
        int carry = 0;
        for (int i = 0; i < input.length; i++) {
            if (Character.isDigit(input[i].charAt(0))) {
                String string = input[i];
                int strength = Integer.parseInt(input[i].substring(0, 1)) + carry;
                if (strength > string.length()) {
                    carry = strength - string.length();
                    strength = string.length();
                }

                input[i] = String.format(">%s", string.substring(strength));
            }
        }

        System.out.println(String.join("", input));
    }

}
