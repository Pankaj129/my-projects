package stream;

import java.util.Arrays;

public class Problem15 {

    public static void main(String[] args) {

        //Find the products of the first two elements in an array

        int [] intArr = {25, 36, 87, 29};
        int product = Arrays.stream(intArr).limit(2).reduce((a, b) -> a * b).getAsInt();
        System.out.println(product);
    }
}
