package thecuriouscoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem06 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>(Arrays.asList("Java", "SpringBoot", "API"));

		String longestString = list.stream().reduce((s1, s2) -> s1.length() >= s2.length() ? s1 : s2).orElse("Null or all same");

		System.out.println(longestString);
	}

}
