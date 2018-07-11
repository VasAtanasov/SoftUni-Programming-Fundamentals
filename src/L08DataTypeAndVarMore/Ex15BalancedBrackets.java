package L08DataTypeAndVarMore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex15BalancedBrackets {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(reader.readLine());
        StringBuilder expression = new StringBuilder();
        for (int i = 0; i < lines; i++) {
            expression.append(reader.readLine());
        }

        char open = '(';
        char close = ')';

        boolean searchOpen = true;
        boolean searchClose = false;

        boolean balanced = false;

        for (int i = 0; i < expression.length(); i++) {
            char bracket = expression.charAt(i);

            if (bracket != '(' && bracket != ')') {
                continue;
            }

            if (searchOpen && bracket == open) {
                searchOpen = false;
                searchClose = true;
                balanced = true;
                continue;
            }

            if (searchClose && bracket == close) {
                searchOpen = true;
                searchClose = false;
                balanced = true;
                continue;
            }

            if (searchOpen && bracket == close) {
                balanced = false;
                break;
            }

            if (searchClose && bracket == open) {
                balanced = false;
                break;
            }
        }

        if (balanced && searchOpen) {
            System.out.println("BALANCED");
        } else {
            System.out.println("UNBALANCED");
        }
    }
}
