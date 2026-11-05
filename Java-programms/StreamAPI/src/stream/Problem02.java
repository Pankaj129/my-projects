package stream;

import java.util.Arrays;
import java.util.List;

public class Problem02 {

	public static void main(String[] args) {
		// Remove duplicate from string and return string in same order

		String str = "dabcadefg";
		str.chars()
			.distinct()
			.mapToObj(a -> (char) a)
			.forEach(System.out::print);
		System.out.println("\n===============approach 2===============");
		List<String> ans = Arrays.stream(str.split("")).distinct().toList();
		ans.forEach(System.out::print);

	}

}
