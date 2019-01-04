package L09MethodsAndDebugging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Ex06CalculateTriangleArea {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BigDecimal width = new BigDecimal(reader.readLine());
        BigDecimal height = new BigDecimal(reader.readLine());
        BigDecimal area = getTriangleArea(width, height);
        System.out.println(area);
    }

    private static BigDecimal getTriangleArea(BigDecimal width, BigDecimal height) {
        return (width.multiply(height)).divide(BigDecimal.valueOf(2));
    }
}
