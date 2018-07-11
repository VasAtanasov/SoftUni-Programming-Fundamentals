package L12ArraysMoreExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex02ManipulateArray01 {
    private static String[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        input = reader.readLine().split("\\s+");
        int lines = Integer.parseInt(reader.readLine());

        for (int i = 0; i < lines; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Reverse":
                    reverseArray();
                    break;
                case "Distinct":
                    distinctArray();
                    break;
                case "Replace":
                    int index = Integer.parseInt(tokens[1]);
                    String element = tokens[2];
                    input[index] = element;
                    break;
            }
        }


        System.out.println(String.join(", ", input));
    }

    private static void distinctArray() {
        String[] distinctArray = new String[1];
        int index = 0;

        for (int i = 0; i < input.length; i++) {
            if (! containsElement(distinctArray, input[i])) {
                if (i >= distinctArray.length) {
                    distinctArray = resizeArray(distinctArray);
                }
                distinctArray[index++] = input[i];
            }
        }
        input = distinctArray;

    }

    private static String[] resizeArray(String[] distinctArray) {
        String[] resize = new String[distinctArray.length + 1];
        for (int i = 0; i < distinctArray.length; i++) {
            resize[i] = distinctArray[i];

        }
        return resize;
    }

    private static boolean containsElement(String[] distinctArray, String element) {
        for (String string : distinctArray) {
            if (string != null && string.equals(element)) {
                return true;
            }
        }
        return false;
    }

    private static void reverseArray() {
        for (int i = 0; i < input.length / 2; i++) {
            String temp = input[i];
            input[i] = input[input.length - 1 - i];
            input[input.length - 1 - i] = temp;
        }
    }
}
