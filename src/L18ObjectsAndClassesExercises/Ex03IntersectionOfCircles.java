package L18ObjectsAndClassesExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex03IntersectionOfCircles {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] cOne = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] cTwo = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Circle one = new Circle(new Point(cOne[0], cOne[1]), cOne[2]);
        Circle two = new Circle(new Point(cTwo[0], cTwo[1]), cTwo[2]);

        System.out.println(one.intersect(two) ? "Yes" : "No");

    }
}


class Circle {
    private Point center;
    private int radius;

    Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    private Point getCenter() {
        return this.center;
    }

    private int getRadius() {
        return this.radius;
    }

    boolean intersect(Circle circle) {
        double distance = this.getCenter().distance(circle.getCenter());
        double radiusSum = this.getRadius() + circle.getRadius();
        return distance <= radiusSum;
    }
}

class Point {
    private int x;
    private int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return this.x;
    }

    int getY() {
        return this.y;
    }

    double distance(Point point) {
        int x = Math.abs(this.getX() - point.getX());
        int y = Math.abs(this.getY() - point.getY());
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", this.getX(), this.getY());
    }
}
