package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem21 {

    public static void main(String[] args) {
        // Given the string[] group the strings based on the middle character

        String[] str = {"ewe", "jji", "jhj", "kwk", "aha"};

        Map<Character, List<String>> middleChar = Arrays.stream(str).collect(Collectors.groupingBy(x -> x.charAt(1), Collectors.toList()));

        System.out.println(middleChar);


    }
}
