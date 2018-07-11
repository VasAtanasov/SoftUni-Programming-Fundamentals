package Z_ExamsExtendet.exam04Sep2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex03PhoenixGrid {
    private static BufferedReader reader;
    private static final String REGEX;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        REGEX = "^[^_\\s]{3}(\\.[^_\\s]{3}\\.*)*$";
    }

    public static void main(String[] args) throws IOException {
        String input;
        while (! "ReadMe".equals(input = reader.readLine())) {
            if (input.matches(REGEX) && isPalindrome(input)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean isPalindrome(String input) {
        String reversed = new StringBuilder(input).reverse().toString();
        return reversed.equals(input);
    }
}
