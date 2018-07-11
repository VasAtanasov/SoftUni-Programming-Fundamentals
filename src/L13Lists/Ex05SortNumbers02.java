package L13Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ex05SortNumbers02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input[] = scanner.nextLine().split(" ");
        List<Double> numbers = new ArrayList<Double>();

        for (String anInput : input) {
            numbers.add(Double.parseDouble(anInput));
        }

        Collections.sort(numbers);

        System.out.println(numbers);
    }
}
