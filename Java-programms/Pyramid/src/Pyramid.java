
public class Pyramid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 5, j = 1;
		for (int i = 1; i <= N; i++) {
			for (int k = 0; k < N - i; k++) {
				System.out.print(" ");
			}
			for (int j2 = 0; j2 < j; j2++) {
				System.out.print(1);
			}
			j = j+2;
			//System.out.print(j);
			System.out.println();
			
		}

	}

}
