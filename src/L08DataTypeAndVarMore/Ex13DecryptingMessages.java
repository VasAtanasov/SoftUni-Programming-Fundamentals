package L08DataTypeAndVarMore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex13DecryptingMessages {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int key = Integer.parseInt(reader.readLine());
        int lines = Integer.parseInt(reader.readLine());
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < lines; i++) {
            char input = reader.readLine().charAt(0);
            output.append((char) (key + input));
        }
        System.out.println(output.toString());
    }
}
