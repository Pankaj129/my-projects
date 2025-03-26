
public class Pangram {

	public static String pangrams(String s) {
		// Write your code here
		// int count =0;
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		for (int i = 0; i < alphabet.length(); i++) {
			if (s.toLowerCase().indexOf(alphabet.charAt(i)) == -1) {
				return "not pangram";
			}
			System.out.println(alphabet.charAt(i));
		}
		// if (count==alphabet.length()) {
		return "pangram";
		// }

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "We promptly judged antique ivory buckles for the next prize";
		System.out.println(pangrams(s));

	}

}
