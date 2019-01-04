package L12ArraysMoreExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex07InventoryMatcher {
    static class Product{
        private String product;
        private BigInteger quantity;
        private String price;

        public Product(String product, BigInteger quantity, String price) {
            this.product = product;
            this.quantity = quantity;
            this.price = price;
        }

        public String getProduct() {
            return product;
        }

        @Override
        public String toString() {
            return String.format("%s costs: %s; Available quantity: %d",
                    this.product,this.price,this.quantity);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputArrayReader arrayReader = new InputArrayReader();
        List<Product> inventory = new ArrayList<>();

        arrayReader.readStringList(reader.readLine(),"\\s+");
        List<String> products = new ArrayList<>(arrayReader.getStringList());

        arrayReader.readBigIntList(reader.readLine(),"\\s+");
        List<BigInteger> quantities = new ArrayList<>(arrayReader.getBigIntNumbers());

        arrayReader.readStringList(reader.readLine(),"\\s+");
        List<String> prices = new ArrayList<>(arrayReader.getStringList());

        updateInventory(inventory, products, quantities, prices);
        searchProducts(reader, inventory);


    }

    private static void searchProducts(BufferedReader reader, List<Product> inventory) throws IOException {
        while (true) {
            String searchedProduct = reader.readLine();
            if ("done".equals(searchedProduct)) {
                break;
            }
            for (Product product : inventory) {
                if (product.getProduct().equals(searchedProduct)) {
                    System.out.println(product.toString());
                    break;
                }
            }
        }
    }

    private static void updateInventory(List<Product> inventory, List<String> products, List<BigInteger> quantities, List<String> prices) {
        int n = products.size();
        for (int i = 0; i < n; i++) {
            String productName = products.get(i);
            BigInteger quantity = quantities.get(i);
            String price = prices.get(i);
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
        }  /* read and split list of Long */

        /* read and split list of BigIntegers */
        public void readBigIntList(String input, String splitRegex) throws IOException {
            this.bigIntNumbers = Arrays.stream(input.split(splitRegex)).map(BigInteger::new)
                    .collect(Collectors.toCollection(ArrayList::new));
        }

        public List<BigInteger> getBigIntNumbers() {
            return bigIntNumbers;
        }  /* read and split list of Long */


    }
}
