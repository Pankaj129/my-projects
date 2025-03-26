
public class Pyramid2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 9;
		for (int i = 1; i <= N; i++) {
			for (int k = 0; k < N - i; k++) {
				System.out.print("  ");
			}
			
			for (int j2 = 1; j2 <= i; j2++) {
				System.out.print(j2+" ");
			}
			
			for (int j2 = i-1; j2 > 0 ; j2--) {
				System.out.print(j2+" ");
			}

			System.out.println();

		}

	}

}
