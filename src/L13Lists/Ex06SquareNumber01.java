package L13Lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Ex06SquareNumber01 {
    private static String[] input;
    private static List<Integer> squares;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        input = reader.readLine().split("\\s+");
        squares = new ArrayList<>();

        parseAndFilterNumbers();
        descendingSortNumbers();
        printList();

//        solution with streams 100/100
//
//        System.out.println(Arrays.stream(reader.readLine().split("\\s+"))
//                .map(Integer::parseInt)
//                .filter(e -> Math.sqrt(e) == (int) Math.sqrt(e))
//                .sorted((a,b) -> Double.compare(b,a))
//                .map(String::valueOf)
//                .collect(Collectors.joining(" ")));
    }

    private static void parseAndFilterNumbers() {
        for (String string : input) {
            int number = Integer.parseInt(string);
            if (Math.sqrt(number) == (int) Math.sqrt(number)) {
                squares.add(number);
            }
        }
    }

    private static void descendingSortNumbers() {
        for (int i = 0; i < squares.size() - 1; i++) {
            int number = squares.get(i);
            for (int j = i + 1; j < squares.size(); j++) {
                int nextNumber = squares.get(j);
                if (number < nextNumber) {
                    squares.set(i, nextNumber);
                    squares.set(j, number);
                    number = squares.get(i);
                }
            }
        }
    }

    private static void printList() {
        StringBuilder output = new StringBuilder();
        for (Integer number : squares) {
            output.append(number).append(" ");
        }
        System.out.println(output.toString().trim());
    }
}
