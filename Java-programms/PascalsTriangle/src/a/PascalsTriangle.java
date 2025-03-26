package a;

import java.util.Scanner;

public class PascalsTriangle {

	static void spaces(int size) {
		for (int i = 0; i < size; i++) {
			System.out.print(" ");
		}
	}

	static void oddLine(int size) {

		for (int i = 1; i <= size; i++) {
			System.out.print(1);
		}
	}

	public static void main(String[] args) {

		System.out.print("Enter N : ");
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		spaces(N);
		System.out.println(1);
		for (int i = 1; i <= N; i++) {
			spaces(N+1-i);
			oddLine(i);
			oddLine(i);
			spaces(N+1-i);
			System.out.println();
		}

	}

}
