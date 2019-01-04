package L08DataTypeAndVarExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex16ComparingFloats {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double numberOne = Double.parseDouble(reader.readLine());
        double numberTwo = Double.parseDouble(reader.readLine());
        double eps = 0.000001;

        double diff = Math.abs(numberOne - numberTwo);

        if (diff > eps) {
            System.out.println("False");
        } else {
            System.out.println("True");
        }
    }
}
