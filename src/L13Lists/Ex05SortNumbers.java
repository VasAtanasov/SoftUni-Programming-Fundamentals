package L13Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Ex05SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> list = DoubleStream.of(Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .sorted()
                .toArray())
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(list.stream().map(Object::toString).collect(Collectors.joining(" ")));

    }
}
