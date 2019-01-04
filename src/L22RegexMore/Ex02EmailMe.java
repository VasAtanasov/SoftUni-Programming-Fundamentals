package L22RegexMore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex02EmailMe {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String email = reader.readLine();

        int sumBefore = email.substring(0, email.indexOf("@")).chars().sum();
        int sumAfter = email.substring(email.indexOf("@") + 1).chars().sum();

        if ((sumBefore - sumAfter) >= 0) {
            System.out.println("Call her!");
        } else {
            System.out.println("She is not the one.");
        }
    }
}
