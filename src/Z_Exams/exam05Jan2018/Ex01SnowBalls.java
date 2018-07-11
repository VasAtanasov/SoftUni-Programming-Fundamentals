package Z_Exams.exam05Jan2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Ex01SnowBalls {
    private static BufferedReader reader;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(reader.readLine());
        BigInteger highestValue = BigInteger.ZERO;
        String output = "";

        for (int i = 0; i < count; i++) {
            BigInteger snowBallSnow = new BigInteger(reader.readLine());
            BigInteger snowBallTime = new BigInteger(reader.readLine());
            int snowBallQuality = Integer.parseInt(reader.readLine());

            BigInteger value = (snowBallSnow.divide(snowBallTime)).pow(snowBallQuality);
            if (value.compareTo(highestValue) > 0) {
                highestValue = value;
                output = String.format("%d : %d = %d (%d)", snowBallSnow, snowBallTime, value, snowBallQuality);
            }
        }

        System.out.println(output);
    }
}
