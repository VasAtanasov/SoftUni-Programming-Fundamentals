package L13Lists;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ex07CountNumbers02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input[] = scanner.nextLine().split(" ");
        List<Double> numbers = new ArrayList<Double>();
        int count = 1;

        for (String anInput : input) {
            numbers.add(Double.parseDouble(anInput));
        }

        Collections.sort(numbers);
        DecimalFormat df = new DecimalFormat("#.#");

        for (int i = 0; i < input.length; i++) {
            try {
                if (numbers.get(i).equals(numbers.get(i + 1))) {
                    count++;
                } else {
                    System.out.printf("%s -> %s%n", df.format(numbers.get(i)), count);
                    count = 1;
                }
            } catch (Exception ex) {
                System.out.printf("%s -> %s%n", df.format(numbers.get(i)), count);
                count = 1;
            }
        }
    }
}
