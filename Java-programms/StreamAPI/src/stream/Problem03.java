package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Problem03 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// return highest length nth word from string
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String");
		String longestString = sc.nextLine();
		System.out.println("Enter nth element : ");
		int n = sc.nextInt();
		String answer = Arrays.stream(longestString.split("\\s+"))
				.sorted(Comparator.comparing(String::length).reversed())
				.skip(n-1)
				.findFirst()
				.get();
		
		System.out.println(answer);
		
		

	}

}
