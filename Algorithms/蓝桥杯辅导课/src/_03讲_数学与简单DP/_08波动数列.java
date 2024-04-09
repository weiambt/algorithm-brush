package _03讲_数学与简单DP;
import java.util.*;
import java.math.*;
import java.io.*;

public class _08波动数列 {
		static int mod = 100000007;
		static int N = 1010 , M = 2*N;
		static int[][] dp = new int[N][N];
		static int n,s,a,b;
		static int getMod(int a,int mod) {
			return (a%mod + mod)%mod;
		}
		public static void main(String[] sss) {
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			s = sc.nextInt();
			a = sc.nextInt();
			b = sc.nextInt();
			dp[0][0]=1;
			for(int i=1;i<n;i++)//d1 ... dn-1
				for(int j=0;j<n;j++) {
					dp[i][j] = (dp[i][j] + dp[i-1][getMod(j-i*a,n)])%mod;
					dp[i][j] = (dp[i][j] + dp[i-1][getMod(j+i*b,n)])%mod;
				}
					
			System.out.println(dp[n-1][getMod(s,n)]);
		}
}
