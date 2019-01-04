package L08DataTypeAndVarExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex17PrintASCIITable {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int start = Integer.parseInt(reader.readLine());
        int end = Integer.parseInt(reader.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            sb.append((char) i).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
