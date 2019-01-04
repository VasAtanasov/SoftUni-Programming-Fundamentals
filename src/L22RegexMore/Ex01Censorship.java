package L22RegexMore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex01Censorship {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String censor = reader.readLine();
        String input = reader.readLine();
        String start = generateFrom("*", censor.length());

        System.out.println(input.replace(censor, start));
    }

    private static String generateFrom(String input, int times) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < times; i++) {
            builder.append(input);
        }
        return builder.toString();
    }
}
