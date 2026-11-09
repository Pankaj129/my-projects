package stream;

import java.util.Arrays;
import java.util.Comparator;

public class Problem09 {

    public static void main(String[] args) {
        // Java 8 Stream API - Arrange numbers in Ascending & Descending Order
        int[] arr = { 23, 65, 12, 97, 44, 34, 81, 55 };

        // 1. Ascending Order (Natural Order)
        // IntStream has a native sorted() method that works directly on primitives
        int[] ascending = Arrays.stream(arr)
                                .sorted()
                                .toArray();
        
        System.out.println("Natural order : " + Arrays.toString(ascending));

        // 2. Descending Order (Reverse Order)
        // Use .boxed() to cleanly convert IntStream to Stream<Integer> for the comparator
        int[] descending = Arrays.stream(arr)
                                 .boxed()
                                 .sorted(Comparator.reverseOrder())
                                 .mapToInt(Integer::intValue) // Map back to primitive int
                                 .toArray();
        
        System.out.println("Reverse order : " + Arrays.toString(descending));
    }
}
