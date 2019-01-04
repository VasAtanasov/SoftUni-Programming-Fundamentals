package Z_ExamPreparation.ExamPreparation02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Ex02LadyBugs {
    private static int[] field;
    private static BufferedReader reader;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(reader.readLine());
        field = new int[size];
        placeBugs();

        String input;
        while (! "end".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");
            int ladyBugIndex = Integer.parseInt(tokens[0]);

            if (! isInRange(ladyBugIndex) || field[ladyBugIndex] == 0) {
                continue;
            }

            String direction = tokens[1];
            int flyLength = Integer.parseInt(tokens[2]);
            flyLength = direction.equals("right") ? flyLength : flyLength * (- 1);

            bugFly(flyLength, ladyBugIndex);
        }

        System.out.println(Arrays.stream(field)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));

    }

    private static void bugFly(int flyLength, int ladyBugIndex) {
        int nextIndex = ladyBugIndex + flyLength;
        field[ladyBugIndex] = 0;

        while (true) {
            if (! isInRange(nextIndex)) {
                break;
            }

            if (field[nextIndex] == 0) {
                field[nextIndex] = 1;
                break;
            } else {
                nextIndex += flyLength;
            }
        }
    }

    private static boolean isInRange(int index) {
        return index >= 0 && index < field.length;
    }

    private static void placeBugs() throws IOException {
        int[] bugsIndex = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .filter(value -> value >= 0)
                .filter(value -> value < field.length)
                .toArray();
        for (int index : bugsIndex) {
            field[index] = 1;
        }
    }


}
