package L08DataTypeAndVarMore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex06CatchTheThief {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String dataType = reader.readLine();
        long maxValue = getMaxValue(dataType);
        int lines = Integer.parseInt(reader.readLine());

        long bestDiff = Long.MAX_VALUE;
        long bestNumber = Long.MIN_VALUE;

        for (int i = 0; i < lines; i++) {
            long number = Long.parseLong(reader.readLine());
            long diff = Math.abs(maxValue - number);
            if (diff < bestDiff) {
                bestDiff = diff;
                bestNumber = number;
            }
        }

        System.out.println(bestNumber);

    }

    private static long getMaxValue(String dataType) {
        switch (dataType) {
            case "sbyte":
                return Byte.MAX_VALUE;
            case "int":
                return Integer.MAX_VALUE;
            case "long":
                return Long.MAX_VALUE;
        }
        return 0;
    }
}
