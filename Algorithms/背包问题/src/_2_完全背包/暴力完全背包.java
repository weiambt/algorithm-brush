package _2_完全背包;
import java.util.*;

public class 暴力完全背包 {
	static int N = 10100;
	static int[] v = new int[N];
	static int[] w = new int[N];
	static int[][] dp = new int[N][N];
	static int n,m;
	
	public static void cout(Object obj){
		String s = obj.toString();
		System.out.println(s);
	}
	
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		for(int i=1;i<=n;i++) {
			v[i] = sc.nextInt();
			w[i] = sc.nextInt();
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				for(int k=0;k*v[i]<=j;k++)
					dp[i][j]=Math.max(dp[i][j], dp[i-1][j-k*v[i]]+k*w[i]);
			}
		}
		cout(dp[n][m]);
		
	}
}
