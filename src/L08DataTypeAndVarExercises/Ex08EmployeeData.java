package L08DataTypeAndVarExercises;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class Ex08EmployeeData {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstName = reader.readLine();
        String lastName = reader.readLine();
        String age = reader.readLine();
        String gender = reader.readLine();
        String id = reader.readLine();
        String number = reader.readLine();

        System.out.println(String.format("First name: %s",firstName));
        System.out.println(String.format("Last name: %s",lastName));
        System.out.println(String.format("Age: %s",age));
        System.out.println(String.format("Gender: %s",gender));
        System.out.println(String.format("Personal ID: %s",id));
        System.out.println(String.format("Unique Employee number: %s",number));
    }
}
