import java.util.Scanner;

public class Bigger {

	public static String biggerIsGreater(String w) {
		// Write your code here
		String[] strSplit = w.split("");
		for (int i = w.length() - 1; i >= 0; i--) {
			for (int j = w.length() - 1; j > i; j--) {
				if (strSplit[i].charAt(0) < strSplit[j].charAt(0)) {

					StringBuilder stringBuilder = new StringBuilder(w.substring(j + 1));
					StringBuilder stringBuilder2 = new StringBuilder(w.substring(i + 1, j));
					return w.substring(0, i) + w.charAt(j) + stringBuilder.reverse().toString() + w.charAt(i)
							+ stringBuilder2.reverse().toString();
				}
			}
		}

		return "no answer";

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter string : "+biggerIsGreater(sc.next()));

	}

}
