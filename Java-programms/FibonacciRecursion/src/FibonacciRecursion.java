import java.util.Scanner;

public class FibonacciRecursion {
	static int num1 = 0;
	static int num2 = 1;
	static int result;

	static void Fibonacci(int count) {

		if (count > 0) {
			result = num1 + num2;
			num1 = num2;
			num2 = result;
			System.out.print(" " + result);
			Fibonacci(count - 1);
		}
	}

	public static void main(String[] args) {
		System.out.println("Enter series size : ");

		try (Scanner sc = new Scanner(System.in)) {
			int count = sc.nextInt();
			System.out.print("Fibonacci series : " + 0 + " " + 1);
			Fibonacci(count - 2);
		}

	}

}
