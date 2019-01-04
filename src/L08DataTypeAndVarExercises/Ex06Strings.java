package L08DataTypeAndVarExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex06Strings {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String wordOne = reader.readLine();
        String wordTwo = reader.readLine();
        System.out.println(String.format("%s %s",wordOne,wordTwo));

    }
}
