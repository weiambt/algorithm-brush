package _25背包DP;
import java.util.*;
import java.math.*;
import java.io.*;

public class 分组背包 {
		static int INF = 0x3f3f3f3f;
		static int N = 1010 , M = 2*N;
		static int[] dp = new int[N];
		static int[][] v = new int[N][N];
		static int[][] w = new int[N][N];
		static int[] cnt = new int[N];
		static int n,m;

		public static void main(String[] sss) {
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			m = sc.nextInt();

			for(int i=1;i<=n;i++) {
				cnt[i] = sc.nextInt();
				for(int j=1;j<=cnt[i];j++) {
					v[i][j] = sc.nextInt();
					w[i][j] = sc.nextInt();
				}
			}

			for(int i=1;i<=n;i++) {
				for(int j=m;j>0;j--) {
					for(int k=1;k<=cnt[i];k++) {
						if(j>=v[i][k])
							dp[j] = Math.max(dp[j], dp[j-v[i][k]]+w[i][k]);
					}
				}
			}
			System.out.println(dp[m]);
			
		}
}
