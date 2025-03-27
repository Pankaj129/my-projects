import java.util.Scanner;

public class AlternatingChar {

	public static int alternatingCharacters(String s) {
		// Write your code here
		int count = 0;
		for (int i = 0; i < s.length()-1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				count++;
			}
		}
		return count;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("output=" + alternatingCharacters(sc.next()));

	}

}
