package stream;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem12 {

    public static void main(String[] args) {
        //Given a string, find the first repeated character || Most Asked

        String str = "payment success payment failed payment";

        Map<Character, Long> charsMap = str.chars().mapToObj(a -> (char) a)
                .collect(Collectors.groupingBy(a -> a, LinkedHashMap::new, Collectors.counting()));

        System.out.println(charsMap);

        Character repeatedChar = charsMap.entrySet().stream()
                .filter(a -> a.getValue() > 1)
                .map(a -> a.getKey())
                .findFirst()
                .get();

        System.out.println("repeated char : "+repeatedChar);
    }
}
