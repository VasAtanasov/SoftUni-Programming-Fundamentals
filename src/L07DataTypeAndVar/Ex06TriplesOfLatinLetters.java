package L07DataTypeAndVar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex06TriplesOfLatinLetters {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        for (char i = 'a'; i < n + 'a'; i++) {
            for (char j = 'a'; j < n + 'a'; j++) {
                for (int k = 'a'; k < n + 'a'; k++) {
                    System.out.println(String.format("%c%c%c", i, j, k));
                }
            }
        }
    }
}
