package L18ObjectsAndClassesExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Ex07AndreyAndBilliard {
    private static BufferedReader reader;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        setProducts();
        sellProducts();
        System.out.println(Bar.getBillString());

    }

    private static void sellProducts() throws IOException {
        String input;
        while (! "end of clients".equals(input = reader.readLine())) {
            String[] tokens = input.split("[-,]");
            String customer = tokens[0];
            String product = tokens[1];
            int quantity = Integer.parseInt(tokens[2]);

            Bar.sellProduct(customer, product, quantity);
        }
    }

    private static void setProducts() throws IOException {
        int lines = Integer.parseInt(reader.readLine());
        for (int i = 0; i < lines; i++) {
            String[] tokens = reader.readLine().split("-");
            String product = tokens[0];
            double price = Double.parseDouble(tokens[1]);

            Bar.setProduct(product, price);
        }
    }
}

class Bar {
    private static Map<String, Customer> customers;
    private static Map<String, Product> products;

    static {
        customers = new TreeMap<>();
        products = new LinkedHashMap<>();
    }

    private Bar() {

    }

    static void setProduct(String product, double price) {
        if (products.containsKey(product)) {
            products.get(product).setPrice(price);
        } else {
            products.put(product, new Product(product, price));
        }
    }

    private static void setCustomer(String customer) {
        customers.putIfAbsent(customer, new Customer(customer));
    }

    static void sellProduct(String customer, String product, int quantity) {
        if (products.containsKey(product)) {
            Bar.setCustomer(customer);
            customers.get(customer).buyProduct(products.get(product), quantity);
        }
    }

    static Map<String, Product> getProductsList() {
        return products;
    }

    private static double getTotalEarned() {
        return customers.values().stream()
                .mapToDouble(Customer::getMoneySpent)
                .sum();
    }

    static String getBillString() {
        StringBuilder output = new StringBuilder();
        customers.values().forEach(output::append);
        output.append(String.format("Total bill: %.2f", Bar.getTotalEarned()));
        return output.toString();
    }
}

class Customer {
    private String name;
    private Basket basket;

    Customer(String name) {
        this.name = name;
        this.basket = new Basket();
    }

    void buyProduct(Product product, int quantity) {
        this.basket.add(product.getName(), quantity);
    }

    double getMoneySpent() {
        return this.basket.getProducts().entrySet()
                .stream()
                .mapToDouble(p -> Bar.getProductsList().get(p.getKey()).getPrice() * p.getValue())
                .sum();
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("%s%n", this.name))
                .append(this.basket)
                .append(String.format("Bill: %.2f%n", this.getMoneySpent()));
        return output.toString();
    }
}

class Basket {
    private Map<String, Integer> products;

    Basket() {
        this.products = new LinkedHashMap<>();
    }

    void add(String product, int quantity) {
        this.products.putIfAbsent(product, 0);
        this.products.put(product, this.products.get(product) + quantity);
    }

    Map<String, Integer> getProducts() {
        return this.products;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        products.forEach((p, q) -> output.append(String.format("-- %s - %d%n", p, q)));
        return output.toString();
    }
}


class Product {
    private String name;
    private double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    void setPrice(double price) {
        this.price = price;
    }

    double getPrice() {
        return this.price;
    }

    String getName() {
        return this.name;
    }
}