package thecuriouscoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Problem04 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(Arrays.asList(20, 10, 10, 45, 30, 45, 5, 20));
		
		Optional<Integer> secondHighest = list.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst();
		
		if(secondHighest.isPresent())
			System.out.println(secondHighest.get());

	}

}
