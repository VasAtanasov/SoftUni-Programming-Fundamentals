package L10MethodsAndDebuggingExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex11GeometryCalculator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String shape = reader.readLine();
        double area = 0;

        if ("triangle".equals(shape)) {
            double side = Double.parseDouble(reader.readLine());
            double height = Double.parseDouble(reader.readLine());
            area = getTriangleArea(side, height);
        } else if ("square".equals(shape)) {
            double side = Double.parseDouble(reader.readLine());
            area = getSquareArea(side);
        } else if ("rectangle".equals(shape)) {
            double width = Double.parseDouble(reader.readLine());
            double height = Double.parseDouble(reader.readLine());
            area = getRectangleArea(width, height);
        } else if ("circle".equals(shape)) {
            double radius = Double.parseDouble(reader.readLine());
            area = getCircleArea(radius);

        }
        System.out.println(String.format("%.2f", area));
    }

    private static double getCircleArea(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    private static double getRectangleArea(double width, double height) {
        return width * height;
    }

    private static double getSquareArea(double side) {
        return Math.pow(side, 2);
    }

    private static double getTriangleArea(double side, double height) {
        return (side * height) / 2;
    }
}
