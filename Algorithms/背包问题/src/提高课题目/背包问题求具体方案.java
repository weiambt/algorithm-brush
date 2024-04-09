package ��߿���Ŀ;
import java.util.*;
public class ������������巽�� {
	static int[] v = new int[1010];
	static int[] w = new int[1010];
	static int[][] dp = new int[1010][1010];
	
	public static void main(String[] ss) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		for(int i=1;i<=n;i++) {
			v[i] = sc.nextInt();
			w[i] = sc.nextInt();
		}
		
		for(int i=n;i>0;i--) {
			for(int j=0;j<=m;j++) {
				dp[i][j] = dp[i+1][j];
				if(j>=v[i])
					dp[i][j]=Math.max(dp[i][j], dp[i+1][j-v[i]]+w[i]);
			}
		}
		
		for(int i=1,j=m;i<=n;i++) {
			if(j>=v[i] && dp[i][j] == dp[i+1][j-v[i]]+w[i]) {
				System.out.print(i+" ");
				j -= v[i];
			}
		}

	}
}
