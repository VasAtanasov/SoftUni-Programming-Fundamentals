package L13Lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Ex03SumAdjacentEqualNumbers03 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Double> numbres = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Double::valueOf)
                .collect(Collectors.toCollection(ArrayList::new));

        boolean isEqualPares = true;
        while (isEqualPares) {
            isEqualPares = false;
            for (int i = 0; i < numbres.size() - 1; i++) {
                if (Objects.equals(numbres.get(i), numbres.get(i + 1))) {
                    double sum = numbres.get(i) + numbres.get(i + 1);
                    numbres.set(i, sum);
                    numbres.remove(i + 1);
                    isEqualPares = true;
                    break;
                }
            }
        }

        printList(numbres);
    }

    private static void printList(List<Double> numbres) {
        StringBuilder output = new StringBuilder();
        for (Double number : numbres) {
            output.append(number).append(" ");
        }
        System.out.println(output.toString().trim());
    }
}
