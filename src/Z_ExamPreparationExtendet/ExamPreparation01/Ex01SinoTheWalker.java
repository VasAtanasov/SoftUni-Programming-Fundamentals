package Z_ExamPreparationExtendet.ExamPreparation01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Ex01SinoTheWalker {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime time = LocalTime.parse(reader.readLine(), dtf);
        BigInteger steps = new BigInteger(reader.readLine());
        BigInteger seconds = new BigInteger(reader.readLine());
        BigInteger totalSeconds = steps.multiply(seconds);

        System.out.println(String.format("Time Arrival: %s", time.plusSeconds(totalSeconds.longValue()).format(dtf)));
    }
}
