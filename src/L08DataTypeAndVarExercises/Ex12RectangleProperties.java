package L08DataTypeAndVarExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Ex12RectangleProperties {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double width = Double.parseDouble(reader.readLine());
        double height = Double.parseDouble(reader.readLine());
        DecimalFormat df = new DecimalFormat("0.#############");

        double perimeter = 2 * width + 2 * height;
        double area = width * height;
        double diagonal = Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));

        System.out.println(String.format("%s",df.format(perimeter)));
        System.out.println(String.format("%s", df.format(area)));
        System.out.println(String.format("%s", df.format(diagonal)));

    }
}
