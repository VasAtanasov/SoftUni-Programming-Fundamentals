package L06ConditionalAndLoopsMore;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Ex04PhotoGallery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int photoNumbers = Integer.parseInt(scanner.nextLine());
        int day = Integer.parseInt(scanner.nextLine());
        int month = Integer.parseInt(scanner.nextLine());
        int year = Integer.parseInt(scanner.nextLine());
        int hours = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());
        BigDecimal photoSize = new BigDecimal(scanner.nextLine());
        int widthPhoto = Integer.parseInt(scanner.nextLine());
        int heightPhoto = Integer.parseInt(scanner.nextLine());

        DecimalFormat df = new DecimalFormat("00");
        String photoType = "";
        String unit = "";
        BigDecimal transformedSize = new BigDecimal("0");

        if (photoSize.compareTo(BigDecimal.valueOf(1000)) < 0) {
            transformedSize = photoSize;
            unit = "B";
        } else if (photoSize.compareTo(BigDecimal.valueOf(1000000)) < 0) {
            transformedSize = photoSize.divide(BigDecimal.valueOf(1000),1, RoundingMode.HALF_EVEN).stripTrailingZeros();
            unit = "KB";
        } else {
            transformedSize = photoSize.divide(BigDecimal.valueOf(1000000),1, RoundingMode.HALF_EVEN).stripTrailingZeros();
            unit = "MB";
        }


        if (widthPhoto < heightPhoto) {
            photoType = "portrait";
        } else if (widthPhoto > heightPhoto) {
            photoType = "landscape";
        } else {
            photoType = "square";
        }

        System.out.printf("Name: DSC_%s.jpg\n", String.format("%04d", photoNumbers));
        System.out.printf("Date Taken: %s/%s/%s %s:%s\n",
                df.format(day),
                df.format(month),
                df.format(year),
                df.format(hours),
                df.format(minutes));
        System.out.printf("Size: %s%s\n", transformedSize.toPlainString(), unit);
        System.out.printf("Resolution: %dx%d (%s) ",
                widthPhoto,
                heightPhoto,
                photoType);
    }
}
