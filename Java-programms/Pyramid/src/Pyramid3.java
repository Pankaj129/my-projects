import java.util.Scanner;

public class Pyramid3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int j = 1;
		for (int i = 1; i <= N; i++) {
			for (int k = 0; k < N - i; k++) {
				System.out.print("  ");
			}

			for (int j2 = i; j2 < j + 1; j2++) {
				System.out.print(j2 + " ");
			}

			for (int j2 = j - 1; j2 >= i; j2--) {
				System.out.print(j2 + " ");
			}
			j = j + 2;
			System.out.println();

		}

	}

}
