package a;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Token {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = "file:///D:/Pankaj/Java/sunbeam/java/oopswithjava-main/DAY09/Core_Java_String.pdf";
		String delim = "/.=#_//-:";
		StringTokenizer token = new StringTokenizer(str, delim, true);
		String tkn = null;
		while (token.hasMoreTokens()) {
			tkn = token.nextToken();
			System.out.println(tkn);
		}
		sc.close();

	}

}
