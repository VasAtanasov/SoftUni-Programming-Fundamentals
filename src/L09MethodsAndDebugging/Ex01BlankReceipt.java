package L09MethodsAndDebugging;

public class Ex01BlankReceipt {
    public static void main(String[] args) {
        header();
        body();
        footer();
    }

    private static void header() {
        System.out.println("CASH RECEIPT");
        System.out.println("------------------------------");
    }

    private static void body() {
        System.out.println("Charged to____________________");
        System.out.println("Received by___________________");
    }

    private static void footer() {
        System.out.println("------------------------------");
        System.out.println("© SoftUni");
    }
}
