package _25背包DP;
import java.util.*;
import java.math.*;
import java.io.*;

public class 最长公共子序列 {
		static int INF = 0x3f3f3f3f;
		static int N = 1010 , M = 2*N;
		static int[][] dp = new int[N][N];

		static int n,m,ans = -INF;

		public static void main(String[] sss) {
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			m = sc.nextInt();
			char[] a = (" "+ sc.next()).toCharArray();
			char[] b = (" "+ sc.next()).toCharArray();
			
//			dp[0][0] = 1;
			
			for(int i=1;i<=n;i++)
				for(int j=1;j<=m;j++) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
					if(a[i]==b[j])
						dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]+1);
				}
	
			System.out.println(dp[n][m]);
		}
}
