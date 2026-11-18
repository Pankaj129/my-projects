package stream;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Problem20 {
    public static void main(String[] args) {
        //In a given array of integers, return true if it contains distinct values
        int [] intArr = {0,1,5,8, 1};

        boolean nonDistinct = Arrays.stream(intArr).boxed()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet().stream()
                .noneMatch(x -> x.getValue() > 1);

        System.out.println(nonDistinct);




    }
}
