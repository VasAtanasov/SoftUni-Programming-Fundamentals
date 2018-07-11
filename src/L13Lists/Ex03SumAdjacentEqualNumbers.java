package L13Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Ex03SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> list = DoubleStream.of(Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray())
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));

        sumAdjacentEquals(list);
        System.out.println(list.stream().map(Object::toString).collect(Collectors.joining(" ")));

    }

    private static void sumAdjacentEquals(List<Double> list) {
        int size = list.size() - 1;
        int i = 0;
        while (i != size) {
            if (list.get(i + 1).equals(list.get(i))) {
                double sum = list.get(i + 1) + (list.get(i));
                list.add(i, sum);
                list.remove(i + 1);
                list.remove(i + 1);
                size--;
                i = 0;
            } else {
                i++;
            }
        }
    }

}
