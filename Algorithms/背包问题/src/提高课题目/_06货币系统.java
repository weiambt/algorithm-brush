package 提高课题目;
import java.util.*;

public class _06货币系统 {
	static int N = 20;
	static int M = 3010;
	static int[] arr = new int[N];
	static long[][] dp = new long[N][M];
	static int n,m;
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		for(int i=1;i<=n;i++)
			arr[i] = sc.nextInt();
		
		for(int i=0;i<=n;i++) dp[i][0]=1;
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				for(int k=0;k*arr[i]<=j;k++) {
					dp[i][j] += dp[i-1][j-k*arr[i]];
				}
			}
		}
		
		System.out.println(dp[n][m]);
	}
}
