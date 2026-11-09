package thecuriouscoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem02 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

		List<Integer> oddSquare = list.stream().filter(a -> a % 2 != 0).map(a -> a * a).collect(Collectors.toList());

		System.out.println(oddSquare);

	}

}
