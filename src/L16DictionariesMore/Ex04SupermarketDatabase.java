package L16DictionariesMore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Ex04SupermarketDatabase {
    private static Map<String, Product> products;

    static {
        products = new LinkedHashMap<>();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while (! "stocked".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");
            String product = tokens[0];
            double price = Double.parseDouble(tokens[1]);
            long quantity = Integer.parseInt(tokens[2]);

            products.putIfAbsent(product, new Product(product, price));
            products.get(product).updateQuantity(quantity);
            products.get(product).updatePrice(price);
        }


        products.values().forEach(System.out::println);
        System.out.println(generateFrom("-", 30));
        double grandTotal = products.values().stream().mapToDouble(Product::getTotalPrice).sum();
        System.out.println(String.format("Grand Total: $%.2f", grandTotal));

    }

    private static String generateFrom(String input, int times) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < times; i++) {
            builder.append(input);
        }
        return builder.toString();
    }
}

class Product {
    private String name;
    private double price;
    private long quantity;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantity = 0L;
    }

    private String getName() {
        return this.name;
    }

    private double getPrice() {
        return this.price;
    }

    private long getQuantity() {
        return this.quantity;
    }

    double getTotalPrice() {
        return this.getPrice() * this.getQuantity();
    }

    void updatePrice(double price) {
        this.price = price;
    }

    void updateQuantity(long quantity) {
        this.quantity += quantity;
    }

    @Override
    public String toString() {
        return String.format("%s: $%.2f * %d = $%.2f", this.getName(), this.getPrice(), this.getQuantity(), this.getTotalPrice());
    }
}
