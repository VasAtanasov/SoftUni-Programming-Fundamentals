package Z_Exams.exam25Apr2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex01RageExpenses {
    private static BufferedReader reader;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        int gamesLost = Integer.parseInt(reader.readLine());
        double headSetPrise = Double.parseDouble(reader.readLine());
        double mousePrise = Double.parseDouble(reader.readLine());
        double keyboardPrise = Double.parseDouble(reader.readLine());
        double displayPrise = Double.parseDouble(reader.readLine());

        int headSetCount = 0;
        int mouseCount = 0;
        int keyboardCount = 0;
        int displayCount = 0;

        for (int i = 1; i <= gamesLost; i++) {
            if (i % 2 == 0) {
                headSetCount++;
            }
            if (i % 3 == 0) {
                mouseCount++;
            }
            if (i % 2 == 0 && i % 3 == 0) {
                keyboardCount++;
                if (keyboardCount % 2 == 0 && keyboardCount > 0) {
                    displayCount++;
                }
            }
        }

        double totalExpenses = (headSetCount * headSetPrise) +
                (mouseCount * mousePrise) +
                (keyboardCount * keyboardPrise) +
                (displayCount * displayPrise);

        System.out.println(String.format("Rage expenses: %.2f lv.",totalExpenses));
    }
}
