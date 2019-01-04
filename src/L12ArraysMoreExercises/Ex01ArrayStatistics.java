package L12ArraysMoreExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;

public class Ex01ArrayStatistics {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        IntSummaryStatistics numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .collect(Collectors.summarizingInt(Integer::parseInt));
        DecimalFormat df = new DecimalFormat("0.########################################################################################################");
        BigDecimal average = new BigDecimal(numbers.getAverage());

        System.out.println(String.format("Min = %d",numbers.getMin()));
        System.out.println(String.format("Max = %d",numbers.getMax()));
        System.out.println(String.format("Sum = %d",numbers.getSum()));
        System.out.println(String.format("Average = %s",numbers.getAverage()));
    }
}
