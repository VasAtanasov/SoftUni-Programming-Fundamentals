package L12ArraysMoreExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex06Heist {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputArrayReader arrayReader = new InputArrayReader();

        arrayReader.readLongList(reader.readLine(), "\\s+");
        long jewelsPrice = arrayReader.getLongNumbers().get(0);
        long goldPrice = arrayReader.getLongNumbers().get(1);
        long totalExpenses = 0;
        long totalEarnings = 0;

        while (true) {
            String input = reader.readLine();
            if ("Jail Time".equals(input)) {
                break;
            }

            arrayReader.readStringList(input, "\\s+");

            long jewelsCount = arrayReader.getStringList().get(0).chars()
                    .filter(e -> e == '%').count();
            long goldCount = arrayReader.getStringList().get(0).chars()
                    .filter(e -> e == '$').count();

            totalEarnings += (jewelsPrice * jewelsCount) + (goldPrice * goldCount);
            totalExpenses += Long.valueOf(arrayReader.getStringList().get(1));
        }

        long diff = totalEarnings - totalExpenses;

        if (diff >= 0) {
            System.out.println(String.format("Heists will continue. Total earnings: %d.",diff));
        } else {
            System.out.println(String.format("Have to find another job. Lost: %d.", Math.abs(diff)));
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

        public String joinStringList(String delimiter) {
            return stringList.stream().collect(Collectors.joining(delimiter));
        }

        public String joinStringList(List<String> stringList, String delimiter) {
            return stringList.stream().collect(Collectors.joining(delimiter));
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

        public List<Double> getDoubleNumbers() {
            return doubleNumbers;
        }  /* read and split list of Long */

    }
}
