package thecuriouscoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem05 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

		Map<Boolean, List<Integer>> evenOdd = list.stream().collect(Collectors.groupingBy(a -> a % 2 == 0));

		evenOdd.entrySet()
				.forEach(entry -> System.out.println((entry.getKey() ? "Even: " : "Odd : ") + entry.getValue()));
	}

}
