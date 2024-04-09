import java.util.*;

public class Main {
	
	static int N = 1010;
	
	static int[] v = new int[N];
	static int[] w = new int[N];
	static int[] cnt = new int[N];
	static int[][] dp = new int[N][N];
	
	static int n,m;
	
	public static void main(String[] sss) {	
		Scanner sc = new Scanner(System.in);
	
		n = sc.nextInt();
		m = sc.nextInt();
		
		for(int i=1;i<=n;i++) {
			v[i]=sc.nextInt();w[i]=sc.nextInt();cnt[i]=sc.nextInt();
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				for(int k=0;k<=cnt[i] && j>=k*v[i];k++) {
					dp[i][j]=Math.max(dp[i][j], dp[i-1][j-k*v[i]]+k*w[i]);
				}
			}
		}
		System.out.println(dp[n][m]);

		
	}
}
