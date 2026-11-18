package stream;

import java.util.Arrays;
import java.util.List;

public class Problem23 {
    public static void main(String[] args) {
        // Sort a list of strings in alphabetical order || Most Asked

        List<String> strList = Arrays.asList("Zudio", "Puma", "Addidas", "Ajio", "Inorbit");

        List<String> sortedList = strList.stream().sorted().toList();

        System.out.println(sortedList);
    }
}
