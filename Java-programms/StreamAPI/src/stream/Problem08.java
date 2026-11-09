package stream;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem08 {

	public static void main(String[] args) {
		// Java 8 Stream API- 08 Given a word, find the occurrence of each character ||Most Asked
		
		String word = "MississippiProgramming";
		
		Map<String, Long> mapChars = Arrays.stream(word.split(""))
									.collect(Collectors.groupingBy(a->a,Collectors.counting()));
		
		System.out.println(mapChars);
		
		Map<Character, Long> occurences = word.chars()
											.mapToObj(a->(char)a)
											.collect(Collectors.groupingBy(x->x,Collectors.counting()));
		
		System.out.println(occurences);

	}

}
