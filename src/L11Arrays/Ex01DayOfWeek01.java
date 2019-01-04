package L11Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex01DayOfWeek01 {
    private static String[] dayOfWeek;

    static {
        dayOfWeek = new String[] {
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday"
        };
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        if (n < 1 || n > 7) {
            System.out.println("Invalid Day!");
        } else {
            System.out.println(dayOfWeek[n - 1]);
        }
    }
}
