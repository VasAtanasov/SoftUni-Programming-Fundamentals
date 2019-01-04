package L04IntroAndSyntaxExercises;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.text.DecimalFormat;

public class Ex04BeverageLabels {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        int volume = Integer.parseInt(reader.readLine());
        double kcal = Integer.parseInt(reader.readLine()) * (volume / 100.0);
        double sugar = Integer.parseInt(reader.readLine()) * (volume / 100.0);
        DecimalFormat df = new DecimalFormat("0.#######");

        System.out.println(String.format("%dml %s:", volume, name));
        System.out.println(String.format("%skcal, %sg sugars", df.format(kcal), df.format(sugar)));
    }
}
