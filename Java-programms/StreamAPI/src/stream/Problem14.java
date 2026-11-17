package stream;

import java.util.Arrays;
import java.util.List;

public class Problem14 {

    public static void main(String[] args) {

        //Given a list of strings, create a list that contains only integers|| Most Asked

        String [] str = {"abc", "123", "cdf", "789"};

        List<Integer> listOfIntegers = Arrays.stream(str).filter(a -> a.matches("[0-9]+")).map(Integer::valueOf).toList();

        System.out.println(listOfIntegers);
    }
}
