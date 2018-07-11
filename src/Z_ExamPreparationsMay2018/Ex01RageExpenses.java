package Z_ExamPreparationsMay2018;

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

        int headSetCount = gamesLost / 2;
        int mouseCount = gamesLost / 3;
        int keyboardCount = gamesLost / 6;
        int displayCount = gamesLost / 12;


        double totalExpenses = (headSetCount * headSetPrise) +
                (mouseCount * mousePrise) +
                (keyboardCount * keyboardPrise) +
                (displayCount * displayPrise);

        System.out.println(String.format("Rage expenses: %.2f lv.", totalExpenses));
    }
}
