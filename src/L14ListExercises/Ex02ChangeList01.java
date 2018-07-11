package L14ListExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ex02ChangeList01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = IntStream.of(Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray())
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));

        String[] command = scanner.nextLine().split("\\s+");

        while (true) {
            if ("Odd".equals(command[0]) || "Even".equals(command[0])) {
                break;
            }
            int length = command.length;

            switch (length) {
                case 2:
                    deleteAllEqualElements(numbers, Integer.parseInt(command[1]));
                    break;
                case 3:
                    insertElementAt(numbers, Integer.parseInt(command[1]), Integer.parseInt(command[2]));
                    break;
            }

            command = scanner.nextLine().split("\\s+");
        }

        String printList = "Odd".equals(command[0]) ? getAllOddNumbers(numbers) : getAllEvenNumbers(numbers);
        System.out.println(printList);

    }

    private static String getAllEvenNumbers(List<Integer> numbers) {
        StringBuilder evenNumbers = new StringBuilder();
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                evenNumbers.append(number);
                evenNumbers.append(" ");
            }

        }

        return evenNumbers.toString().trim();
    }

    private static String getAllOddNumbers(List<Integer> numbers) {
        StringBuilder oddNumbers = new StringBuilder();
        for (Integer number : numbers) {
            if (number % 2 != 0) {
                oddNumbers.append(number);
                oddNumbers.append(" ");
            }

        }

        return oddNumbers.toString().trim();
    }

    private static void insertElementAt(List<Integer> numbers, int element, int index) {
        numbers.add(index, element);
    }

    private static void deleteAllEqualElements(List<Integer> numbers, int number) {
        while (numbers.contains(number)) {
            for (int i = 0; i < numbers.size(); i++) {
                if (numbers.get(i) == number) {
                    numbers.remove(i);
                }
            }
        }
    }
}
