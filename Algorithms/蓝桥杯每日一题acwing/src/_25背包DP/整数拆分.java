package _25背包DP;

import java.util.*;
import java.math.*;
import java.io.*;

public class 整数拆分 {
	static int INF = 0x3f3f3f3f;
	static int Mod = (int) 1e9;
	static int N = 1010000 , M = 2*N;
	static int n,cnt=1;
	static int[] nums = new int[N];
	static long[][] dp = new long[40][N];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		int k = 1;
		while(k<=N) {
			nums[cnt++] = k;
			k = k*2;
		}
		for(int i=0;i<40;i++)
			dp[i][0] = 1;
		for(int i=1;i<cnt;i++) {
			for(int j=1;j<=n;j++) {
				dp[i][j] = dp[i-1][j]%Mod;
				if(j>=nums[i]) dp[i][j] = (dp[i][j] + dp[i][j-nums[i]])%Mod;
			}
		}
		System.out.println(dp[cnt-1][n]);
	}
	
}

