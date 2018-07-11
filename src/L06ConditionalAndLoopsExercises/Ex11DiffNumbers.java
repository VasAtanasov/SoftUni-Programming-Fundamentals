package L06ConditionalAndLoopsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex11DiffNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int start = Integer.parseInt(reader.readLine());
        int end = Integer.parseInt(reader.readLine());
        boolean isFound = false;

        for (int n1 = start; n1 <= end; n1++) {
            for (int n2 = start; n2 <= end; n2++) {
                for (int n3 = start; n3 <= end; n3++) {
                    for (int n4 = start; n4 <= end; n4++) {
                        for (int n5 = start; n5 <= end; n5++) {
                            if (n1 < n2 && n2 < n3 && n3 < n4 && n4 < n5) {
                                System.out.println(String.format("%d %d %d %d %d", n1, n2, n3, n4, n5));
                                isFound = true;
                            }
                        }
                    }
                }
            }
        }

        if (!isFound) {
            System.out.println("No");
        }
    }
}
