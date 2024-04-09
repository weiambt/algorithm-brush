package _3_多重背包;
import java.util.*;
/**
 * 多重背包是无穷背包的分支，每个物品有有限个：s[i]个。
 * 多重背包有两个优化：1.二进制优化
 * 					 2.单调队列优化（难）
 * @author ZW
 *
 */

public class 暴力多重背包 {
	static int N = 13000;
	static int[] v = new int[N];
	static int[] w = new int[N];
	static int[] s = new int[N];
	static int[][] dp = new int[N][N];
	static int n,m;
	
	public static void main(String[] str) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		for(int i=1;i<=n;i++) {
			v[i] = sc.nextInt();
			w[i] = sc.nextInt();
			s[i] = sc.nextInt();
		}
		
		for(int i=1;i<=n;i++)
			for(int j=1;j<=m;j++) {
				for(int k=0;k<=s[i] && j>=k*v[i];k++)
					dp[i][j]=Math.max(dp[i][j], dp[i-1][j-k*v[i]]+k*w[i]);
			}
		System.out.println(dp[n][m]);
	}
}
