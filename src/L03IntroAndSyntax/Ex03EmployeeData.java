package L03IntroAndSyntax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Ex03EmployeeData {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        DecimalFormat df = new DecimalFormat("00000000");
        System.out.println(String.format("Name: %s", reader.readLine()));
        System.out.println(String.format("Age: %d", Integer.parseInt(reader.readLine())));
        System.out.println(String.format("Employee ID: %s", df.format(Integer.parseInt(reader.readLine()))));
        System.out.println(String.format("Salary: %.2f", Double.parseDouble(reader.readLine())));
    }
}
