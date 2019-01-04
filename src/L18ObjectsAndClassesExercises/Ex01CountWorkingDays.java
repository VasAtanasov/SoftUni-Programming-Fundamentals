package L18ObjectsAndClassesExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Ex01CountWorkingDays {
    private static List<LocalDate> holidays;
    private static DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LocalDate start = LocalDate.parse(reader.readLine(), df);
        LocalDate end = LocalDate.parse(reader.readLine(), df);
        initializeHolidays();
        int workingDays = 0;

        while (start.compareTo(end) <= 0) {
            if (! isHoliday(start) && isWeekDay(start)) {
                workingDays++;
            }
            start = start.plusDays(1);
        }
        System.out.println(workingDays);

    }

    private static boolean isWeekDay(LocalDate start) {
        return ! start.getDayOfWeek().toString().equals("SATURDAY") &&
                ! start.getDayOfWeek().toString().equals("SUNDAY");
    }

    private static boolean isHoliday(LocalDate start) {
        for (LocalDate holiday : holidays) {
            int day = holiday.getDayOfMonth();
            int month = holiday.getMonth().getValue();
            if (start.getMonth().getValue() == month && start.getDayOfMonth() == day) {
                return true;
            }
        }
        return false;
    }

    private static void initializeHolidays() {
        holidays = new ArrayList<>();
        holidays.add(LocalDate.parse("01-01-2000", df));
        holidays.add(LocalDate.parse("03-03-2000", df));
        holidays.add(LocalDate.parse("01-05-2000", df));
        holidays.add(LocalDate.parse("06-05-2000", df));
        holidays.add(LocalDate.parse("24-05-2000", df));
        holidays.add(LocalDate.parse("06-09-2000", df));
        holidays.add(LocalDate.parse("22-09-2000", df));
        holidays.add(LocalDate.parse("01-11-2000", df));
        holidays.add(LocalDate.parse("24-12-2000", df));
        holidays.add(LocalDate.parse("25-12-2000", df));
        holidays.add(LocalDate.parse("26-12-2000", df));
    }
}
