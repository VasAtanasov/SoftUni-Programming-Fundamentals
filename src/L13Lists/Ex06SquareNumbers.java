package L13Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex06SquareNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayList<Integer> squares = new ArrayList<>();

        for (int number : input) {
            double numberSquare = Math.sqrt(number);
            if (numberSquare ==(int)numberSquare) {
                squares.add(number);
            }
        }
        Collections.sort(squares);
        Collections.reverse(squares);

        System.out.println(squares.stream().map(Object::toString).collect(Collectors.joining(" ")));

    }
}
