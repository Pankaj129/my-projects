import java.util.Scanner;

public class LongestPalidromicSubstring {

	public static String longestPalindrome(String s) {
		if (s == null || s.isEmpty()) {
			return "";
		}

		String finalPalindrome = s.substring(0, 1);
		int strLen = 2;
		int counter = 0;

		while (strLen <= s.length()) {
			if (counter + strLen <= s.length()) {
				String palindrome = s.substring(counter, counter + strLen);

				String reversed = new StringBuilder(palindrome).reverse().toString();

				if (palindrome.equals(reversed)) {
					finalPalindrome = palindrome;
				}

				counter++;
			} else {
				strLen++;
				counter = 0;
			}
		}

		return finalPalindrome;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("Enter string : ");
		System.out.println("Longest palindromic string : "+longestPalindrome(sc.next()));

	}

}
