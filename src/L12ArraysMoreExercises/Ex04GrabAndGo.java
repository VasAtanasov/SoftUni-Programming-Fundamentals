package L12ArraysMoreExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex04GrabAndGo {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputArrayReader inputArrayReader = new InputArrayReader();

        inputArrayReader.readLongList(reader.readLine(), " ");
        long n = Long.valueOf(reader.readLine());

        int lastIndex = inputArrayReader.getLongNumbers().lastIndexOf(n);

        if (lastIndex != - 1) {
            System.out.println(inputArrayReader.getLongNumbers().stream()
                    .limit(lastIndex).mapToLong(Long::valueOf).sum());
        } else {
            System.out.println("No occurrences were found!");
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

        public List<String> stringList() {
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

        public List<Long> getLongNumbers() {
            return longNumbers;
        }

        /* read and split list of Doubles */
        public void readDoubleList(String input, String splitRegex) throws IOException {
            this.doubleNumbers = Arrays.stream(input.split(splitRegex)).map(Double::valueOf)
                    .collect(Collectors.toCollection(ArrayList::new));
        }

        public List<Double> getdoubleNumbers() {
            return doubleNumbers;
        }  /* read and split list of Long */

    }
}
