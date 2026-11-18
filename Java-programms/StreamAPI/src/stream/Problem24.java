package stream;

import java.util.Arrays;
import java.util.List;

public class Problem24 {
    public static void main(String[] args) {
        //Convert a list of integers to a list of their squares || Most Asked

        List<Integer> intArr = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        List<Integer> sqrList = intArr.stream().map(x -> x * x).toList();

        System.out.println(sqrList);
    }
}
