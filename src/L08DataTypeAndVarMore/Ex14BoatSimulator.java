package L08DataTypeAndVarMore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex14BoatSimulator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char boatOne = reader.readLine().charAt(0);
        char boatTwo = reader.readLine().charAt(0);
        int lines = Integer.parseInt(reader.readLine());
        int boatOneTiles = 0;
        int boatTwoTiles = 0;

        for (int i = 1; i <= lines; i++) {
            String input = reader.readLine();
            if ("UPGRADE".equals(input)) {
                boatOne += 3;
                boatTwo += 3;
                continue;
            }

            if (i % 2 != 0) {
                boatOneTiles += input.length();
            } else {
                boatTwoTiles += input.length();
            }

            if (boatOneTiles >= 50) {
                System.out.println(String.format("%c", boatOne));
                return;
            }
            if (boatTwoTiles >= 50) {
                System.out.println(String.format("%c", boatTwo));

                return;
            }
        }

        System.out.println(String.format("%c", boatOneTiles > boatTwoTiles ? boatOne : boatTwo));

    }
}
