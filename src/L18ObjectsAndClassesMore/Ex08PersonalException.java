package L18ObjectsAndClassesMore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex08PersonalException {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int number = Integer.parseInt(reader.readLine());

            try {
                if (number < 0) {
                    throw new NegativeNumberException("My first exception is awesome!!!");
                }
                System.out.println(number);

            } catch (NegativeNumberException ne) {
                System.out.println(ne.getMessage());
                return;
            }
        }

    }
}


class NegativeNumberException extends Exception {
    NegativeNumberException(String message) {
        super(message);
    }
}