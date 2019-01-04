package L12ArraysMoreExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex03SafeManipulation {
    static class SafeManipulator {
        private List<String> array;

        public SafeManipulator(List<String> array) {
            this.array = new ArrayList<>();
            this.array.addAll(array);
        }

        public void reverse() {
            for (int i = 0; i < array.size() / 2; i++) {
                String temp = array.get(i);
                array.set(i, array.get(array.size() - 1 - i));
                array.set(array.size() - 1 - i, temp);
            }
        }

        public void distinct() {
            this.array = this.array.stream().distinct()
                    .collect(Collectors.toCollection(ArrayList::new));
        }

        public void replace(int index, String element) {
            this.array.set(index, element);
        }

        public boolean isValidIndex(int index) {
            return index >= 0 && index < array.size();
        }

        public int getSize() {
            return array.size();
        }

        public void printFinalArray() {
            System.out.println(array.stream().collect(Collectors.joining(", ")));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        SafeManipulator safeManipulator = new SafeManipulator(Arrays.stream(reader.readLine().split("\\s+"))
                .collect(Collectors.toList()));

        manipulateArray(reader, safeManipulator);

        safeManipulator.printFinalArray();

    }

    private static void manipulateArray(BufferedReader reader, SafeManipulator safeManipulator) throws IOException {
        while (true) {
            String command = reader.readLine();
            if ("END".equals(command)) {
                break;
            }

            if (command.startsWith("Reverse")) {
                safeManipulator.reverse();

            } else if (command.startsWith("Distinct")) {
                safeManipulator.distinct();


            } else if (command.startsWith("Replace")) {
                replaceElement(safeManipulator, command);

            } else {
                System.out.println("Invalid input!");

            }

        }
    }

    private static void replaceElement(SafeManipulator safeManipulator, String command) {
        String[] tokens = command.split("\\s+");
        int index = Integer.valueOf(tokens[1]);
        String element = tokens[2];

        if (safeManipulator.isValidIndex(index)) {
            safeManipulator.replace(index, element);

        } else {
            System.out.println("Invalid input!");
        }
    }
}
