import java.util.Scanner;

public class StringMove {

	public static int beautifulBinaryString(String b) {
		// Write your code here
		int move = 0;
		int n = 1;
		for (int i = 0; i < b.length()-2; i += n) {
			System.out.println(b.substring(i, i + 3));
			if (b.substring(i, i + 3).contentEquals("010")) {
				move++;
				n = 3;
			} else {
				n = 1;
			}
			System.out.println(n);
		}
		return move;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("output=" + beautifulBinaryString(sc.next()));

	}

}
