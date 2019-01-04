package Z_Exams.exam12Jun2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex04TrifonQuest {
    private static char[][] map;
    private static int[] dimension;
    private static BufferedReader reader;
    private static long health;
    private static int turn;
    private static boolean isDead;
    private static int rowDied;
    private static int colDied;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        turn = 0;
        isDead = false;
        rowDied = 0;
        colDied = 0;
    }


    public static void main(String[] args) throws IOException {
        health = Integer.parseInt(reader.readLine());
        dimension = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        initializeMap();
        startQuest();

        if (isDead) {
            System.out.println(String.format("Died at: [%d, %d]", rowDied, colDied));
        } else {
            System.out.println("Quest completed!");
            System.out.println(String.format("Health: %d", health));
            System.out.println(String.format("Turns: %d", turn));
        }


    }

    private static void startQuest() {
        int cols = dimension[1];
        for (int col = 0; col < cols; col++) {
            if (col % 2 == 0) {
                moveDown(col);
            } else {
                moveUp(col);
            }
            if (isDead) {
                return;
            }
        }
    }

    private static void moveDown(int col) {
        for (int row = 0; row < map.length; row++) {
            processTurn(map[row][col]);
            advanceOneTurn();

            if (health <= 0) {
                isDead = true;
                rowDied = row;
                colDied = col;
                return;
            }

        }
    }

    private static void moveUp(int col) {
        for (int row = map.length - 1; row >= 0; row--) {
            processTurn(map[row][col]);
            advanceOneTurn();

            if (health <= 0) {
                isDead = true;
                rowDied = row;
                colDied = col;
                return;
            }

        }
    }

    private static void processTurn(char c) {
        switch (c) {
            case 'F':
                health -= (turn / 2);
                break;
            case 'H':
                health += (turn / 3);
                break;
            case 'T':
                advanceOneTurn();
                advanceOneTurn();
                break;
        }
    }

    private static void advanceOneTurn() {
        turn += 1;
    }

    private static void initializeMap() throws IOException {
        int rows = dimension[0];
        map = new char[rows][];
        for (int row = 0; row < rows; row++) {
            char[] filed = reader.readLine().toCharArray();
            map[row] = new char[filed.length];
            for (int col = 0; col < map[row].length; col++) {
                map[row][col] = filed[col];
            }
        }
    }
}
