package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem06 {

	public static void main(String[] args) {
		// Java 8 Stream API- 06 Given a sentence, find the words with a specified
		// number of vowels || Most Asked

		String str = "I am learning streams API in Java";

		List<String> vowels = Arrays.stream(str.split("\\s+"))
									.filter(a -> a.replaceAll("[^aeiouAEIOU]", "").length() == 2)
									.collect(Collectors.toList());

		vowels.stream().forEach(System.out::println);

//		getting string contains vowels
		System.out.println("\n==============Getting words contains a single vowel==============");
		long count = str.toLowerCase()
						.chars()
						.filter(x -> "aeiou".indexOf(x) != -1)
						.count();
		
		System.out.println("No of vowel words : " + count);
		
		Arrays.stream(str.split("\\s+"))
					.filter(word->word.matches(".*[aeiouAEIOU].*"))
					.forEach(System.out::println);

	}

}
