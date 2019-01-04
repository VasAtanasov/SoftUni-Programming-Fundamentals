package Z_ExamsExtendet.exam30Apr2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex01WormTest01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double wormLengthCm = Double.valueOf(reader.readLine()) * 100.0;
        double wormWidthCm = Double.valueOf(reader.readLine());

        if (wormWidthCm == 0 || wormLengthCm % wormWidthCm == 0) {
            System.out.println(String.format("%.2f", wormLengthCm * wormWidthCm));
        } else {
            double percent = (wormLengthCm / wormWidthCm) * 100.0;
            System.out.println(String.format("%.2f%%",percent));
        }
    }
}
