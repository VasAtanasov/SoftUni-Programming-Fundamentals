package Z_Exams.exam11Sep2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex02GrumpyCat01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Long> priceRantings = Arrays.stream(reader.readLine().split("\\s+")).map(Long::valueOf)
                .collect(Collectors.toCollection(ArrayList::new));

        int entryPoint = Integer.valueOf(reader.readLine());
        long priceRating = priceRantings.get(entryPoint);
        String itemType = reader.readLine();
        String priceRatingType = reader.readLine();

        List<Long> left = getLeftSide(priceRantings, entryPoint);
        List<Long> right = getRightSide(priceRantings, entryPoint);

        left = filterByType(left, itemType, priceRating);
        right = filterByType(right, itemType, priceRating);

        left = filterByPriceRatingType(left, priceRatingType);
        right = filterByPriceRatingType(right, priceRatingType);

        long sumLeft = left.stream().mapToLong(Long::valueOf).sum();
        long sumRight = right.stream().mapToLong(Long::valueOf).sum();

        if (sumLeft >= sumRight) {
            System.out.println(String.format("Left - %d", sumLeft));
        } else {
            System.out.println(String.format("Right - %d", sumRight));
        }

    }

    private static List<Long> filterByPriceRatingType(List<Long> array, String priceRatingType) {
        List<Long> filtered = new ArrayList<>();
        switch (priceRatingType) {
            case "positive":
                filtered = array.stream().filter(e -> e >= 0).collect(Collectors.toCollection(ArrayList::new));
                break;
            case "negative":
                filtered = array.stream().filter(e -> e < 0).collect(Collectors.toCollection(ArrayList::new));
                break;
            default:
                return array;
        }
        return filtered;

    }

    private static List<Long> filterByType(List<Long> array, String itemType, long priceRating) {
        List<Long> filtered = new ArrayList<>();
        switch (itemType) {
            case "cheap":
                filtered = array.stream().filter(e -> e < priceRating).collect(Collectors.toCollection(ArrayList::new));
                break;
            case "expensive":
                filtered = array.stream().filter(e -> e >= priceRating).collect(Collectors.toCollection(ArrayList::new));
                break;
        }
        return filtered;
    }

    private static List<Long> getRightSide(List<Long> priceRantings, int entryPoint) {
        return priceRantings.stream().skip(entryPoint + 1).collect(Collectors.toCollection(ArrayList::new));
    }

    private static List<Long> getLeftSide(List<Long> priceRantings, int entryPoint) {
        return priceRantings.stream().limit(entryPoint).collect(Collectors.toCollection(ArrayList::new));
    }
}
