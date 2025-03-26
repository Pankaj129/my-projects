import java.util.Arrays;
import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Enter string : ");
			String str = sc.next();
			char[] arr1 = str.toCharArray();
			char[] arr2 = new char[arr1.length];
			for (int i = 0; i < arr1.length; i++) {
				arr2[i] = arr1[arr1.length - 1 - i];
			}

			System.out.println("arr1 : " + Arrays.toString(arr1) + "\narr2 : " + Arrays.toString(arr2));
			if (Arrays.toString(arr1).equals(Arrays.toString(arr2)))
				System.out.println("Given string is palindrome");
			else
				System.out.println("Given string is not a palindrome");
		}

	}

}
