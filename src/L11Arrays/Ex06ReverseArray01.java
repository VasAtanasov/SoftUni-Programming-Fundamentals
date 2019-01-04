package L11Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex06ReverseArray01 {
    private static String[] strings;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        strings = reader.readLine().split("\\s+");

        for (int i = 0; i < strings.length / 2; i++) {
            String temp = strings[i];
            strings[i] = strings[strings.length - 1- i];
            strings[strings.length - 1 - i] = temp;
        }

        printArray();

    }

    private static void printArray() {
        StringBuilder output = new StringBuilder();
        for (String string : strings) {
            output.append(string).append(" ");
        }
        System.out.println(output.toString().trim());
    }
}
