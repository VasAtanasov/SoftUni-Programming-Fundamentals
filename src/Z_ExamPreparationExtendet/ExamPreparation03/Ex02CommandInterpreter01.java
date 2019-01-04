package Z_ExamPreparationExtendet.ExamPreparation03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex02CommandInterpreter01 {
    private static BufferedReader reader;
    private static List<String> array;
    private static String[] tokens;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        array = Arrays.stream(reader.readLine().split("\\s+"))
                .filter(e -> ! e.equals(""))
                .collect(Collectors.toCollection(ArrayList::new));

        String input;
        while (! "end".equals(input = reader.readLine())) {
            tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "reverse":
                    reverseArray();
                    break;
                case "sort":
                    sortRange();
                    break;
                case "rollLeft":
                    rollLeft();
                    break;
                case "rollRight":
                    rollRight();
                    break;
            }
        }

        System.out.println(array);
    }

    private static void rollRight() {
        int times = Integer.parseInt(tokens[1]);
        if (! isValidCount(times)) {
            System.out.println("Invalid input parameters.");
            return;
        }
        times %= array.size();
        for (int i = 0; i < times; i++) {
            String lastElement = array.get(array.size() - 1);
            for (int j = array.size() - 1; j > 0; j--) {
                array.set(j, array.get(j - 1));
            }
            array.set(0, lastElement);
        }
    }

    private static void rollLeft() {
        int times = Integer.parseInt(tokens[1]);
        if (! isValidCount(times)) {
            System.out.println("Invalid input parameters.");
            return;
        }
        times %= array.size();
        for (int i = 0; i < times; i++) {
            String firstElement = array.get(0);
            for (int j = 0; j < array.size() - 1; j++) {
                array.set(j, array.get(j + 1));
            }
            array.set(array.size() - 1, firstElement);
        }
    }

    private static void sortRange() {
        Collator collator = Collator.getInstance();
        int startIndex = Integer.parseInt(tokens[2]);
        int count = Integer.parseInt(tokens[4]);
        if (! inRange(startIndex, count)) {
            System.out.println("Invalid input parameters.");
            return;
        }
        int endIndex = Math.min(array.size() - 1, startIndex + count - 1);
        for (int i = startIndex; i < endIndex; i++) {
            for (int j = i + 1; j <= endIndex; j++) {
                if (collator.compare(array.get(i), array.get(j)) > 0) {
                    String temp = array.get(i);
                    array.set(i, array.get(j));
                    array.set(j, temp);
                }
            }
        }
    }

    private static void reverseArray() {
        int startIndex = Integer.parseInt(tokens[2]);
        int count = Integer.parseInt(tokens[4]);
        if (! inRange(startIndex, count)) {
            System.out.println("Invalid input parameters.");
            return;
        }
        int endIndex = Math.min(array.size() - 1, startIndex + count - 1);
        for (int i = 0; i < count / 2; i++) {
            String temp = array.get(startIndex);
            array.set(startIndex, array.get(endIndex));
            array.set(endIndex, temp);
            startIndex++;
            endIndex--;
        }
    }

    private static boolean inRange(int start, int count) {
        boolean isInRange = start >= 0 && start < array.size();
        boolean isInside = count >= 0 && start + count <= array.size();
        return isInRange && isInside;
    }

    private static boolean isValidCount(int count) {
        return count >= 0;
    }
}
