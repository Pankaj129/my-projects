package string;

import java.util.StringTokenizer;

public class Tokenizer2 {

	public static void main(String[] args) {
		String str = "www.volantetech.com";
		String delim = ".";
		StringTokenizer st = new StringTokenizer(str, delim);
		while (st.hasMoreElements()) {
			System.out.println(st.nextElement());

		}

	}

}
