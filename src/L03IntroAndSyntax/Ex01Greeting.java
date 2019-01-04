package L03IntroAndSyntax;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class Ex01Greeting {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(String.format("Hello, %s!", reader.readLine()));
    }
}
