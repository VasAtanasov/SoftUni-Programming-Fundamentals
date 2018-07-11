package Z_ExamsExtendet.exam20Aug2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex04Trainegram {
    private static BufferedReader reader;
    private static final String REGEX;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        REGEX = "^(?<locomotive><\\[[^A-Za-z0-9\\n]*?]\\.)(?<wagon>\\.\\[[A-Za-z0-9]*?]\\.)*$";
    }

    public static void main(String[] args) throws IOException {
        String train;
        while (!"Traincode!".equals(train = reader.readLine())) {
            if (train.matches(REGEX)) {
                System.out.println(train);
            }
        }
    }
}
