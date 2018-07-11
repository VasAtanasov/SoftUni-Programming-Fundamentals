package L16DictionariesMore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex06ByteFlip {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(
                new StringBuilder(
                        Arrays.stream(reader.readLine().split("\\s+"))
                                .filter(e -> e.length() == 2)
                                .map(n -> new StringBuilder(n).reverse().toString())
                                .mapToInt(n -> Integer.parseInt(n, 16))
                                .mapToObj(c -> String.valueOf((char) c))
                                .reduce("", (a, b) -> a + b)
                ).reverse().toString()
        );

    }
}
