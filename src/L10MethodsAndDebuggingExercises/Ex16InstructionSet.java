package L10MethodsAndDebuggingExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex16InstructionSet {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while (! "END".equals(input = reader.readLine())) {
            String[] codeArgs = input.split("\\s+");
            long result = 0;
            switch (codeArgs[0]) {
                case "INC": {
                    long operandOne = Long.parseLong(codeArgs[1]);
                    result = ++operandOne;
                    break;
                }
                case "DEC": {
                    long operandOne = Long.parseLong(codeArgs[1]);
                    result = --operandOne;
                    break;
                }
                case "ADD": {
                    long operandOne = Long.parseLong(codeArgs[1]);
                    long operandTwo = Long.parseLong(codeArgs[2]);
                    result = operandOne + operandTwo;
                    break;
                }
                case "MLA": {
                    long operandOne = Long.parseLong(codeArgs[1]);
                    long operandTwo = Long.parseLong(codeArgs[2]);
                    result = operandOne * operandTwo;
                    break;
                }
            }

            System.out.println(result);
        }
    }
}
