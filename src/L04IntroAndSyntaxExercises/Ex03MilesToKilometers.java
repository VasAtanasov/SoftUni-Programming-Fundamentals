package L04IntroAndSyntaxExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex03MilesToKilometers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double kilometers = Double.parseDouble(reader.readLine()) * 1.60934;
        System.out.println(String.format("%.2f", kilometers));
    }
}
