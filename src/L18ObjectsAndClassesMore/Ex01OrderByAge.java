package L18ObjectsAndClassesMore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Ex01OrderByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Person> people = new ArrayList<>();
        String input;
        while (! "End".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");
            people.add(new Person(tokens[0], tokens[1], Integer.parseInt(tokens[2])));
        }

        people.stream()
                .sorted()
                .forEach(System.out::println);
    }
}

class Person implements Comparable<Person> {
    private String name;
    private String ID;
    private int age;

    Person(String name, String ID, int age) {
        this.name = name;
        this.ID = ID;
        this.age = age;
    }

    String getName() {
        return this.name;
    }

    private String getID() {
        return this.ID;
    }

    private int getAge() {
        return this.age;
    }

    @Override
    public int compareTo(Person otherPerson) {
        return Integer.compare(this.getAge(), otherPerson.getAge());
    }

    @Override
    public String toString() {
        return String.format("%s with ID: %s is %d years old.", this.getName(), this.getID(), this.getAge());
    }
}
