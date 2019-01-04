package L12ArraysMoreExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex07InventoryMatcher01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] productName = reader.readLine().split("\\s+");
        String[] quantity = reader.readLine().split("\\s+");
        String[] price = reader.readLine().split("\\s+");

        String input;
        while (! "done".equals(input = reader.readLine())) {
            int i = getIndex(productName, input);
            System.out.println(String.format("%s costs: %s; Available quantity: %s", productName[i], price[i], quantity[i]));
        }

    }

    private static int getIndex(String[] productName, String product) {
        for (int i = 0; i < productName.length; i++) {
            if (productName[i].equals(product)) {
                return i;
            }
        }
        return - 1;
    }
}
