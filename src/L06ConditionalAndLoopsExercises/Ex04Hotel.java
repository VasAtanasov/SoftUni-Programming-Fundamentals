package L06ConditionalAndLoopsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex04Hotel {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String month = reader.readLine();
        int totalNights = Integer.parseInt(reader.readLine());

        double studioPerNight = 0;
        double doublePerNight = 0;
        double suitePerNight = 0;

        double studioDiscount = 1;
        double doubleDiscount = 1;
        double suiteDiscount = 1;
        boolean isFreeNight = false;

        switch (month) {
            case "May":
            case "October":
                studioPerNight = 50;
                doublePerNight = 65;
                suitePerNight = 75;
                studioDiscount = totalNights > 7 ? 0.95 : 1;
                break;
            case "June":
            case "September":
                studioPerNight = 60;
                doublePerNight = 72;
                suitePerNight = 82;
                doubleDiscount = totalNights > 14 ? 0.9 : 1;
                break;
            case "July":
            case "August":
            case "December":
                studioPerNight = 68;
                doublePerNight = 77;
                suitePerNight = 89;
                suiteDiscount = totalNights > 14 ? 0.85 : 1;
                break;
        }

        switch (month) {
            case "September":
            case "October":
                isFreeNight = totalNights > 7;
                break;
        }


        studioPerNight *= studioDiscount;
        doublePerNight *= doubleDiscount;
        suitePerNight *= suiteDiscount;

        double totalStudio = studioPerNight * totalNights;
        double totalDouble = doublePerNight * totalNights;
        double totalSuite = suitePerNight * totalNights;

        if (isFreeNight) {
            totalStudio -= studioPerNight;
        }

        System.out.println(String.format("Studio: %.2f lv.",totalStudio));
        System.out.println(String.format("Double: %.2f lv.",totalDouble));
        System.out.println(String.format("Suite: %.2f lv.",totalSuite ));


    }
}
