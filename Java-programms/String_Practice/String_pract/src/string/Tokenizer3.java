package string;

import java.util.StringTokenizer;

public class Tokenizer3 {

	public static void main(String[] args) {
		String str ="https://www.google.com/search?q=ayx&rlz=1C1UEAD_enIN1238&oq=ayx&gs_lcrp";
		String delim = ":/?.=&_";
		
		StringTokenizer stk = new StringTokenizer(str, delim, true);
		String token = null;
		while(stk.hasMoreTokens()) {
			token = stk.nextToken();
			System.out.println(token);
		}	

	}

}
