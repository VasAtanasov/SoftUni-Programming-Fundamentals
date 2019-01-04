package L18ObjectsAndClassesExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Ex02AdvertisementMessage {
    private static String[] phrases = {"Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.", "Exceptional product.", "I can’t live without this product."};
    private static String[] events = {"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"};
    private static String[] authors = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
    private static String[] cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            StringBuilder message = new StringBuilder();
            message.append(phrases[random.nextInt(phrases.length)])
                    .append(" ")
                    .append(events[random.nextInt(events.length)])
                    .append(" ")
                    .append(authors[random.nextInt(authors.length)])
                    .append(" - ")
                    .append(cities[random.nextInt(cities.length)]);
            System.out.println(message.toString());

        }

    }
}
