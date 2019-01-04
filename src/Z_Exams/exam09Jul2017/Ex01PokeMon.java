package Z_Exams.exam09Jul2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex01PokeMon {
    private static BufferedReader reader;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        long nInitial = Long.parseLong(reader.readLine());
        long n = nInitial;
        long m = Long.parseLong(reader.readLine());
        long y = Long.parseLong(reader.readLine());

        int count = 0;
        while (! (n > m)) {

            n -= m;
            if (n == nInitial * 0.5 && y > 0) {
                n /= y;
            }
            count++;
        }

        System.out.println(n);
        System.out.println(count);
    }
}
