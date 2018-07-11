package L04IntroAndSyntaxExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex02RectangleArea {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double width = Double.parseDouble(reader.readLine());
        double height = Double.parseDouble(reader.readLine());
        System.out.println(String.format("%.2f", width * height));
    }
}
