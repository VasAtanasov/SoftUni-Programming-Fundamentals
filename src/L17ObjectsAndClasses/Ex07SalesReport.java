package L17ObjectsAndClasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ex07SalesReport {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Sale saleReport = new Sale();
        int lines = Integer.parseInt(reader.readLine());
        for (int i = 0; i < lines; i++) {
            saleReport.readSale(reader.readLine());
        }
        System.out.println(saleReport);

    }
}

class Sale {
    private Map<String, Town> towns;

    Sale() {
        this.towns = new TreeMap<>();
    }

    void readSale(String input) {
        String[] tokens = input.split("\\s+");
        String town = tokens[0];
        String product = tokens[1];
        double price = Double.parseDouble(tokens[2]);
        double quantity = Double.parseDouble(tokens[3]);

        this.towns.putIfAbsent(town, new Town(town));
        this.towns.get(town).addProduct(new Product(product, price, quantity));
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        towns.values().forEach(town -> output.append(town).append(System.lineSeparator()));
        return output.toString();
    }
}

class Town {
    private String name;
    private List<Product> products;

    Town(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    void addProduct(Product product) {
        this.products.add(product);
    }

    private double getGrantTotal() {
        return this.products.stream()
                .mapToDouble(Product::getTotalPrice)
                .sum();
    }

    @Override
    public String toString() {
        return String.format("%s -> %.2f", this.name, this.getGrantTotal());
    }
}

class Product {
    private String name;
    private double price;
    private double quantity;

    Product(String name, double price, double quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    double getTotalPrice() {
        return quantity * price;
    }
}
