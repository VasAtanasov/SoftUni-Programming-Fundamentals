package L08DataTypeAndVarMore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex08HouseBuilder {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long numberOne = Long.parseLong(reader.readLine());
        long numberTwo = Long.parseLong(reader.readLine());

        if (numberOne < 128) {
            numberOne *= 4;
            numberTwo *= 10;
        } else {
            numberTwo *= 4;
            numberOne *= 10;
        }

        System.out.println(numberOne + numberTwo);


    }
}
