package L09MethodsAndDebugging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex03PrintTriangle {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringBuilder output = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            String line = getLine(i);
            output.append(line).append(System.lineSeparator());
        }

        for (int i = n - 1; i >= 0; i--) {
            String line = getLine(i);
            output.append(line).append(System.lineSeparator());

        }

        System.out.println(output.toString());
    }

    private static String getLine(int i) {
        StringBuilder line = new StringBuilder();
        for (int j = 1; j <= i; j++) {
            line.append(j).append(" ");
        }
        return line.toString().trim();
    }
}
