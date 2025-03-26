import java.util.Scanner;

public class FunnyString {

	public static String funnyString(String s) {
		// Write your code here
		for (int i = 0; i < s.length() - 2; i++) {
			if (Math.abs(((int) (s.charAt(i + 1))) - ((int) (s.charAt(i)))) != Math
					.abs(((int) (s.charAt(s.length() - 1 - i))) - ((int) (s.charAt(s.length() - 2 - i))))) {
				return "Not Funny";
			}
		}
		return "Funny";

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		System.out.println(funnyString(input));

	}

}
