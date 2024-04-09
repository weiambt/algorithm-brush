package 提高课题目;
import java.util.*;

public class _04数字组合 {
	static int N = 110;
	static int M = 10100;
	static int[] arr = new int[N];
	static int[][] dp = new int[N][M];
	//dp[j]表示前i个中选，和为j的方案数
	//dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i]]
	static int n,m;
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		for(int i=1;i<=n;i++) 
			arr[i]=sc.nextInt();
		
		//dp初始化，前i个中选和为0的方案数是1（相当于arr[i]==j时ans++）
		for(int i=0;i<=n;i++) dp[i][0]=1;
		
		for(int i=1;i<=n;i++) {
			for(int j=0;j<=m;j++) {
				dp[i][j]=dp[i-1][j];
//				if(arr[i]==j)
//					dp[i][j]++;
				if(j>=arr[i])
					dp[i][j]+=dp[i-1][j-arr[i]];
//				System.out.println(i+" "+j+" "+dp[i][j]);
			}
		}

		System.out.println(dp[n][m]);
		
	}
}
