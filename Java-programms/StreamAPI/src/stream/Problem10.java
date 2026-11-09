package stream;

import java.util.Arrays;

public class Problem10 {

	public static void main(String[] args) {
		// Java 8 Stream API- 10 Given an array, find the sum of unique elements || Most Asked
		
		int[] arr = { 12, 23, 65, 55, 81, 23, 44, 44, 44, 12, 97, 44, 34, 81, 55 };
		
		int sum = Arrays.stream(arr).distinct().sum();
		
		System.out.println("Sum of distinct numbers : "+sum);

	}

}
