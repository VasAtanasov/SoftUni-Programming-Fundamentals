package L10MethodsAndDebuggingExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex15Substrings {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        int jump = Integer.parseInt(reader.readLine());

        final char search = 'p';
        boolean hasMatch = false;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == search) {
                hasMatch = true;
                int endIndex = i+ 1 + jump;
                String matchedString = text.substring(i, Math.min(endIndex, text.length()));
                System.out.println(matchedString);
                i += jump;
            }
        }

        if (! hasMatch) {
            System.out.println("no");
        }
    }
}
