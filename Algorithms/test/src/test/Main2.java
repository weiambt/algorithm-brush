package test;

import java.util.*;

public class Main2 {
	static HashMap<Character, Integer> mp = new HashMap<>();
	static char[] s = { 'R', 'O', 'Y', 'G', 'B', 'I', 'V' };
	static StringBuilder ans = new StringBuilder();

	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		for (int i = 0; i < n; i++) {

			if (i >= n - 3) {
				int j = i - (n - 3);
				mp.put(ans.charAt(j), mp.getOrDefault(ans.charAt(j), 0) + 1);
				while (mp.getOrDefault(s[cnt % 7], 0) != 0)
					cnt++;
				mp.put(s[cnt % 7], mp.getOrDefault(s[cnt % 7], 0) + 1);
			}

			ans.append(s[cnt % 7]);
			cnt = (cnt + 1) % 7;
		}
		System.out.println(ans);
	}
}
