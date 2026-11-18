package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem19 {
    public static void main(String[] args) {
        //Write a stream program to move all zero’s to beginning of array ||Most Asked

        int [] intArr = {0,1,0,5,0,8};


        List<Integer> zeros = Arrays.stream(intArr).boxed().filter(x->x==0).toList();

        List<Integer> nonZeros = Arrays.stream(intArr).boxed().filter(x->x!=0).toList();

        List<Integer> finalList = new ArrayList<>();
        finalList.addAll(zeros);
        finalList.addAll(nonZeros);
        System.out.println(finalList);

        List<Integer> ansList = Arrays.stream(intArr)
                .boxed()
                .collect(Collectors.groupingBy(x -> x != 0))
                .values()
                .stream().flatMap(x->x.stream()).toList();

        System.out.println(ansList);
    }
}
