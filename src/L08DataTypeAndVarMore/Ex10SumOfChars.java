package L08DataTypeAndVarMore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex10SumOfChars {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(reader.readLine());

        int sum = 0;
        for (int i = 0; i < lines; i++) {
            char input = reader.readLine().charAt(0);
            sum += input;
        }
        System.out.println(String.format("The sum equals: %d", sum));
    }
}
