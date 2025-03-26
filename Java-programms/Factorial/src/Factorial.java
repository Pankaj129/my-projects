import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print(" Enter factorial number : ");
			int factorial = sc.nextInt();
			int result = 1;

			for (int i = 1; i <= factorial; i++) {
				result = result * i;
			}

			System.out.println(" Factorial = " + result);
		}

	}

}
