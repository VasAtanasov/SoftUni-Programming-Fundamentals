package L13Lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Ex06SquareNumbers03 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        List<Integer> numbers = makeList(reader.readLine().split("\\s+"));
//        numbers = numbers.stream().filter(num -> Math.sqrt(num) == (int) Math.sqrt(num))
//                .sorted(Comparator.reverseOrder()).collect(Collectors.toList());

//        System.out.println(numbers.stream().map(String::valueOf).collect(Collectors.joining(" ")));

        System.out.println(Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::valueOf)
                .filter(num -> Math.sqrt(num) == (int) Math.sqrt(num))
                .sorted(Comparator.reverseOrder())
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));


    }


//    private static List<Integer> makeList(String[] list) {
//        List<Integer> makeList = new ArrayList<>();
//        for (String num : list) {
//            makeList.add(Integer.valueOf(num));
//        }
//        return makeList;
//    }
}
