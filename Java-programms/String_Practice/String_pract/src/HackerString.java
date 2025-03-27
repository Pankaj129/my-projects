import java.util.Scanner;

public class HackerString {

	public static String hackerrankInString(String s) {
		// Write your code here
		String str = "hackerrank";
		String count = "";
		int i = 0;
		for (int j = 0; j < s.length(); j++) {
			if (str.charAt(i) == s.charAt(j)) {
				count += s.charAt(j);
				System.out.println(count + " " + j);
				i++;
			}
			if (i > str.length()) {
				System.out.println("breakout");
				break;
			}
		}

		return (count.equalsIgnoreCase(str) ? "YES" : "NO");
	}

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			String output = hackerrankInString(sc.next());
			System.out.println(output);
		}

	}

}
