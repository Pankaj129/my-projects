package stream;

import java.util.Arrays;
import java.util.List;

public class Problem22 {
    public static void main(String[] args) {
        //Find the sum of all the elements in a list.
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        int sum = intList.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);
    }
}
