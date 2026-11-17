package stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Problem16 {
    public static void main(String[] args) {
        //Group /Pair anagrams from a list of Strings

        String[] str = {"pat", "tap", "pan", "nap", "team", "tree", "meat"};

        Collection<List<String>> collect = Arrays.stream(str)
                .collect(Collectors.groupingBy(x -> Arrays.stream(x.toLowerCase().split("")).sorted().toList())).values();

        System.out.println(collect);
    }
}
