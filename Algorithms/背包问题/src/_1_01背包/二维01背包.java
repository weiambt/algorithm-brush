package _1_01±³°ü;
import java.util.*;

public class ¶þÎ¬01±³°ü {
	static int N = 1010;
	static int[] v = new int[N];
	static int[] w = new int[N];
	static int[][] dp = new int[N][N];
	static int n,m;
	
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		for(int i=1;i<=n;i++) {
			v[i]=sc.nextInt();
			w[i]=sc.nextInt();
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				dp[i][j]=dp[i-1][j];
				if(j>=v[i])
					dp[i][j]=Math.max(dp[i][j], dp[i-1][j-v[i]]+w[i]);
			}
		}
		System.out.println(dp[n][m]);
	}
}
