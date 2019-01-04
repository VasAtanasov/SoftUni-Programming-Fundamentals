package L10MethodsAndDebuggingExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Ex08CenterPoint {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double x1 = Double.parseDouble(reader.readLine());
        double y1 = Double.parseDouble(reader.readLine());
        double x2 = Double.parseDouble(reader.readLine());
        double y2 = Double.parseDouble(reader.readLine());

        double distanceA = getDistance(x1,y1);
        double distanceB = getDistance(x2,y2);
        DecimalFormat df = new DecimalFormat("0.#######");

        if (distanceA < distanceB) {
            System.out.println(String.format("(%s, %s)", df.format(x1), df.format(y1)));
        } else if (distanceB < distanceA) {
            System.out.println(String.format("(%s, %s)", df.format(x2), df.format(y2)));
        } else if (distanceA == distanceB) {
            System.out.println(String.format("(%s, %s)", df.format(x1), df.format(y1)));
        }
    }

    private static double getDistance(double px, double py) {
        return Math.sqrt(px * px + py * py);
    }
}
