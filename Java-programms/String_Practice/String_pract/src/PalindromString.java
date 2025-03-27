import java.util.Scanner;

public class PalindromString {

	public static int theLoveLetterMystery(String s) {
		// Write your code here
		int count = 0;
		StringBuilder sb = new StringBuilder(s);
		String str = sb.reverse().toString();
		if (s.contentEquals(str)) {
			return count;
		} else {
			for (int i = 0; i < s.length() / 2; i++) {
				count += Math.abs(s.charAt(i) - s.charAt(s.length() - 1 - i));
				System.out.println("count " + i + " : " + count);
			}
			return count;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("output=" + theLoveLetterMystery(sc.next()));

	}

}
