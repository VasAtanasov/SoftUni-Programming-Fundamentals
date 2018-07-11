package L18ObjectsAndClassesMore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex07PlayCatch { // last test not passing
    private static int[] numbers;
    private static BufferedReader reader;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int exceptionsCount = 0;

        while (exceptionsCount < 3) {
            String[] tokens = reader.readLine().split("\\s+");
            String command = tokens[0];
            int index;

            switch (command) {
                case "Show":
                    if (isValidFormat(tokens[1])) {
                        index = Integer.parseInt(tokens[1]);
                    } else {
                        System.out.println("The variable is not in the correct format!");
                        exceptionsCount++;
                        continue;
                    }
                    if (! isInRange(index)) {
                        System.out.println("The index does not exist!");
                        exceptionsCount++;
                        continue;
                    }
                    System.out.println(numbers[index]);
                    break;
                case "Print":
                    int endIndex;
                    if (isValidFormat(tokens[1]) && isValidFormat(tokens[2])) {
                        index = Integer.parseInt(tokens[1]);
                        endIndex = Integer.parseInt(tokens[2]);
                    } else {
                        System.out.println("The variable is not in the correct format!");
                        exceptionsCount++;
                        continue;
                    }

                    if (! isInRange(index)) {
                        System.out.println("The index does not exist!");
                        exceptionsCount++;
                        continue;
                    }
                    if (! isInRange(endIndex)) {
                        System.out.println("The index does not exist!");
                        exceptionsCount++;
                        continue;
                    }

                    if (index > endIndex) {
                        continue;
                    }

                    System.out.println(printRange(index, endIndex));
                    break;
                case "Replace":
                    int element;
                    if (isValidFormat(tokens[1]) && isValidFormat(tokens[2])) {
                        index = Integer.parseInt(tokens[1]);
                        element = Integer.parseInt(tokens[2]);
                    } else {
                        System.out.println("The variable is not in the correct format!");
                        exceptionsCount++;
                        continue;
                    }

                    if (! isInRange(index)) {
                        System.out.println("The index does not exist!");
                        exceptionsCount++;
                        continue;
                    }
                    numbers[index] = element;
                    break;
            }


        }


        System.out.println(Arrays.toString(numbers).replace("[", "").replace("]", ""));

    }

    private static String printRange(int index, int endIndex) {
        StringBuilder output = new StringBuilder();
        for (int i = index; i <= endIndex; i++) {
            output.append(numbers[i]);
            if (i < endIndex) {
                output.append(", ");
            }
        }
        return output.toString();
    }

    private static boolean isInRange(int index) {
        return index >= 0 && index < numbers.length;
    }

//    private static boolean isValidFormat(String token) {
//        for (int i = 0; i < token.length(); i++) {
//            if (! Character.isDigit(token.charAt(i))) {
//                return false;
//            }
//        }
//        return true;
//    }

    private static boolean isValidFormat(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }


}
