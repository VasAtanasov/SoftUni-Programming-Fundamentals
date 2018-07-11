package Z_ExamsExtendet.exam10Dec2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ex04RainAir {
    private static BufferedReader reader;
    private static Map<String, Customer> customers;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        customers = new LinkedHashMap<>();
    }

    public static void main(String[] args) throws IOException {
        String input;
        while (! "I believe I can fly!".equals(input = reader.readLine())) {
            if (input.contains("=")) {
                copyCustomerFlights(input);
            } else {
                processCustomersAndFlights(input);
            }
        }

        customers.values()
                .stream()
                .sorted()
                .forEach(System.out::println);

    }

    private static void copyCustomerFlights(String input) {
        String[] tokens = input.split(" = ");
        Customer customerOne = customers.get(tokens[0]);
        Customer customerTwo = customers.get(tokens[1]);

        customerOne.copyFlights(customerTwo.getFlights());
    }

    private static void processCustomersAndFlights(String input) {
        String[] tokens = input.split("\\s+");
        String customerName = tokens[0];
        customers.putIfAbsent(customerName, new Customer(customerName));

        Customer customer = customers.get(customerName);
        for (int i = 1; i < tokens.length; i++) {
            customer.add(Integer.parseInt(tokens[i]));
        }
    }
}

class Customer implements Comparable<Customer> {
    private String name;
    private List<Integer> flights;

    Customer(String name) {
        this.name = name;
        this.flights = new ArrayList<>();
    }

    String getName() {
        return this.name;
    }

    List<Integer> getFlights() {
        return this.flights;
    }

    void add(int flight) {
        this.flights.add(flight);
    }

    void copyFlights(List<Integer> flights) {
        this.flights.clear();
        this.flights.addAll(flights);
    }

    private int count() {
        return this.flights.size();
    }

    @Override
    public int compareTo(Customer other) {
        int index = Integer.compare(other.count(), this.count());
        return index != 0 ? index : this.getName().compareTo(other.getName());
    }

    @Override
    public String toString() {
        return String.format("#%s ::: %s", this.getName(),
                this.flights.stream()
                        .sorted()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", ")));
    }
}
