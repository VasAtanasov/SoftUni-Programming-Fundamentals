package L13Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex01RemoveNegativesAndReverse03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        List<Integer> numbers = new ArrayList<Integer>();

        for (int i = input.length - 1; i >= 0; i--) {
            if (Integer.parseInt(input[i]) >= 0) {
                numbers.add(Integer.parseInt(input[i]));
            }
        }

        if (numbers.isEmpty()) {
            System.out.println("empty");
        } else {
            System.out.println(numbers);

        }
    }
}
