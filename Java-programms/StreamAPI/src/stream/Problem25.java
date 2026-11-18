package stream;

import java.util.Arrays;
import java.util.List;

public class Problem25 {
    public static void main(String[] args) {
        //Find and print the distinct odd numbers || Most Asked

        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 3, 9, 7, 7, 7);

        List<Integer> distinctOdd = integerList.stream().distinct().filter(x -> x % 2 != 0).toList();

        System.out.println(distinctOdd);

    }
}
