package L08DataTypeAndVarExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Ex04VarInHex {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println(new BigInteger(reader.readLine().toUpperCase().replace("X",""), 16)); // working also

        String hexagon = reader.readLine();
        int dec = Integer.parseUnsignedInt(hexagon.substring(2), 16);
        System.out.print(dec);
    }
}
