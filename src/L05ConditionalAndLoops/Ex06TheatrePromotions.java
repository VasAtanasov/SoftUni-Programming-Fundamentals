package L05ConditionalAndLoops;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex06TheatrePromotions {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String day = reader.readLine();
        int age = Integer.parseInt(reader.readLine());
        int[] weekday = {12, 18, 12};
        int[] weekend = {15, 20, 15};
        int[] holiday = {5, 12, 10};

        int index = - 1;

        if (age >= 0 && age <= 18) {
            index = 0;
        } else if (age > 18 && age <= 64) {
            index = 1;
        } else if (age > 64 && age <= 122) {
            index = 2;
        }

        if (index == - 1) {
            System.out.println("Error!");
            return;
        }

        switch (day) {
            case "Weekday":
                System.out.println(String.format("%d$", weekday[index]));
                break;
            case "Weekend":
                System.out.println(String.format("%d$", weekend[index]));
                break;
            case "Holiday":
                System.out.println(String.format("%d$", holiday[index]));
                break;
        }


    }
}
