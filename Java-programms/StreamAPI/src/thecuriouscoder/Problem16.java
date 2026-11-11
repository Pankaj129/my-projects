package thecuriouscoder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem16 {


    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(3, 4, 5, 6);

        List<Integer> commonList = list2.stream().filter(a->list1.contains(a)).collect(Collectors.toList());

        System.out.println(commonList);
    }
}