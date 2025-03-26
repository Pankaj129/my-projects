import java.util.Scanner;

public class SeparateTheNumbers {

	public static String returnRes(String s) {
		int n = s.length();
		for (int i = 1; i * 2 <= n; i++) {
			String first = s.substring(0, i);
			System.out.println("===>> first=" + first);
			try {
				long num = Long.parseLong(first);
				int j = i;
				while (j < n) {
					String next = Long.toString(num + 1);
					System.out.println("j=" + j + " next=" + next);
					if (!s.startsWith(next, j)) {
						break;
					}
					num++;
					j += next.length();
					System.out.println(">> j=" + j + "  num=" + num);
				}
				if (j == n) {
					return first;
				}
			} catch (Exception e) {
			}
		}
		return "";
	}

	public static void separateNumbers(String s) {
		String res = returnRes(s);
		if (res.isEmpty()) {
			System.out.println("NO");
		} else {
			System.out.println("YES " + res);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter string : ");
		separateNumbers(sc.next());
		sc.close();

	}

}
