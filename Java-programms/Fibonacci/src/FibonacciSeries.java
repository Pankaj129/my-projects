import java.util.Scanner;

public class FibonacciSeries {

	public static void main(String[] args) {
		int number1 = 0;
		int number2 = 1;

		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter fibonacci series size : ");
			int size = sc.nextInt();
			int result;
			System.out.print("Fibonacci series : "+number1+" "+number2+" ");
			for (int i = 0; i < size-2; i++) {
				result = number1 + number2;
				number1 = number2;
				number2 = result;
				System.out.print(result + " ");
			}
		}

	}

}
