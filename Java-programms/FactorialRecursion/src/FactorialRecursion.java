import java.util.Scanner;

public class FactorialRecursion {

	static int Factorial(int number) {
		if (number >= 1)
			return number * Factorial(number - 1);
		else
			return 1;
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Enter the Factorial : ");
			int fact = Factorial(sc.nextInt());
			System.out.print("Factorial : " + fact);

		}

	}

}
