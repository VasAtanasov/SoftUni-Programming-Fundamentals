package L08DataTypeAndVarExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex13VowelOrDigit {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char c = reader.readLine().charAt(0);

        if (Character.isDigit(c)) {
            System.out.println("digit");
        } else if (isVowel(c)) {
            System.out.println("vowel");
        } else {
            System.out.println("other");
        }
    }

    private static boolean isVowel(char c) {
        switch (c) {
            case 'a':
            case 'e':
            case 'o':
            case 'u':
            case 'i':
                return true;
        }
        return false;
    }
}
