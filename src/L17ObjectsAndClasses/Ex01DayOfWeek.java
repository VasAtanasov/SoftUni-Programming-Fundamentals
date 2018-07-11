package L17ObjectsAndClasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Ex01DayOfWeek {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LocalDate date = LocalDate.parse(reader.readLine(), DateTimeFormatter.ofPattern("d-M-yyyy"));
        System.out.println(date.getDayOfWeek().toString());
    }
}
