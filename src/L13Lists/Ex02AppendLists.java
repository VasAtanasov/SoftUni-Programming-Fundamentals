package L13Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ex02AppendLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("[|]");
        List<String> list = new ArrayList<String>();

        for (int i = input.length - 1; i >= 0; i--) {
            String[] temp = input[i].split(" ");
            list.addAll(Arrays.asList(temp));
        }
        System.out.println(list);
    }
}
