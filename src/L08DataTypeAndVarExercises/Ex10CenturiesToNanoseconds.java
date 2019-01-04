package L08DataTypeAndVarExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Ex10CenturiesToNanoseconds {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int centuries = Integer.parseInt(reader.readLine());
        long years = centuries * 100;
        long days = (long) (years * 365.2422);
        long hours = days * 24;
        long minutes = hours * 60;
        long seconds = minutes * 60;
        long milliseconds = seconds * 1000;
        long microseconds = milliseconds * 1000;
        BigInteger nanoseconds = BigInteger.valueOf(microseconds).multiply(BigInteger.valueOf(1000));
        System.out.println(String.format("%d centuries = %d years = %d days = %d hours = %d minutes = %d seconds = %d milliseconds = %d microseconds = %d nanoseconds",
                centuries,years,days,hours,minutes,seconds,milliseconds,microseconds,nanoseconds));

    }
}
