package L12ArraysMoreExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex05PizzaIngredients {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputArrayReader arrayReader = new InputArrayReader();
        ArrayManipulator arrayManipulator = new ArrayManipulator();

        arrayReader.readStringList(reader.readLine(), "\\s+");
        int stringLength = Integer.valueOf(reader.readLine());

        List<String> ingredients = arrayReader.getStringList().stream()
                .filter(e -> e.length() == stringLength).limit(10)
                .collect(Collectors.toCollection(ArrayList::new));

        printResult(arrayManipulator, ingredients);
    }

    private static void printResult(ArrayManipulator arrayManipulator, List<String> ingredients) {
        ingredients.forEach(e -> {
            System.out.println(String.format("Adding %s.", e));
        });
        System.out.println(String.format("Made pizza with total of %d ingredients.", ingredients.size()));
        System.out.println(String.format("The ingredients are: %s.", arrayManipulator.joinStringList(ingredients, ", ")));
    }

    public static class ArrayManipulator {

        public String joinStringList(List<String> stringList, String delimiter) {
            return stringList.stream().collect(Collectors.joining(delimiter));
        }

    }

    public static class InputArrayReader {
        private List<String> stringList;
        private List<Integer> intNumbers;
        private List<Long> longNumbers;
        private List<Double> doubleNumbers;

        /* read and split list of Strings */
        public void readStringList(String input, String splitRegex) {
            this.stringList = Arrays.stream(input.split(splitRegex))
                    .collect(Collectors.toCollection(ArrayList::new));
        }

        public List<String> getStringList() {
            return stringList;
        }

        /* read and split list of Integers */
        public void readIntList(String input, String splitRegex) throws IOException {
            this.intNumbers = Arrays.stream(input.split(splitRegex)).map(Integer::valueOf)
                    .collect(Collectors.toCollection(ArrayList::new));
        }

        public List<Integer> getIntNumbers() {
            return intNumbers;
        }

        /* read and split list of Longs */
        public void readLongList(String input, String splitRegex) throws IOException {
            this.longNumbers = Arrays.stream(input.split(splitRegex)).map(Long::valueOf)
                    .collect(Collectors.toCollection(ArrayList::new));
        }

        public List<Long> getlongNumbers() {
            return longNumbers;
        }

        /* read and split list of Doubles */
        public void readDoubleList(String input, String splitRegex) throws IOException {
            this.doubleNumbers = Arrays.stream(input.split(splitRegex)).map(Double::valueOf)
                    .collect(Collectors.toCollection(ArrayList::new));
        }

        public List<Double> getDoubleNumbers() {
            return doubleNumbers;
        }  /* read and split list of Long */

    }
}
