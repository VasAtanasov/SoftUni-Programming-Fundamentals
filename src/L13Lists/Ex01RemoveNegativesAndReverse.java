package L13Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ex01RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = IntStream.of(Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .filter((s) -> s > 0)
                .toArray())
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));

        Collections.reverse(list);

        System.out.println((list.size() == 0) ? "empty" :
                list.stream().map(Object::toString).collect(Collectors.joining(" ")));

    }

}
