package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem07 {

	public static void main(String[] args) {
		// Java 8 Stream API- 07 Divide given integer list into lists of even and odd
		// numbers || Most Asked

		int[] intArr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		
		List<Integer> intList = Arrays.stream(intArr)
				.boxed()
				.collect(Collectors.toList());
		
		List<List<Integer>> collection = intList.stream()
				.collect(Collectors.groupingBy(num->num%2==0, Collectors.toList()))
				.entrySet()
				.stream()
				.map(a->a.getValue())
				.collect(Collectors.toList());
		
		System.out.println(collection);
	}

}
