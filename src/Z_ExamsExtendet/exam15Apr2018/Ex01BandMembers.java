package Z_ExamsExtendet.exam15Apr2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex01BandMembers {
    private static BufferedReader reader;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        int members = Integer.parseInt(reader.readLine());
        final int VOCALIST = 1;
        final int GUITARISTS = members / 3;
        final int DRUMMERS = members - (VOCALIST + GUITARISTS);

        double guitarPrice = Double.parseDouble(reader.readLine());
        double drumPrice = guitarPrice * 1.5;
        double microphonePrice = Math.abs((DRUMMERS * drumPrice) - (GUITARISTS * guitarPrice));

        double totalForInstruments = microphonePrice +
                (GUITARISTS * guitarPrice) +
                (DRUMMERS * drumPrice);

        double forRent = 12 * (totalForInstruments / members);

        System.out.println(String.format("Total cost: %.2flv.", totalForInstruments + forRent));

    }
}
