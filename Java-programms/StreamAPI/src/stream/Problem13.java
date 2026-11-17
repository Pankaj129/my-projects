package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Problem13 {

    public static void main(String[] args) {

        //Given an array of integers, group the numbers by the range || Most Asked

        String str = "payment success payment failed payment";

        int [] intArr = {2,3,10,19, 23, 47, 58, 63,64,75,79, 27, 32, 41};

        List<Integer> listInt = Arrays.stream(intArr).boxed().toList();

        Map<Integer, List<Integer>> intMap = listInt.stream()
                .collect(Collectors.groupingBy(a -> (a / 10 * 10), TreeMap::new, Collectors.toList()));

        System.out.println(intMap);

    }
}
