package thecuriouscoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem01 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(Arrays.asList(5, 3, 1, 3, 2, 5, 4));

		List<Integer> distinctAndSorted = list.stream().distinct().sorted().collect(Collectors.toList());

		System.out.println(distinctAndSorted);

	}

}
