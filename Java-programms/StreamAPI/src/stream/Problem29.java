package stream;

import java.util.Arrays;
import java.util.List;

public class Problem29 {
    public static void main(String[] args) {


        List<String> list = Arrays.asList("123", "abc", "xyz789", "87");

        List<String> onlyDigits0 = list.stream().filter(x -> x.matches("[0-9]+")).toList();

        List<String> onlyDigits = list.stream().filter(x -> x.matches("\\d+")).toList();

        System.out.println(onlyDigits);
    }
}
