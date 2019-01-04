package L06ConditionalAndLoopsMore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex07TrainingHallEquipment {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double budget = Double.parseDouble(reader.readLine());
        int itemsCount = Integer.parseInt(reader.readLine());
        double subTotal = 0;

        for (int i = 0; i < itemsCount; i++) {
            String itemName = reader.readLine();
            double itemPrice = Double.parseDouble(reader.readLine());
            int count = Integer.parseInt(reader.readLine());
            subTotal += (count * itemPrice);
            itemName = count > 1 ? itemName + "s" : itemName;
            System.out.println(String.format("Adding %d %s to cart.", count, itemName));
        }

        System.out.println(String.format("Subtotal: $%.2f", subTotal));

        double diff = budget - subTotal;

        if (diff >= 0) {
            System.out.println(String.format("Money left: $%.2f", diff));
        } else {
            System.out.println(String.format("Not enough. We need $%.2f more.", Math.abs(diff)));
        }

    }
}
