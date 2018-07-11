package L09MethodsAndDebugging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Ex10HolidaysBetweenTwoDates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d.M.yyyy");

        LocalDate startDate = LocalDate.parse(reader.readLine(), dtf);
        LocalDate endDate = LocalDate.parse(reader.readLine(), dtf);

        int holidaysCount = 0;

        while (startDate.compareTo(endDate) <= 0) {
            if (startDate.getDayOfWeek().getValue() == 6 || startDate.getDayOfWeek().getValue() == 7) {
                holidaysCount++;
            }
            startDate = startDate.plusDays(1);
        }

        System.out.println(holidaysCount);
    }
}
