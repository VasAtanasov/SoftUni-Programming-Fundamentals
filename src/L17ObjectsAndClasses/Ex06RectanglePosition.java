package L17ObjectsAndClasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex06RectanglePosition {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] r1 = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] r2 = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Rectangle one = new Rectangle(r1[0], r1[1], r1[2], r1[3]);
        Rectangle two = new Rectangle(r2[0], r2[1], r2[2], r2[3]);

        System.out.println(one.isInside(two) ? "Inside" : "Not inside");

    }
}


class Rectangle {
    private int left;
    private int right;
    private int top;
    private int bottom;

    Rectangle(int left, int top, int width, int height) {
        this.left = left;
        this.top = top;
        this.right = left + width;
        this.bottom = top - height;
    }

    private int getLeft() {
        return this.left;
    }

    private int getRight() {
        return this.right;
    }

    private int getTop() {
        return this.top;
    }

    private int getBottom() {
        return this.bottom;
    }

    boolean isInside(Rectangle rectangle) {
        return this.getLeft() >= rectangle.getLeft() &&
                this.getRight() <= rectangle.getRight() &&
                this.getTop() <= rectangle.getTop() &&
                this.getBottom() >= rectangle.getBottom();
    }
}
