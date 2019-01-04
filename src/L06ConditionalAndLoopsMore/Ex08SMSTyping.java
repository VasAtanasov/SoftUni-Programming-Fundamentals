package L06ConditionalAndLoopsMore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex08SMSTyping {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < count; i++) {
            String input = reader.readLine();
            int mainDigit = input.charAt(0) - 48;
            if (mainDigit == 0) {
                for (int j = 0; j < input.length(); j++) {
                    output.append(" ");
                }
            } else {
                int length = input.length() - 1;
                int offset = (mainDigit - 2) * 3;
                offset = mainDigit == 8 || mainDigit == 9 ? offset + 1 : offset;
                int index = offset + length;
                int c = 'a' + index;
                output.append(String.format("%c", c));
            }
        }

        System.out.println(output.toString());
    }
}
