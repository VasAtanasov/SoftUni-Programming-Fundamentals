package Z_Exams.exam09Jul2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex03RegexMon {
    private static BufferedReader reader;
    private static final String DIDI_REGEX;
    private static final String BOJO_REGEX;
    private static Pattern didiPattern;
    private static Pattern bojoPattern;
    private static String string;
    private static boolean didiTurn = true;
    private static boolean bojoTurn = false;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        DIDI_REGEX = "[^A-Za-z-]+";
        BOJO_REGEX = "[A-Za-z]+-[A-Za-z]+";
        didiPattern = Pattern.compile(DIDI_REGEX);
        bojoPattern = Pattern.compile(BOJO_REGEX);
    }

    public static void main(String[] args) throws IOException {
        string = reader.readLine();

        while (string.length() > 0) {
            Matcher didiMatcher = didiPattern.matcher(string);
            Matcher bojoMatcher = bojoPattern.matcher(string);
            String match;
            if (didiMatcher.find() && didiTurn) {
                match = getMatch(didiMatcher.group());
                didiTurn = false;
                bojoTurn = true;
            } else if (bojoMatcher.find() && bojoTurn) {
                match = getMatch(bojoMatcher.group());
                didiTurn = true;
                bojoTurn = false;
            } else {
                break;
            }

            System.out.println(match);
        }
    }

    private static String getMatch(String match) {
        int index = string.indexOf(match) + match.length();
        string = string.substring(index);
        return match;
    }
}
