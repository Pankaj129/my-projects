package thecuriouscoder;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem10 {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(3, 2, 3, 4, 4, 1, 2, 1, 1, 1, 5, 6, 5);
		
		  Map<Integer, Long> freqMap = list.stream().collect(Collectors.groupingBy(x->x, Collectors.counting()));
		
		System.out.println(freqMap);

	}

}
