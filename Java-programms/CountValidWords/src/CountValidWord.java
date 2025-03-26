import java.util.Scanner;
import java.util.StringTokenizer;

public class CountValidWord {

	public static int countValidWords(String s) {
		// Write your code here
		String vowel = "aeiouAEIOU";
		String consonent = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRTSVWXYZ0123456789";
		// String numbers = "0123456789";
		String symbol = "!@#$%~^&*()_+=/,.-";
		// String delimit = " ";
		// String[] tkn = s.split(" ");
		StringTokenizer tkn = new StringTokenizer(s, " ");
		int count = 0;
		System.out.println(s);
		int flagVowel, flagConsonent;
		boolean flagSymbol;
		while (tkn.hasMoreTokens()) {
			String string = tkn.nextToken();
			//System.out.println(string);
			flagVowel = 0;
			flagConsonent = 0;
			flagSymbol = true;
			if (string.length() > 2) {
				for (int i = 0; i < string.length(); i++) {
					char c = string.charAt(i);
					// System.out.println(c+" 1 : "+vowel.indexOf(c));
					// System.out.println(c+" 2 : "+consonent.indexOf(c));
					// System.out.println(c+" 3 : "+symbol.indexOf(c));
					if (vowel.indexOf(c) != -1) {
						flagVowel++;
					}
					if (consonent.indexOf(c) != -1) {
						flagConsonent++;
					}
					if (symbol.indexOf(c) > -1) {
						flagSymbol = false;
					}
				}
				//System.out.println(flagVowel + " " + flagConsonent + " " + flagSymbol);

				if (flagConsonent > 0 && flagVowel > 0 && flagSymbol) {
					count++;
				}
			}
		}
		return count;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println(countValidWords("6cbRp4mRdz1J2g3e n0zONrDcP7we 49Nnt3574O34ee z7LFxA64P85e vm8zpkzP1R8e 6Ri6q7IJYmm1e PjE9L2l17bJTe KMrw46Jki2e VcSE25CaXB1Xe IcO61bAhA8e 5qht6729010xiA1e Dsmzs56bc99bbve VdY54DaC9O0e 8XH7W1Pv04ae72e 3tb404gKJi1Pe YI2o7JFvW18y63e yL1DNCN62HAe MI4n3IzoZXfe 3d89o7eI7659BNfe LANcX4IQ0ge vuw7KXYBquW1e 7Dmer2l9xlN606he Ie6Vh8rh6gBsQe FivsX0r8Nle LFm1e65HK5WwaiHe 77jdp1rOKMCnY9e 14o1mvhKTR2JwVe 98Wu7Wu85HEe KLq666hj8tlrBg0e WRBJ89LR6ce TIUj5p30pF2D9e P4GKh7nA9rU8IEe lDHE4b9Y1VK2P3Ne 89NEtI3u1oe 44UILCb0YCbfkLZe kNPIw9mK1Jq2uA8e frkaA7V91oe UB7uU00uGae 1cvO692Y58e DWBkH8ZBDHc016e 22VD155zEvNHe Ken41CxHkpKg9De 5qaClCWd0D3ve C8aKU3KNPM46ke CI03gK36ICyk6e KbPL1vkC4gce 29DrT53tkqe TGwaw1172OWe tyLuvR5XZb7FHe 5WaJ43T4I33u9e o4xCnm5046SaAd3e 8VMClivUHa5ie 821JdTYvWQre 8EsrYXx1Ay2Ye BG35Tl075wjNS83e Ug0WdxW3vQ6k9cDe ZEmX690D2Xe mF0s3xypwsc0Y6e 4Vn6XDJ4fj11e 187gh4XqclD4v39e z4e2mf2rwx5M82e S9a0X3N9A0k7e ZNj8EotXcoRXge XH2zF93A0qzjp9ge GbiAFNbfrUgr8e 0zAZsB3yel8PIN3e jglVMk8Yl7ZSe 4Z1J592B23e gaJ9961P9ZiHe Owlyzi62vcPdCie 86KuF400The wuG79797aLe v8U42R37YNe 3tE739j0wUCe Cr2n00g7LEe 7kLi7zhClQVe 9bniww6Pjr3Qe 328dU63ngK908Ie zZ973lSB96Zd1ce 3TyGgm35xOIChmEe B8Wj7ltIolH7Pe 2WgH2h833NcMe A2Ng17ZU837Snqke 9H25N7Uj7Ke Lj9160e2pPAHrEYe dMxzuDi61loBre xXTcl0LzLW9e pqle510kSkLLe Hrwaiy9txxu8fe biJ2C9Jb0BThFFe 67a3MxxAI3ncge 8cPho3j1cUbe 944o72JD0WCe Jx42n1EiKbLe B6zoWn4o6Y2B6e 8YYH8bwm86wLXle mZKyG19Fi87k0oe YZfv840Ic2gvnuEe S1g69g65TdxTe 7mWlPdITbGe sPL8PnVzNY2xhre BlF2TS8MMMte MGDSPP757S07x46e g8pM5rNivscZoxe e1S3MVQq4ye 6Sslv6iTAutRe jXJ0vogzEC46e osbYMjtu6xztSte 42MZwOEb3uTY6fle WK0OqWwc52NUNLke ZqXAUXbb70ZhzSe Ly05Ir0gsieEhe j07U08p29Ve 8jE92VdW85e g5tnou5Mv3Qgsxe O7yL8515AKoMe q6j516KF315m6e x5Gm1RFlNMr2dZe vO7VOJsIArHp2Me AcoyMyF4RdiAe yWhgE9eQzh14ee 2x248wt5NY08e 7VLd35XL75EfwZe lptruyrjJJfiE0ee Z6B5EIF201yQve 3DUwRuhIwYggF8e d09T0Yat11t0e cWhrCwQjJZPMQUe V6QsYipbz4bo24e Af2LC8693rA9kbae Oc4kw9Bdf6I3YNe afC3l5rG4ee XgX0U5ls7p27eile 5cZuK4OJjlt9e1e Yf3KT76X167JkMne r520Pin7tuL9e ZFSIg7d6MVb2e gc7pj995aKpKsCZe bQmx0J5l36W2Vye AZpuy067g3e 9Fb7z4ANNZ7yg5e Dhn5XyukQ2cu88e 0cVQx71X7sh76e 9gRJ8e7yVIMe WV3l9bFbJc0s0e QXGnyDcOUNzSNe hDg8k7B199Se 69FKB04CNC9c8ve firw442Pb35e qvwunD20bg2Cke R36eWk1Zb1Ry72Ge 0n5LVS4nvllvgj7e pCAy52J0sX04e 4A7t08HF78e BE1pe1YBj6PFiEe Xk7lOt2e7ve s8jBvg9RuAe 139W3QHdRo9be eqgnOAov4EDe 50BQzlK0UkvVXhUe giiZos4aP4J7qkOe jIu54dm4z5r8e c3uq9X7H15e Igfot5Txu72UGe 0P6AtpF2d8F40e xl612S6Xwfe LhO28915EOFrwe ts5tV58E6VZw7iUe 372Dii3pjl4q5e 7vM0uOPPAppfe 8n6nuJJj7pBOe wlyPwxyVOHct75e q2G9oO7T28Y5e 2e6XOZdzkCQ2CKe n6a07ninxoJpVe frd3rnFgdHe 0L6864bu8K369hVe 73hT9Kx8Yoe McFIyGQ3ZEe dB5Po6W2ze76G6ze k5hT9K3xitu19Vye u7621q249eR5e 3w1IJZl8mH82Ie 20K7aQZ416xe 5W4U78s3N2e 1NF3dH4uvupse mqXq4XOeqZ7Oe Lfx4Sej5japIe Y6KISA1yqz5bMVe NNh7tvhe9zXFUze jzghDi7r68e 2o46EJvN007e 7aF5U2q85fe jXxZy9ih0Ne 7qESf23huOJe mfsNTC020ge wK0y4DbI24se Ot3gG5cc0Pe TcbUkzF23L5e S1B0kwL1Hzw0e P4dQkBo2y7W6e vheKhCwCL9ae dvT99yOWA1QSWWe 0dhC891QsO58e fD0n3547yx90Y4e 551TLFzl0t8e 8A9GL2578Hc7ce 0Qn0a4fK9TIXmm5e eS1ct0CLtee eCMe6YCg12Dvs5e DB0bj3q9ulsrse R47V281x9AxJHe Bq7lIBKZx9fM7e STueNCaUU4Ae 4xmEcfaj60e WBH2CTxX7SO5ge WFEm2tExrJE0te jCCti1HRpCye eeV7l3qDu4l8v0e J48Cjbc8FU5P91Ve La5wa8oA7dn9F0e A5pLT76op67MJe qA37Lg936dVN0oe XlAu7B985mT6Ae fElh558dudIUqe j76187nKWZae 2ORP5FiCV00A9be 5bmU7057d7e 1dTD54Wl94de cE8BR6l1uyrfe D8794HELPQ7n5Ae w5DNe9JO47e oykIb07L5Je jo4P0I5Wc8Gejb6e rOw6kAg0d239e pFk62B6d3cAQAze 2VihcCj51HXf8ue ou5Mk8yMhfLZ01fe 02Zkj024pIjIIIe JCcE6IR8Q687iBe Y5p08r9kg3rie 2ySH9mrh2ze fBWc22hav4e c289gfN798e 066r5uahD1TgV2e bG8OiuUoOMee n0UX8R8Pr13e 6Y59S78ORae 8F1DW3El0fnxe yIt9WyiDUB6ne NsvvpJmV331Fr4e 2Y1NNs0KgUo9e wc2R1NCpo3e LNW04qCe5j2n1b3e 3r137wN834dose YzQzU8wZHpEXe A3S40a6O1Ie e1DIaHeFr01wf4e bzTYpL55U6U78IQe CPnI33s46HFSRe WP8rxC7DZkmke 42HV79Md3OM8e UJ9Roi6cg42ae Qsgz57PZgCH7Ne H16qS17VK6L83Oe 6sZb4HyJVge 7M4t100El9IAIYe X3diZ9UMPQpve lOC5Tv8Gdz0LwLHe 3kdKhTR0c82PHe 9aUhzC44A006Qe Ze1U7bYQ19e akbXt19466uIe vA64OY06y3e 9150k0bPLxZy0e 170L23w0nMh5e pvSrs95T09IGhYe 87uk46FlJoO9h2Ae V06S47mGBRE10L0e 0G1A8992b7K96e GFytAhm3ovTe 4ZqpIheav8e8nZe 6T50XwVEfj2e 4fvp0Oz2pf63SNe 47jx27LO5Zm0e GEIfST5HGBq1YQe il4a8WTX89e XZp1z6797Ubw7sZe J7h107s064dpSe zK88TA7c43e 2O11TRc746Usj4Se dtbKN16E24e 7Ht3UDV1UBKC3Xoe 2HHecK1nyge 95w3yElrxJYz7Moe 95U6kG635uV8j6e 21j8R153h27X5Oe 6b62JnsR8UWe 506rB2568JUe 9BbeU5LF7zMe 2JLj3g798ox2e ThSOttndgXe 9fEs024XCUe mc4YhGRmfUsYe 1N4QbZ3453X21yue IS0ZfI9B4Y00FTe QXyt2cCs20e 3OQ8VqzuOu4HXBe nC0D022xw8wde CAybb78Hs3e mZ1I7hBsbw878rje oB01Nh3U0l52e ZbVOjo91zVe 0ZV5c4SO5mOWe jvmUy9Oc7r9e XVGCV57LhMYUe eCrn0r8arfmUUe RgfyNJRsnpe 5nhAmI01fQhng4se 0kcni5SpT18Le 5LWVVI8CiG3e gV0gF9032W5vUe uEGmxS3w7PvUrTe f4t1ZIB3BSe z9Y3Gq7S1Xa5qWbe Pp6o7SnvX3Qe OWwa22ziWQrXse X5P42kQ0a4P9iQe Za6vkHQAf3t7xe fR0XMLjoKc8Oe L15e474T24qGM09e r3u9l5Ww0kl8e 2z243iW7XNe 2I5bea3yBJ0Q8e 76Cxai7d91G0rGe l2c633gpQiz1e Xn204lWBwkD1e hMsa0t4X6xe RWvdS2IQ9spmcne DrXANOZ7724SSe Fg7gw5bVuX3Oe 0mkH6hlx3YA791ue 7cj13fi883ye N182k74tp8nice 7TBc57zyTBw0mge v2083jtDn2e 5f90SFt5j7e 1034QN2TRA9ZGs9e e5XU4pDo9b77e W0PU2BJmgPNRKte n7jopFONe20gqZoe os4kY88afPtle FgiqPr05HadR81Be Y6I5853d0O6mFe l9B91sCgybKe ic6435Q9ND2yX2e AkX9Q8s7J1E8ne jR45DDhEa3m873e i6Vux6VM1C5Ze 22E96CKC2TVXpe DR4VQgwkmfnY291e 50CJdotlC0Te y26Y268SA7LCvHEe MxXjQNm4WewIe 9M7357PIpgfe q7F4g6dGZqV77e 0ty2vUCLI1qNyve e9XP5pltN7e 66a32c2473MSBe SJ9MC9OE377e SHC2F3ex47kOe a1Wnw487i7h71ie v8ax0A2I1ke duMI724yTMGe EYxvqsxWlHKl178e 94PAd9oK1PJA0e 5ei8o0AAOf7993e txA7o8STugw3e 0RXvwhIZW5hGoe 6dQSHj4hDPyxe Mb608tNg6rXlXe 7RQb4q45NbmG41Qe 8j0VNXi2fpg7qe 7Wtqtj2a81dSve 1tB839d1pBXG4x9e e52aTaGT8KV8TQ9e VIjSt97cYAe C75wJ8P59Se bLh01z7o7p7e b2UN699edCy5e O4Go999008ZJJ0fe NizLDz4R6zTUle xYEfJdkbgBQe uLOr9Lp69ede jy5UdburZoOD6w6e 38zq8w1w038bKe Twzd8W1cb1LltZe YSBSes20W864Zce g8TGb1G69wee 84vM2m2mmk1MX1e JciyhwiAXXpJXe 7dUmQx5s3PG9WGe 479m1fr7Bc9f4lHe cWg7CVKM8u8ae GryMzr4TSo69F96e vk5P7N0nDNjae rAY7du22gI87o7e TjI3x2Ck5pj7ze BuB69271N60he T821h12x60sIe MC767KR76N34QOBe 4wbB56OllpRe 8hkOcG9i93L415e 4u4VZNUT47GQ1e DgZ59w1uMcxje E5drsa060049e 74O89yP7JMKe 2xm9Y0xW484e lggVhRAkBjnH61xe 1quH1awDP7e aLd1e02udAUe 81iSY9k8pWd60Qe yz3G3768eG7e l44NTxoB5Me REJGum0C5Ye RL2K1RjU3Pze 27klP34fQyR2T1Ue xk12oMKc15se 0W0BwSMZHf7Fae v6ZM71EAp70j6be 1qc5v6Uclz0Y18Fe WqEE7cJLw8U9e H2iGQZqyw2kR1e Dh213CSE0F7MZe 0ZAEYxVthQ948e 508DpJYKtI5Se wt10k2sSM09Y09e h4Bkcl4xsnw4n6e 2I2dFwXX23tyOe W1ANNQV394e 06x7darCdvk0Ce W1tg6eTMX8JF0je Oq0f5F49CE4rSbSe HZ1hqPv3D6573e s953J8LPI9ke 1uj6d754TKA2k5e 5i8z63XGK5ke 47NAzXdd251VT2e Ol23FoEmd0U4e WXuR774J3E1zM0e WoO8j8nE4Dbe 75IuJ87kZEg1s6e Qw4BI766Ba9e 2cFyvtAl1u9e Pd0A3463gtOe KlLRO3Q4R26bOD7e 42XESkcz4ue z20yAC6Ce1jMae frOdvLerIPT6e 072CRskX2HE4Ee D30Def26OFce gs6yIU28UFS88e 7s5rwyrFF9le 2538Si8tUT2e 2Mgm9G33iz4I4X0e TwdEo9l9BHyhFe Lipq36zLbbJnnCe cGWDBN5E375qW1e WZVo0m8eTj1LTrGe s4gIZl9R75sl6e h0O5fBsMBLRd9e G4yG3UN2Yoj6e 1n8xg5fbnbe toz3y280CgNLTuZe q3GaBVmBB9e drJOu538p4hje 8y1VKr74f9ze HMf7Rap59We YgbD8s6itgV0pVe N3q8nOpPuLTe D7rJU50K05PBIU8e 4Z1ssE1E9IKe uMmBFOHi5ko1e iPjy2OjeUxe M8t8GWn1HxG2MUe 5O8jn6jHGnOuTe i9F1PgfXt1uxe A0IUtcHCGFe CwnBfQT93sx8De 27fTGvF6B8ps91e 0pnHO8DGZu9U6e f8C23d2XR7o8e JKNQEg067Zq7Oe WZ4R54Laj0RRe H19yp6J0SjnmH4e 4t2huo7oE42e L72AEIoNwIPotH2e fUZ7L660b9e Fhi7xe7o4Qi6u7e 4Q2TF8N99kGe Wds68Zv7qEh1t2e pGh8yHa5ON248eIe DSHW9pPTsBpbe qHq29iY1D5u5e 3Suni3MU8CHQje F7YjfTFNh4wVe 0O34xr5qR101Lee YYE4ScSHUYe K9x5IQehf1EoF8Ke JVOTJnGT03N9hP4e e1kUxFr7jE75l1Ke oFGz8aw2Df0e 60yYqFCa1891N24e TC9C0466hqXTze 4jAG14i8A6scG8e 62ghhxK1pOBe 7f31v0C0dp5NGDLe 9fp9426Tk7gPcke PZog38865792ee 30er2IewvRAe EN08hX5Sto2Jfpe 2LFr53a1D8Te 9QkDUNIHx3lcNAKe tI3Ifr7z0H0e 8tSkN60rFZe JQg1brnwQ6w4e sxsx2Vu5b1SFfe P029NJ31BhjIe 2Z5RMnZxd8ge 23q7m348wnSI4e Th40CfC54hjscke BI1J06ysP7HaEe 7JsetdV883ZGe y0je4tWdZ2e I8o7I8fS8Je a7mno7cnNYR9BoQe xO804VlwN4l7r2e qmS9f578Us6Qe bYeX1OJn76e zqQjph9N8ne 4WW8viRtV688qae u04IIH7Rj6Sq0e WSEpMS66bXZe p8CULMRwWrze r0ih62SqZtle Aq3ArB0Wd0RIO2e faI8659L32910rle vG07hgh99TKe N9TT6t1W5K969e Ux7X1m6021N2e ON9aGzf5RKe tA9mfZHNk7we svjn8xm49ne AjzCqBW7Ne9609e 6H2pO9jKMpzYA9Ue SVLP55gKBq89s3e TFe1U1ZP7Xe V1uh4u84pmFEm78e P009P5S04qze lU81RNvXYdt0vae 10wX4RQ2PLa7le aCL3eEG1c0je 96kIk336266e Wf3gjb8yVpic5hNe OU52PoHVONe6e 53t5hHbTA5x7Pe v9LC158b4x7xe GgQBu67MjYLF7De 3Uhr5iCIjru9hde BSD5DOL76R8FGe 960xBR371550cAFe P09A9o8Ll7pe 3L4JCZ3LV0c6Ve ct09Js7o25mie z3d98mrgsgle hR0TrTzwql0e QeAmc80pofzYn8e qVz951DXqS5R8ce Ts5s6osmqIe BDP5jWcMVJ19e Rh7bWzRK8n0hZ9ie yWNdgvR34Ue f27WI3P0o9Xte xFdUn62yoz4381e 05t4tIMsdLGe 33Wuq5l4j511Fue No18N2SDO63e 3hP6wkxgs1y3Ve H1sUa4PK09oe 4wj81liqZ5G013Pe RuYw4L7G0ne 6XqGZjQuNi6e 6YVt0nBf12xcXlWe sqvAgj77MxRCAe N5R37ZHtxe9rSIqe E39IYt763le MY14d17CjVe rH53DGf4PyHY1fe 115jaW3IBdxMe 6Eqq71JiFpFe O6nPx26g2u9e yL4b95kdW1e 0o24sQCMMBH17iAe p8957ksCYsBe 79fS0gm3n0FNSVe xSN6VkrH73iD6e WA8W42loxVe 8BHP8Cf73eY3Lye 85mJUhWV7Ay43Re o0Mzyl7qMso6oPxe O87d2pouJ6n35B6e 392tVe4NJRe 1x60dDz1JFKVe Qx58a9WOAzsze xw5KLN5RWUjEe 66aIi00J6eBa2e 0sq3Nff4VJYHte 9Rk84OoD01e vG4Q36GLH5Xre MPyM3DQZ9Ss2nEe l41IqJ5If9uve uzRt48KQdK5j8e z9n4R743h4294w5e LW1eDJUUJie 8IzqvIKG9m6xe 4i2fg2r5Lk80e TuCB6yEY22obe NQr5x3M6bp295e mAeC659TW0i01vne df7DX66MbQe n0DJfE79DnJEe gWWmY09tqFO111e L1tYb4x0C23kJe A5z05UXGX5e g404hDI0v9CW5e 0p8RNtBs91e IwCj20O34Ge V1000z1cmpe lIIxaGpdLde 254b3SGq4MAdXe ZX2p1n361w47Ne YBqH998QPhOmHPe t72p1QLEe3OI02e g2BOqb9Fxv2jFne Pc5Intw3x6wSe 2bZETvoFBF1W7we 7aDrotKj0SL11b5e t6DQ5SOQQqle he2mdpr9691e N78RK37yY3H3e FzfVB814gbm5LMe ihMaiEl15dOe 1F1tlpwyIAe Pba286a5D7c6le Yr3eKxsqY0b8ee 6J48sG39YKVe WW9wc2yHffGxBe dAL68DC0xoe oj6oQTlCcbFqe 29X5ANh7SIGewboe 043dWgU4qu4e ghL8NUMt8xve hnRq45t1VfF6e 1G1003VXsN13e I9ByMX3368e NOI13w1dKcE36rQe 9Q2QGsK9cbIe 927443G2c6tXe TzFoZ7CV5F4o8e 6T97XaKbHM49e MzjY71zHLY03zwe YKTRY8Ux15we Wg35HGL26uyYye F7e06996nnpUepe ndn0fssUQ5Mce 655H6RPOup5Je C6JtuFkJ094118e 1dO06IC158q15JHe 9WdC7761cv08be 51X12VMcjI353e Q03Yb0Xyx9049ce 1DZR8p4u5XksPe AB13L8xl7Se 25z6t9k789G087e mZN2r6L1D5eSRLwe z07lw75319U84e VKFaA778Vxe q6g4Aj15Ol3e 8n8q557CNPUje js16sgerZ5ZAibEe 0gg4N8B88Rh5me C0z2z0YE0We Vqt6ySv0zICve E0D84w405Fe gnKv643pHj4He 6JbpzDRcHTfe a2jxLvi8nFe f1l6F567UCbAwo5e c47G62o6WGDe 5443C1Ti6URe 0fWfyz3SCnfNe 2E6f07Fu5chXe q78P82SfxZ8Xpe LmwKkAqYMS9ee OU54x2x2t4Age 05MDkg87\r\n"));

	}

}
