package L08DataTypeAndVarMore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex03WaterOverflow {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int waterTankCapacity = 255;
        int n = Integer.parseInt(reader.readLine());
        int litersInTank = 0;
        for (int i = 0; i < n; i++) {
            int liters = Integer.parseInt(reader.readLine());
            if (litersInTank + liters <= waterTankCapacity) {
                litersInTank += liters;
            } else {
                System.out.println("Insufficient capacity!");
            }
        }

        System.out.println(litersInTank);
    }
}
