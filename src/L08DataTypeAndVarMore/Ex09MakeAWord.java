package L08DataTypeAndVarMore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex09MakeAWord {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(reader.readLine());
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < lines; i++) {
            String input = reader.readLine();
            output.append(input);
        }
        System.out.println(String.format("The word is: %s",output.toString()));
    }
}
