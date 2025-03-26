import java.util.Scanner;

public class Frame {

	static void upperLower(int side) {
		for (int i = 0; i < side; i++) {
			System.out.print("* ");
		}
		System.out.println();
	}

	static void middle(int side) {
		System.out.print("* ");
		for (int i = 0; i < side - 2; i++) {
			System.out.print("  ");
		}
		System.out.println("* ");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(" enter value : ");
		Scanner sc = new Scanner(System.in);
		int side = sc.nextInt();
		upperLower(side);
		for (int i = 0; i < side - 2; i++) {
			middle(side);
		}
		upperLower(side);

	}

}
