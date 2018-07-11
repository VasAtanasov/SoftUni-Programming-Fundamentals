package L11Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;

public class Ex05RoundAwayFromZero01 {
    private static BufferedReader reader;
    private static double[] numbers;
    private static double[] numbersRounded;
    private static DecimalFormat df;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        df = new DecimalFormat("0.#####");
//        numbers = new double[] {0.9, 1.5, 2.4, 2.5, 3.14};
//        numbers = new double[] {-5.01, -1.599, -2.5, -1.50, 0};
    }

    public static void main(String[] args) throws IOException {
        numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();
        numbersRounded = new double[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            double numberRounded = Math.floor(Math.abs(numbers[i]) + 0.5);
            numbersRounded[i] = numbers[i] < 0 ? numberRounded * - 1 : numberRounded;
        }

        for (int i = 0; i < numbers.length; i++) {

            System.out.println(String.format("%s => %s", df.format(numbers[i]), df.format(numbersRounded[i])));
        }
    }
}

