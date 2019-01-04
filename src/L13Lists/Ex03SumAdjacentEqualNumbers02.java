package L13Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex03SumAdjacentEqualNumbers02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        List<Double> numbers = new ArrayList<Double>();
        double sum = 0;

        for (String anInput : input) {
            numbers.add(Double.parseDouble(anInput));
        }

        for (int i = 0; i < input.length; i++) {
            try {
                if (numbers.get(i).equals(numbers.get(i + 1))) {
                    sum = numbers.get(i) + numbers.get(i + 1);
                    numbers.remove(i);
                    numbers.remove(i);
                    numbers.add(i, sum);
                    i = -1;
                }
            } catch (Exception ex) {
                break;
            }

        }
        System.out.println(numbers);
    }
}
