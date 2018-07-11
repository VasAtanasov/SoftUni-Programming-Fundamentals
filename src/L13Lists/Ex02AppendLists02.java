package L13Lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Ex02AppendLists02 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] list = reader.readLine().split("[|]");
        List<Integer> numbers = new ArrayList<>();

        for (int i = list.length - 1; i >= 0; i--) {
            String[] tokens = list[i].split("\\s+");
            for (String token : tokens) {
                if (! token.equals("")) {
                    numbers.add(Integer.valueOf(token));
                }

            }
        }

        printList(numbers);
    }

    private static void printList(List<Integer> numbers) {
        StringBuilder list = new StringBuilder();
        for (Integer number : numbers) {
            list.append(number);
            list.append(" ");

        }
        System.out.println(list.toString().trim());
    }


}
