package L10MethodsAndDebuggingExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex10CubeProperties {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double side = Double.parseDouble(reader.readLine());
        String property = reader.readLine();
        double value = 0;

        switch (property) {
            case "face":
                value = getFace(side);
                break;
            case "volume":
                value = getVolume(side);
                break;
            case "space":
                value = getSpace(side);
                break;
            case "area":
                value = getSurfaceArea(side);
                break;
        }

        System.out.println(String.format("%.2f", value));
    }

    private static double getFace(double side) {
        return Math.sqrt(2 * Math.pow(side, 2));
    }

    private static double getSpace(double side) {
        return Math.sqrt(3 * Math.pow(side, 2));
    }

    private static double getVolume(double side) {
        return Math.pow(side, 3);
    }

    private static double getSurfaceArea(double side) {
        return 6 * Math.pow(side, 2);
    }
}
