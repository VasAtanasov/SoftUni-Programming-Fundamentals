package L10MethodsAndDebuggingExercises;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Ex09LongerLine {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double x1 = Double.parseDouble(reader.readLine());
        double y1 = Double.parseDouble(reader.readLine());
        double x2 = Double.parseDouble(reader.readLine());
        double y2 = Double.parseDouble(reader.readLine());
        double x3 = Double.parseDouble(reader.readLine());
        double y3 = Double.parseDouble(reader.readLine());
        double x4 = Double.parseDouble(reader.readLine());
        double y4 = Double.parseDouble(reader.readLine());

        double lineOne = Point.distance(x1, y1, x2, y2);
        double lineTwo = Point.distance(x3, y3, x4, y4);
        DecimalFormat df = new DecimalFormat("0.##########################");

        if (lineOne >= lineTwo) {
            printPoints(x1, y1, x2, y2, df);
        } else if (lineOne < lineTwo) {
            printPoints(x3, y3, x4, y4, df);
        }
    }

    private static void printPoints(double x1, double y1, double x2, double y2, DecimalFormat df) {
        double distanceOne = getDistance(x1, y1);
        double distanceTwo = getDistance(x2, y2);
        if (distanceOne <= distanceTwo) {
            System.out.println(String.format("(%s, %s)(%s, %s)", df.format(x1), df.format(y1), df.format(x2), df.format(y2)));
        } else {
            System.out.println(String.format("(%s, %s)(%s, %s)", df.format(x2), df.format(y2), df.format(x1), df.format(y1)));
        }
    }

    private static double getDistance(double px, double py) {
        return Math.sqrt(px * px + py * py);
    }
}
