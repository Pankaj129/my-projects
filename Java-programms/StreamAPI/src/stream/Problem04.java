package stream;

import java.util.Arrays;
import java.util.Comparator;

public class Problem04 {

	public static void main(String[] args) {
		// 2nd highest word length
		
		String str = "I am learning Mathematical class destruction";
		
		int length = Arrays.stream(str.split("\\s+"))
				.map(a->a.length())
				.sorted(Comparator.reverseOrder())
				.skip(1)
				.findFirst()
				.get();
		
		System.out.println(length);

	}

}
