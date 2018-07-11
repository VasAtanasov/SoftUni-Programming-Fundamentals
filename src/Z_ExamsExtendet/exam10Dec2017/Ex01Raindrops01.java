package Z_ExamsExtendet.exam10Dec2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex01Raindrops01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(reader.readLine());
        double density = Double.valueOf(reader.readLine());

        double coefficients = 0;
        for (int i = 0; i < n; i++) {
            coefficients += Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToDouble(Double::valueOf)
                    .reduce((a, b) -> a / b)
                    .getAsDouble();
        }

        double result = density == 0 ? coefficients : coefficients / density;
        System.out.println(String.format("%.3f", result));
    }
}

