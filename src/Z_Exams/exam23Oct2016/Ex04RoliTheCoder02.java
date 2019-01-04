package Z_Exams.exam23Oct2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;

public class Ex04RoliTheCoder02 { //90/100 last test not passing
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        LinkedHashMap<Integer, String> eventsById = new LinkedHashMap<>();
        LinkedHashMap<String, List<String>> organizer = new LinkedHashMap<>();

        while (! "Time for Code".equals(input)) {
            if (input.contains("#")) {
                List<String> eventInfo = Arrays.stream(input.split("[\\s#]+"))
                        .filter(e -> ! e.equals("")).collect(Collectors.toCollection(ArrayList::new));

                int id = Integer.valueOf(eventInfo.get(0));
                String eventName = eventInfo.get(1);

                List<String> participants = new ArrayList<>();

                for (int i = 2; i < eventInfo.size(); i++) {
                    participants.add(eventInfo.get(i));
                }
                if (! eventsById.containsKey(id)) {
                    eventsById.put(id, eventName);
                    organizer.put(eventName, participants);
                } else if (eventsById.get(id).equals(eventName)) {
                    organizer.get(eventName).addAll(participants);
                }
            }

            input = reader.readLine();
        }

        organizer.entrySet().stream()
                .sorted((a, b) -> {
                    int index = Long.compare(b.getValue().stream().distinct().count(),
                            a.getValue().stream().distinct().count());
                    if (index == 0) {
                        index = lowerBeforeUpperCaseSort.compare(a.getKey(), b.getKey());
                    }
                    return index;
                })
                .forEach(event -> {
                    System.out.println(String.format("%s - %d", event.getKey(), event.getValue().stream().distinct().count()));
                    event.getValue().stream().distinct()
                            .sorted(lowerBeforeUpperCaseSort)
                            .forEach(s -> System.out.println(String.format("%s", s)));
                });


    }

    private static Comparator<String> lowerBeforeUpperCaseSort = new Comparator<String>() {
        Collator myCollator = Collator.getInstance();

        @Override
        public int compare(String o1, String o2) {
            return myCollator.compare(o1, o2);
        }
    };
}
