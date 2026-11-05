package string;

import java.util.StringTokenizer;

public class Tokenizer {

	public static void main(String[] args) {

		String str = "payment success payment failed payment";
		StringTokenizer st = new StringTokenizer(str);
		String token;
		while (st.hasMoreTokens()) {
			token = st.nextToken();
			System.out.println(token);

		}

	}

}
