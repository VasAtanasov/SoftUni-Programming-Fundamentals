package L08DataTypeAndVarMore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex11StringConcatenation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String delimiter = reader.readLine();
        String type = reader.readLine();
        int lines = Integer.parseInt(reader.readLine());

        StringBuilder output = new StringBuilder();
        for (int i = 1; i <= lines; i++) {
            String input = reader.readLine();
            if (type.equals("even") && i % 2 == 0) {
                output.append(input);
                if (i < lines - 1) {
                    output.append(delimiter);
                }
                continue;
            }

            if (type.equals("odd") && i % 2 != 0) {
                output.append(input);
                if (i < lines - 1) {
                    output.append(delimiter);
                }
            }
        }

        System.out.println(output.toString());
    }
}
