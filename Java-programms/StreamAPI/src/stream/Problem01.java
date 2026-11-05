package stream;

import java.util.Arrays;
import java.util.Comparator;

//Get longest word from string
public class Problem01 {

	public static void main(String[] args) {
		
		String str = "I am learning streams in Java";
		String longestWord = Arrays.stream(str.split(" "))
							.max(Comparator.comparing(String::length)).get();
		
		System.out.println(longestWord);

	}

}
