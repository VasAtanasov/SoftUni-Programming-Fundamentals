package L12ArraysExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex01LargestCommonEnd01 {
    private static String[] arrayOne;
    private static String[] arrayTwo;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        arrayOne = reader.readLine().split("\\s+");
        arrayTwo = reader.readLine().split("\\s+");

        int minLength = Math.min(arrayOne.length, arrayTwo.length);

        int commonEndLeft = 0;
        int commonEndRight = 0;

        for (int i = 0; i < minLength; i++) {
            if (arrayOne[i].equals(arrayTwo[i])) {
                commonEndLeft++;
            } else {
                break;
            }

        }

        for (int i = 0; i < minLength; i++) {
            if (arrayOne[arrayOne.length-i-1].equals(arrayTwo[arrayTwo.length-i-1])) {
                commonEndRight++;
            } else {
                break;
            }
        }


        System.out.println(Math.max(commonEndLeft, commonEndRight));
    }
}
