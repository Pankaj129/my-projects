package stream;

import java.util.Arrays;
import java.util.List;

public class Problem30 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("abc", "ghi", "xyz");

        List<String> upperList = list.stream().map(String::toUpperCase).toList();
        System.out.println(upperList);
    }
}
