package Z_Exams.exam05Nov2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex02AnonymousThreat {
    private static BufferedReader reader;
    private static List<String> strings;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        strings = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        strings = Arrays.stream(reader.readLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayList::new));

        String input;
        while (! "3:1".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            int valueOne = Integer.parseInt(tokens[1]);
            int valueTwo = Integer.parseInt(tokens[2]);

            switch (command) {
                case "merge":
                    merge(valueOne, valueTwo);
                    break;
                case "divide":
                    divide(valueOne, valueTwo);
                    break;
            }
        }

        System.out.println(strings.stream().collect(Collectors.joining(" ")));
    }

    private static void divide(int index, int partitions) {
        String string = strings.get(index);

        if (partitions > 1) {
            int length = string.length() / partitions;
            List<String> list = new ArrayList<>();

            for (int i = 0; i < index; i++) {
                list.add(strings.get(i));
            }

            for (int i = 0; i < partitions - 1; i++) {
                String partition = string.substring(0, length);
                list.add(partition);
                string = string.substring(length);
            }
            list.add(string);

            for (int i = index + 1; i < strings.size(); i++) {
                list.add(strings.get(i));
            }

            strings.clear();
            strings.addAll(list);
        }
    }

    private static void merge(int startIndex, int endIndex) {
        startIndex = Math.min(Math.max(0, startIndex), strings.size() - 1);
        endIndex = Math.max(Math.min(strings.size() - 1, endIndex), 0);
        String merged = getMergedString(startIndex, endIndex);

        List<String> list = new ArrayList<>();

        for (int i = 0; i < startIndex; i++) {
            list.add(strings.get(i));
        }

        list.add(merged);

        for (int i = endIndex + 1; i < strings.size(); i++) {
            list.add(strings.get(i));
        }

        strings.clear();
        strings.addAll(list);
    }

    private static String getMergedString(int startIndex, int endIndex) {
        StringBuilder merge = new StringBuilder();
        for (int i = startIndex; i <= endIndex; i++) {
            merge.append(strings.get(i));
        }
        return merge.toString();
    }
}
