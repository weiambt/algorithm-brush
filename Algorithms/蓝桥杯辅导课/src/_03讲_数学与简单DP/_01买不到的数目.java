package _03讲_数学与简单DP;
import java.util.*;
import java.math.*;
import java.io.*;

public class _01买不到的数目 {
		static int INF = 0x3f3f3f3f;
		static int N = 1010000 , M = 2*N;
		static int[] dp = new int[N];
		static int n,m;

		public static void main(String[] sss) {
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			m = sc.nextInt();
			int mi = Math.min(n, m);
			int ma = Math.max(n, m);
			dp[0] = 1;
			int ans = 0;
			for(int i=mi;i<n*m;i++) {
				if(dp[i-mi]==1 || (i>=ma && dp[i-ma]==1)) {
					dp[i] = 1;
				}else ans = i;
			}
			System.out.println(ans);
		}
}
