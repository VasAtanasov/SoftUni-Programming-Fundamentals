package L18ObjectsAndClassesExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ex05_06BookLibrary {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Library library = new Library();
        int count = Integer.parseInt(reader.readLine());
        for (int i = 0; i < count; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            String title = tokens[0];
            String author = tokens[1];
            String publisher = tokens[2];
            String releaseDate = tokens[3];
            String ISBN = tokens[4];
            double price = Double.parseDouble(tokens[5]);
            library.registerBook(new Book(title, author, publisher, releaseDate, ISBN, price));
        }
        //Ex 05
//        System.out.println(library.getStatsByAuthor());

        //Ex 06
        LocalDate date = LocalDate.parse(reader.readLine(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        System.out.println(library.getStatsByDate(date));
    }
}

class Library {
    private List<Book> books;

    Library() {
        this.books = new ArrayList<>();
    }

    void registerBook(Book book) {
        this.books.add(book);
    }

    String getStatsByDate(LocalDate date) {
        StringBuilder output = new StringBuilder();
        Map<LocalDate, List<Book>> dates = books.stream().collect(Collectors.groupingBy(Book::getReleaseDate));
        dates.entrySet().stream()
                .flatMap(b -> b.getValue().stream())
                .filter(d -> d.getReleaseDate().compareTo(date) > 0)
                .sorted(getBookComparator())
                .forEach(b -> output.append(String.format("%s -> %s%n", b.getTitle(), b.getReleaseDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")))));
        return output.toString();
    }

    private Comparator<Book> getBookComparator() {
        return (a, b) -> {
            int index = a.getReleaseDate().compareTo(b.getReleaseDate());
            return index != 0 ? index : a.getTitle().compareToIgnoreCase(b.getTitle());
        };
    }

    String getStatsByAuthor() {
        StringBuilder output = new StringBuilder();
        Map<String, List<Book>> authors = books.stream().collect(Collectors.groupingBy(Book::getAuthor));
        authors.entrySet().stream()
                .sorted(getEntryComparator())
                .forEach(a -> {
                    output.append(String.format("%s -> %.2f%n", a.getKey(), a.getValue().stream().mapToDouble(Book::getPrice).sum()));
                });
        return output.toString();
    }

    private Comparator<Map.Entry<String, List<Book>>> getEntryComparator() {
        return (a, b) -> {
            double authorA = a.getValue().stream().mapToDouble(Book::getPrice).sum();
            double authorB = b.getValue().stream().mapToDouble(Book::getPrice).sum();
            int index = Double.compare(authorB, authorA);
            return index != 0 ? index : a.getKey().compareToIgnoreCase(b.getKey());
        };
    }

}

class Book {
    private String title;
    private String author;
    private String publisher;
    private LocalDate releaseDate;
    private String ISBN;
    private double price;

    Book(String title,
         String author,
         String publisher,
         String releaseDate,
         String ISBN,
         double price) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.releaseDate = LocalDate.parse(releaseDate, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        this.ISBN = ISBN;
        this.price = price;
    }


    String getAuthor() {
        return this.author;
    }

    double getPrice() {
        return this.price;
    }

    LocalDate getReleaseDate() {
        return this.releaseDate;
    }

    String getTitle() {
        return this.title;
    }
}