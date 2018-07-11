package L15Dictionaries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.IntSummaryStatistics;

public class Ex03SumMinMaxAverage {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        IntSummaryStatistics numbers = new IntSummaryStatistics();
        for (int i = 0; i < n; i++) {
            numbers.accept(Integer.parseInt(reader.readLine()));
        }

        DecimalFormat df = new DecimalFormat("0.##########");
        System.out.println(String.format("Sum = %d", numbers.getSum()));
        System.out.println(String.format("Min = %d", numbers.getMin()));
        System.out.println(String.format("Max = %d", numbers.getMax()));
        System.out.println(String.format("Average = %s", df.format(numbers.getAverage())));
    }
}
