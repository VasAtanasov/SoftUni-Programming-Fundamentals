package L12ArraysMoreExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex08UpgradedMatcher {
    static class Product {
        private String product;
        private BigInteger quantity;
        private BigDecimal price;

        public Product(String product, BigInteger quantity, BigDecimal price) {
            this.product = product;
            this.quantity = quantity;
            this.price = price;
        }

        public void updateQuantity(BigInteger quantity) {
            this.quantity = this.quantity.subtract(quantity);
        }

        public String getProduct() {
            return product;
        }

        public BigInteger getQuantity() {
            return quantity;
        }

        public BigDecimal getPrice() {
            return price;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputArrayReader arrayReader = new InputArrayReader();
        List<Product> inventory = new ArrayList<>();

        arrayReader.readStringList(reader.readLine(), "\\s+");
        List<String> products = new ArrayList<>(arrayReader.getStringList());

        arrayReader.readBigIntList(reader.readLine(), "\\s+");
        List<BigInteger> quantities = new ArrayList<>(arrayReader.getBigIntNumbers());

        arrayReader.readBigDecimalList(reader.readLine(), "\\s+");
        List<BigDecimal> prices = new ArrayList<>(arrayReader.getBigDecimalsNumbers());

        updateInventory(inventory, products, quantities, prices);

        orderProducts(reader, inventory);


    }

    private static void orderProducts(BufferedReader reader, List<Product> inventory) throws IOException {
        while (true) {
            String input = reader.readLine();
            if ("done".equals(input)) {
                break;
            }
            String[] order = input.split("\\s+");

            String orderedProduct = order[0];
            BigInteger orderedQuantity = new BigInteger(order[1]);

            processOrder(inventory, orderedProduct, orderedQuantity);

        }
    }

    private static void processOrder(List<Product> inventory, String orderedProduct, BigInteger orderedQuantity) {
        for (Product product : inventory) {
            if (product.getProduct().equals(orderedProduct)) {

                if (product.getQuantity().compareTo(orderedQuantity) < 0 || product.getQuantity().equals(BigInteger.ZERO)) {
                    System.out.println(String.format("We do not have enough %s", orderedProduct));
                } else {
                    BigDecimal totalPrice = product.getPrice().multiply(new BigDecimal(orderedQuantity));
                    System.out.println(String.format("%s x %d costs %.2f", orderedProduct, orderedQuantity, totalPrice));
                    product.updateQuantity(orderedQuantity);

                }

            }
        }
    }

    private static void updateInventory(List<Product> inventory, List<String> products, List<BigInteger> quantities, List<BigDecimal> prices) {
        int n = products.size();
        for (int i = 0; i < n; i++) {
            String productName = products.get(i);
            BigDecimal price = prices.get(i);

            BigInteger quantity = BigInteger.ZERO;

            if (i < quantities.size()) {
                quantity = quantities.get(i);
            }

            Product product = new Product(productName, quantity, price);
            inventory.add(product);
        }
    }

    public static class InputArrayReader {
        private List<String> stringList;
        private List<Integer> intNumbers;
        private List<Long> longNumbers;
        private List<Double> doubleNumbers;
        private List<BigInteger> bigIntNumbers;
        private List<BigDecimal> bigDecimalsNumbers;

        /* read and split list of Strings */
        public void readStringList(String input, String splitRegex) {
            this.stringList = Arrays.stream(input.split(splitRegex))
                    .collect(Collectors.toCollection(ArrayList::new));
        }

        public List<String> getStringList() {
            return stringList;
        }

        /* read and split list of Integers */
        public void readIntList(String input, String splitRegex) throws IOException {
            this.intNumbers = Arrays.stream(input.split(splitRegex)).map(Integer::valueOf)
                    .collect(Collectors.toCollection(ArrayList::new));
        }

        public List<Integer> getIntNumbers() {
            return intNumbers;
        }

        /* read and split list of Longs */
        public void readLongList(String input, String splitRegex) throws IOException {
            this.longNumbers = Arrays.stream(input.split(splitRegex)).map(Long::valueOf)
                    .collect(Collectors.toCollection(ArrayList::new));
        }

        public List<Long> getLongNumbers() {
            return longNumbers;
        }

        /* read and split list of Doubles */
        public void readDoubleList(String input, String splitRegex) throws IOException {
            this.doubleNumbers = Arrays.stream(input.split(splitRegex)).map(Double::valueOf)
                    .collect(Collectors.toCollection(ArrayList::new));
        }

        public List<Double> getDoubleNumbers() {
            return doubleNumbers;

        }

        /* read and split list of BigIntegers */
        public void readBigIntList(String input, String splitRegex) throws IOException {
            this.bigIntNumbers = Arrays.stream(input.split(splitRegex)).map(BigInteger::new)
                    .collect(Collectors.toCollection(ArrayList::new));
        }

        public List<BigInteger> getBigIntNumbers() {
            return bigIntNumbers;
        }  /* read and split list of Long */

        /* read and split list of BigDecimals */
        public void readBigDecimalList(String input, String splitRegex) throws IOException {
            this.bigDecimalsNumbers = Arrays.stream(input.split(splitRegex)).map(BigDecimal::new)
                    .collect(Collectors.toCollection(ArrayList::new));
        }

        public List<BigDecimal> getBigDecimalsNumbers() {
            return bigDecimalsNumbers;
        }  /* read and split list of Long */

    }
}
