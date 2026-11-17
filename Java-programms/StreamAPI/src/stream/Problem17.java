package stream;

import java.util.stream.IntStream;

public class Problem17 {

    public static void main(String[] args) {
        //Write a stream program to multiply alternative numbers in an array|| Most Asked

        int [] intArr = {2, 3, 6, 7, 8, 9,4};

        int reduce = IntStream.range(0, intArr.length).filter(x -> x % 2 != 0).map(a -> intArr[a]).reduce(1, (a, b) -> a * b);

        System.out.println(reduce);
    }
}
