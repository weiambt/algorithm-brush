package _03讲_数学与简单DP;
import java.util.*;
import java.math.*;
import java.io.*;

public class _01背包问题 {
		static int INF = 0x3f3f3f3f;
		static int N = 10100 , M = 2*N;
		static int[] dp = new int[N];
		static int[] v = new int[N];
		static int[] w = new int[N];
		static int n,m;

		public static void main(String[] sss) {
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			m = sc.nextInt();

			for(int i=1;i<=n;i++) {
				v[i] = sc.nextInt();
				w[i] = sc.nextInt();
			}
			for(int i=1;i<=n;i++)
				for(int j=m;j>=v[i];j--)
					dp[j] = Math.max(dp[j], dp[j-v[i]]+w[i]);
			
			System.out.println(dp[m]);
			
		}
}
