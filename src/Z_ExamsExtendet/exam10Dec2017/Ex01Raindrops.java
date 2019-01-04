package Z_ExamsExtendet.exam10Dec2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex01Raindrops {
    private static BufferedReader reader;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(reader.readLine());
        double density = Double.parseDouble(reader.readLine());
        double sum = 0;

        for (int i = 0; i < count; i++) {
            double[] parameters = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .toArray();
            double raindropCount = parameters[0];
            double squareMeters = parameters[1];

            double regionalCoefficient = raindropCount / squareMeters;
            sum += regionalCoefficient;
        }

        double result = density == 0 ? sum : sum / density;
        System.out.println(String.format("%.3f",result));
    }
}
