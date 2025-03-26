import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Weight {

	public static List<String> weightedUniformStrings(String s, List<Integer> queries) {
		// Write your code here
		List<Integer> output = new ArrayList<>();
		List<String> weight = new ArrayList<>();
		int n = 0;
		for (int i = 0; i < s.length(); i += n) {
			n = 0;
			for (int j = i; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j)) {
					n++;
				} else {
					j = s.length();
				}
			}
			for (int j = 1; j < n + 1; j++) {
				output.add(j * ((int) s.charAt(i) % 96));
			}
			System.out.println("i = " + s.charAt(i) + " n =" + n + " output = " + output);
		}
		System.out.println(output);
		for (Integer integer : queries) {
			if (output.contains(integer)) {
				weight.add("Yes");
			} else {
				weight.add("No");
			}
		}

		return weight;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abccddde";
		List<Integer> queries = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		// System.out.println("Enter count : ");
		// int n = sc.nextInt();
		// System.out.println("Enter numbers : ");
		// for (int i = 0; i < n; i++) {
		queries.add(1);
		queries.add(3);
		queries.add(12);
		queries.add(5);
		queries.add(9);
		queries.add(10);
		// queries.add(sc.nextInt());
		// }
		List<String> out = weightedUniformStrings(s, queries);
		System.out.println(out);
		sc.close();

	}

}
