package 提高课题目;
import java.util.*;

public class _06货币系统2 {
	static int N = 20;
	static int M = 3010;
	static int[] arr = new int[N];
	static long[] dp = new long[M];
	static int n,m;
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		for(int i=1;i<=n;i++)
			arr[i] = sc.nextInt();
		
		dp[0]=1;
		
		for(int i=1;i<=n;i++) 
			for(int j=arr[i];j<=m;j++) 
				dp[j] += dp[j-arr[i]];
		
		
		System.out.println(dp[m]);
	}
}
