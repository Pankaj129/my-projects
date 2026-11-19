package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Problem26 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		List<Integer> list1 = Arrays.asList(6,7,8,9,10);
		
		List<Integer> s2 = Stream.concat(list.stream(), list1.stream()).toList();
		
		System.out.println(s2);
		
		

	}

}
