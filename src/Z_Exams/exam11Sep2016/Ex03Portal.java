package Z_Exams.exam11Sep2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex03Portal {
    private static BufferedReader reader;
    private static int rows;
    private static int[][] matrix;
    private static int turns;
    private static int currentRow;
    private static int currentCol;
    private static String[] moves;
    private static boolean isSuccessful;
    private static int element;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        isSuccessful = false;
    }

    public static void main(String[] args) throws IOException {
        receiveInput();

        for (String move : moves) {
            nextCell(move);
            if (element == 1) {
                isSuccessful = true;
                break;
            }
        }

        if (isSuccessful) {
            System.out.println(String.format("Experiment successful. %d turns required.", turns));
        } else {
            System.out.println(String.format("Robot stuck at %d %d. Experiment failed.", currentRow, currentCol));
        }

    }

    private static void nextCell(String move) {
        switch (move) {
            case "R":
                moveRight();
                break;
            case "L":
                moveLeft();
                break;
            case "D":
                moveDown();
                break;
            case "U":
                moveUp();
                break;
        }
    }

    private static void moveUp() {
        boolean moving = true;
        while (moving) {
            try {
                currentRow = (currentRow - 1) < 0 ? matrix.length - 1 : currentRow - 1;
                element = matrix[currentRow][currentCol];
                turns++;
                moving = false;
            } catch (Exception ex) {
            }
        }
    }

    private static void moveDown() {
        boolean moving = true;
        while (moving) {
            try {
                currentRow = (currentRow + 1) % matrix.length;
                element = matrix[currentRow][currentCol];
                turns++;
                moving = false;
            } catch (Exception ex) {
            }
        }
    }

    private static void moveLeft() {
        boolean moving = true;
        while (moving) {
            try {
                currentCol = (currentCol - 1) < 0 ? matrix[currentRow].length - 1 : currentCol - 1;
                element = matrix[currentRow][currentCol];
                turns++;
                moving = false;
            } catch (Exception ex) {
            }
        }
    }

    private static void moveRight() {
        boolean moving = true;
        while (moving) {
            try {
                currentCol = (currentCol + 1) % matrix[currentRow].length;
                element = matrix[currentRow][currentCol];
                turns++;
                moving = false;
            } catch (Exception ex) {
            }
        }
    }

    private static void receiveInput() throws IOException {
        rows = Integer.parseInt(reader.readLine());
        matrix = new int[rows][];

        for (int row = 0; row < rows; row++) {
            String[] cols = reader.readLine().split("");
            matrix[row] = new int[cols.length];
            for (int col = 0; col < cols.length; col++) {
                matrix[row][col] = "E".equals(cols[col]) ? 1 : 0;
                if ("S".equals(cols[col])) {
                    currentRow = row;
                    currentCol = col;
                }
            }
        }

        moves = reader.readLine().split("");
    }
}
