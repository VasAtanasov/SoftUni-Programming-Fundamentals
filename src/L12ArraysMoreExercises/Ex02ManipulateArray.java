package L12ArraysMoreExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex02ManipulateArray {
    static class ArrayManipulator {
        private List<String> array;

        public ArrayManipulator(List<String> array) {
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

        public void printFinalArray() {
            System.out.println(array.stream().collect(Collectors.joining(", ")));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayManipulator arrayManipulator = new ArrayManipulator(Arrays.stream(reader.readLine().split("\\s+"))
                .collect(Collectors.toList()));

        manipulateArray(reader, arrayManipulator);

        arrayManipulator.printFinalArray();
    }

    private static void manipulateArray(BufferedReader reader, ArrayManipulator arrayManipulator) throws IOException {
        int n = Integer.valueOf(reader.readLine());
        for (int i = 0; i < n; i++) {
            String command = reader.readLine();

            if (command.startsWith("Reverse")) {
                arrayManipulator.reverse();
            } else if (command.startsWith("Distinct")) {
                arrayManipulator.distinct();
            } else if (command.startsWith("Replace")) {
                String[] tokens = command.split("\\s+");
                int index = Integer.valueOf(tokens[1]);
                String element = tokens[2];
                arrayManipulator.replace(index, element);
            }

        }
    }
}
