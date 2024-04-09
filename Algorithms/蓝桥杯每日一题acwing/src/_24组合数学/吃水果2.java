package _24组合数学;

import java.util.*;

public class 吃水果2 {
	static int INF = 0x3f3f3f3f;
	static int Mod = 998244353;
	static int N = 3010 , M = 2*N;
	static int n,m,k;
	static long[][] dp = new long[N][N];
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();

		for(int i=1;i<=n;i++)
			dp[i][0] = m;
		for(int i=2;i<=n;i++)
			for(int j=1;j<=k && j<=i;j++)
				dp[i][j] = dp[i-1][j-1]*(m-1) + dp[i-1][j];
		System.out.println(dp[n][k]);
	}
	
}

