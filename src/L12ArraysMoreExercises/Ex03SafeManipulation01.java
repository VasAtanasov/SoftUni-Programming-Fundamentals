package L12ArraysMoreExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex03SafeManipulation01 {
    private static String[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        array = reader.readLine().split("\\s+");

        String input;
        while (! "END".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");
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
                    if (inRange(index)) {
                        String element = tokens[2];
                        array[index] = element;
                    } else {
                        System.out.println("Invalid input!");
                    }
                    break;
                default:
                    System.out.println("Invalid input!");
            }
        }


        System.out.println(String.join(", ", array));
    }

    private static boolean inRange(int index) {
        return index >= 0 && index < array.length;
    }

    private static void distinctArray() {
        String[] distinctArray = new String[1];
        int index = 0;

        for (int i = 0; i < array.length; i++) {
            if (! containsElement(distinctArray, array[i])) {
                if (i >= distinctArray.length) {
                    distinctArray = resizeArray(distinctArray);
                }
                distinctArray[index++] = array[i];
            }
        }
        array = distinctArray;

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
        for (int i = 0; i < array.length / 2; i++) {
            String temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }
}
