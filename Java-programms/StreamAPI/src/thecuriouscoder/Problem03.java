package thecuriouscoder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem03 {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(10, 20, 30, 40, 50);

		List<Integer> selectedElement = list.stream().skip(1).limit(2).collect(Collectors.toList());

		System.out.println(selectedElement);

	}

}
