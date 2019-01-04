package L16DictionariesExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Ex08LogsAggregator01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(reader.readLine());
        TreeMap<String, TreeMap<String, Integer>> data = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            String name = tokens[1];
            String ip = tokens[0];
            int duration = Integer.valueOf(tokens[2]);


            data.putIfAbsent(name, new TreeMap<>());
            data.get(name).putIfAbsent(ip, 0);

            int totalDuration = data.get(name).get(ip) + duration;
            data.get(name).put(ip,totalDuration);
        }

        data.forEach((key,value) ->{
            int sum = value.values().stream().mapToInt(Integer::valueOf).sum();
            System.out.println(String.format("%s: %d %s",key,sum,value.keySet()));
        });


    }
}