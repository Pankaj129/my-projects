package thecuriouscoder;

import java.util.Arrays;
import java.util.List;

public class Problem17 {

    public static void main(String[] args){
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(3, 4, 5, 6),
                Arrays.asList(7, 8, 1, 2),
                Arrays.asList(9, 10, 5, 6),
                Arrays.asList(11, 12, 7, 8)
        );

        List<Integer> singleList = listOfLists.stream().flatMap(List::stream).distinct().toList();
        System.out.println(singleList);
    }
}
