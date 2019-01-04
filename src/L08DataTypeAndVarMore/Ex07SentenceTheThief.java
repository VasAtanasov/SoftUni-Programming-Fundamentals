package L08DataTypeAndVarMore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex07SentenceTheThief {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String dataType = reader.readLine();
        int lines = Integer.parseInt(reader.readLine());

        long maxBound = getMaxBound(dataType);
        long bestId = Long.MIN_VALUE;
        long bestYears = 0;

        for (int i = 0; i < lines; i++) {
            long id = Long.parseLong(reader.readLine());
            long boundary = id < 0 ? - 128 : 127;
            long years = (long) Math.ceil((double) id / (double) boundary);

            if (id > bestId && id <= maxBound) {
                bestId = id;
                bestYears = years;
            }
        }

        String years = bestYears > 1 ? "years" : "year";
        System.out.println(String.format("Prisoner with id %d is sentenced to %d %s", bestId, bestYears, years));

    }

    private static long getMaxBound(String dataType) {
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
