import java.util.Scanner;

public class PalindromRecursion {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Enter Palindrome number : ");
			int number1 = sc.nextInt();
			if (number1 == Palindrom(number1, 0))
				System.out.println("Given string is palindrome");
			else
				System.out.println("Given string is not a palindrome");
		}

	}

	private static int Palindrom(int number1, int rev) {
		if (number1 == 0)
			return rev;

		int rem = number1 % 10;
		 rev = rev * 10 + rem;
		return Palindrom(number1 / 10, rev);
	}

}
