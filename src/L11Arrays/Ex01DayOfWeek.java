package L11Arrays;

import java.util.Scanner;

public class Ex01DayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] weekDays = new String[]{
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday",
        };

        System.out.println((n >= 1 && n <= 7) ? weekDays[n - 1] : "Invalid Day!");
    }
}
