import java.util.Scanner;

/*Given a string s, find the length of the longest substring without duplicate characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.*/

public class LongestStringWithoutRepeat {

	public static int lengthOfLongestSubstring(String s) {
		String finalString = "";

		int finalCount = 0;
		for (int i = 0; i < s.length(); i++) {
			if (finalString.indexOf(s.charAt(i)) < 0) {

				finalString += s.charAt(i);
				if (finalCount <= finalString.length())
					finalCount = finalString.length();
			} else
				finalString = "";

		}

		return finalCount;
	}

	public static void main(String args[]) {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.printf("Enter string : ");

		String str = sc.next();

		System.out.println("lengthOfLongestSubstring : " + lengthOfLongestSubstring(str));

	}

}
