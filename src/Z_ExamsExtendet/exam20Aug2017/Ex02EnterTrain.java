package Z_ExamsExtendet.exam20Aug2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Ex02EnterTrain {
    private static BufferedReader reader;
    private static int power;
    private static List<Integer> wagons;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        getInput();
        String input;
        while (! "All ofboard!".equals(input = reader.readLine())) {
            int wagon = Integer.parseInt(input);
            wagons.add(wagon);
            int sum = getSum();

            if (sum > power) {
                int average = sum / wagons.size();
                int index = getClosesByValue(average);
                wagons.remove(index);
            }
        }

        System.out.println(getResult());
    }

    private static String getResult() {
        StringBuilder output = new StringBuilder();
        for (int i = wagons.size() - 1; i >= 0; i--) {
            output.append(wagons.get(i)).append(" ");
        }
        output.append(power);
        return output.toString();
    }

    private static int getClosesByValue(int average) {
        int element = wagons.get(0);
        int diff = Math.abs(element - average);

        for (int i = 1; i < wagons.size(); i++) {
            int currentElement = wagons.get(i);
            int currentDiff = Math.abs(currentElement - average);
            if (currentDiff < diff) {
                element = currentElement;
                diff = currentDiff;
            }
        }

        return wagons.indexOf(element);
    }

    private static int getSum() {
        return wagons
                .stream()
                .mapToInt(Integer::valueOf)
                .sum();
    }

    private static void getInput() throws IOException {
        power = Integer.parseInt(reader.readLine());
        wagons = new ArrayList<>();
    }
}
