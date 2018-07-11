package Z_Exams.exam25Apr2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Ex02MemoryView {
    private static BufferedReader reader;
    private static String memory;


    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        receiveInput();

        Arrays.stream( memory.replaceAll("32656 19759 32763 0 [0-9]+ 0 ", "").split("\\s+0"))
                .filter(e -> ! e.isEmpty())
                .map(String::trim)
                .filter(e -> ! e.equals("0"))
                .map(s -> mapString(s.split("\\s+")))
                .forEach(System.out::println);
    }

    private static String mapString(String[] string) {
        return Arrays.stream(string)
                .mapToInt(Integer::parseInt)
                .mapToObj(s -> String.format("%c", s))
                .collect(Collectors.joining(""));
    }

    private static void receiveInput() throws IOException {
        StringBuilder wholeInput = new StringBuilder();
        String input;
        while (! "Visual Studio crash".equals(input = reader.readLine())) {
            wholeInput.append(input).append(" ");
        }
        memory = wholeInput.toString().trim();
    }
}