package L13Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ex06SquareNumbers02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        List<Integer> numbers = new ArrayList<Integer>();

        for (int i = 0; i < input.length; i++) {
            int number = Integer.parseInt(input[i]);
            int sqrt = (int) Math.sqrt(number);
            if(sqrt*sqrt == number) {
                numbers.add(number);
            }
        }

        Collections.sort(numbers);
        Collections.reverse(numbers);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numbers.size(); i++) {
            result.append(numbers.get(i));
            result.append(" ");
        }
        System.out.println(result.toString().trim());
    }
}
