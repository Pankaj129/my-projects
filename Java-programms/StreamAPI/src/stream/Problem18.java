package stream;

import java.util.stream.IntStream;

public class Problem18 {

    public static void main(String[] args) {
        //Write a program to multiply 1st and last element, 2nd and 2nd last element etc.

        int [] intArr = {2, 5, 8, 3, 5, 9};

        IntStream.range(0, intArr.length/2).map(a->intArr[a]*intArr[intArr.length-1-a]).forEach(System.out::println);
    }
}
