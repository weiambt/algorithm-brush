package _24组合数学;

import java.util.*;

public class 整数划分 {
	static int INF = 0x3f3f3f3f;
	static int N = 3010 , M = 2*N;
	static int Mod = 1000000007;
	static int n;
	static long[][] dp = new long[N][N];
	static long[][] sum = new long[N][N];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		Arrays.fill(sum[0], 1);
		for(int i=1;i<=n;i++) {
			int tmp = 0;
			for(int j=1;j<=i;j++) {
				if(j==1) 
					dp[i][j] = 1;
				else{
					int mi = Math.min(j, i-j);
					dp[i][j] = sum[i-j][mi];
				}
				tmp += dp[i][j];
				sum[i][j] = tmp;
			}
		}
		System.out.println(sum[n][n]);
	}
	
}

