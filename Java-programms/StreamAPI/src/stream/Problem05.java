package stream;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Problem05 {

	public static void main(String[] args) {
		// find occurrence of each word in string
		
		String str = "payment success payment failed payment";
		
		Map<String, Long> occurence =  Arrays.stream(str.split("\\s+"))
		.collect(Collectors.groupingBy(a->a, Collectors.counting()));
		//.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		System.out.println(occurence);
		
		
		

	}

}
