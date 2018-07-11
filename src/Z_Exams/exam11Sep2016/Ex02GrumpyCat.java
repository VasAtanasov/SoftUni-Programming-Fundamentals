package Z_Exams.exam11Sep2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex02GrumpyCat {
    private static long[] numbres;
    private static int entryPoint;
    private static String itemType;
    private static String priceRatingType;
    private static BufferedReader reader;
    private static long priceRatingSearched;
    private static long leftSum;
    private static long rightSum;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        receiveInput();
        getLeftSum();
        getRightSum();

        if (leftSum >= rightSum) {
            System.out.println(String.format("Left - %d", leftSum));
        } else {
            System.out.println(String.format("Right - %d", rightSum));
        }

    }

    private static void getRightSum() {
        for (int i = 0; i < entryPoint; i++) {
            if (isValidPriceRating(numbres[i]) && isValidType(numbres[i])) {
                leftSum += numbres[i];
            }
        }
    }

    private static void getLeftSum() {
        for (int i = numbres.length - 1; i > entryPoint; i--) {
            if (isValidPriceRating(numbres[i]) && isValidType(numbres[i])) {
                rightSum += numbres[i];
            }
        }
    }

    private static boolean isValidPriceRating(long priceRating) {
        if ("positive".equals(priceRatingType) && priceRating >= 0) {
            return true;
        } else if ("negative".equals(priceRatingType) && priceRating < 0) {
            return true;
        } else if ("all".equals(priceRatingType)) {
            return true;
        }
        return false;
    }

    private static boolean isValidType(long priceRating) {
        if ("cheap".equals(itemType) && priceRating < priceRatingSearched) {
            return true;
        } else if ("expensive".equals(itemType) && priceRating >= priceRatingSearched) {
            return true;
        }
        return false;
    }

    private static void receiveInput() throws IOException {
        numbres = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToLong(Long::valueOf)
                .toArray();
        entryPoint = Integer.parseInt(reader.readLine());
        priceRatingSearched = numbres[entryPoint];
        itemType = reader.readLine();
        priceRatingType = reader.readLine();
    }
}
