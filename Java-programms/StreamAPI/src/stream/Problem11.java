package stream;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem11 {
    public static void main(String[] args) {
        //Given a string, find the first non-repeated character || Most Asked

        String str = "payment success payment failed payment";

        String s = Arrays.stream(str.split(""))
                .filter(a -> str.indexOf(a) == str.lastIndexOf(a)).findFirst().get();


        System.out.println("First occurrence "+s);

        Map<Character, Long> collect = str.chars().mapToObj(a -> (char) a).
                collect(Collectors.groupingBy(a -> a, LinkedHashMap::new,Collectors.counting()));

        Character c = collect.entrySet().stream()
                .filter(a -> a.getValue() == 1)
                .map(a -> a.getKey())
                .findFirst()
                .get();

        System.out.println("First occurrence "+c);

    }
}
