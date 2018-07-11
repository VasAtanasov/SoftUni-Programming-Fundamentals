package L17ObjectsAndClasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex04_05Points {
    //    EX05
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            String input = reader.readLine();
            int x = Integer.parseInt(input.split("\\s+")[0]);
            int y = Integer.parseInt(input.split("\\s+")[1]);
            Point point = new Point(x, y);
            points[i] = point;
        }

        Point bestPoint = points[0];
        Point otherPoint = points[1];
        double distance = bestPoint.distance(otherPoint);

        for (int i = 0; i < points.length; i++) {
            Point pOne = points[i];
            for (int j = i + 1; j < points.length; j++) {
                Point pTwo = points[j];
                if (pOne.distance(pTwo) < distance) {
                    bestPoint = pOne;
                    otherPoint = pTwo;
                    distance = pOne.distance(pTwo);
                }
            }
        }

        System.out.println(String.format("%.3f",distance));
        System.out.println(bestPoint);
        System.out.println(otherPoint);


    }

//    EX 04
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String lineOne = reader.readLine();
//        String lineTow = reader.readLine();
//
//        int x1 = Integer.parseInt(lineOne.split("\\s+")[0]);
//        int y1 = Integer.parseInt(lineOne.split("\\s+")[1]);
//
//        int x2 = Integer.parseInt(lineTow.split("\\s+")[0]);
//        int y2 = Integer.parseInt(lineTow.split("\\s+")[1]);
//
//        Point pointOne = new Point(x1, y1);
//        Point pointTwo = new Point(x2, y2);
//
//        System.out.println(String.format("%.3f",pointOne.distance(pointTwo)));
//    }
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
        return String.format("(%d, %d)",this.getX(),this.getY());
    }
}