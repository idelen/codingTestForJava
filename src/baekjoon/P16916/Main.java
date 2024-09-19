package baekjoon.P16916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String S = br.readLine();
		String P = br.readLine();

		int result = 0;

		int[] lps = new int[P.length()];
		lps[0] = 0;
		int len = 0;
		int idx = 1;

		while (idx < P.length()) {
			if (P.charAt(idx) == P.charAt(len)) {
				len++;
				lps[idx] = len;
				idx++;
			} else {
				if (len != 0) {
					len = lps[len - 1];
				} else {
					lps[idx] = 0;
					idx++;
				}
			}
		}

		int sdx = 0;
		int pdx = 0;

		while (sdx < S.length()) {
			if (P.charAt(pdx) == S.charAt(sdx)) {
				sdx++;
				pdx++;
			}

			if (pdx == P.length()) {
				result = 1;
				break;
			} else if (sdx < S.length() && P.charAt(pdx) != S.charAt(sdx)) {
				if (pdx != 0) {
					pdx = lps[pdx - 1];
				} else {
					sdx++;
				}
			}
		}

		System.out.println(result);
	}
}
