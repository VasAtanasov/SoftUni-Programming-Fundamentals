package L12ArraysMoreExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex05PizzaIngredients01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] ingredients = reader.readLine().split("\\s+");
        int length = Integer.parseInt(reader.readLine());
        String[] addedToppings = new String[10];
        int index = 0;

        for (int i = 0; i < ingredients.length; i++) {
            String ingredient = ingredients[i];
            if (ingredient.length() == length && index < 10) {
                addedToppings[index++] = ingredient;
                System.out.println(String.format("Adding %s.", ingredient));
            }

            if (index == 10) {
                break;
            }
        }

        System.out.println(String.format("Made pizza with total of %d ingredients.", index));
        System.out.println(String.format("The ingredients are: %s.", String.join(", ", getStingArray(addedToppings, index))));

    }

    private static String[] getStingArray(String[] addedToppings, int index) {
        String[] output = new String[index];
        for (int i = 0; i < index; i++) {
            output[i] = addedToppings[i];
        }
        return output;
    }
}
