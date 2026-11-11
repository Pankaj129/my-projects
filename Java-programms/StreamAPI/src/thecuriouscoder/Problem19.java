package thecuriouscoder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Problem19 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 =IntStream.range(1, 1000)
                .parallel()
                .boxed()
                .toList();

//       List<Integer> list1 = list.stream().sorted().toList();
       System.out.println(list1);

    }
}
