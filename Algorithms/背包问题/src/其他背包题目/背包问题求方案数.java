package 其他背包题目;
import java.util.*;
public class 背包问题求方案数 {
	static int N = 1010;
	static int MOD = 1000000007;
	static int[] v = new int[N];
	static int[] w = new int[N];
	static int[] dp = new int[N];
	static long[] cnt = new long[N];
	//cnt[j]表示前i个中选体积不超过j的最大价值的方案数
	//1.如果dp[i-1][j] > dp[i-1][j-v]+w 那么cnt[i][j] = cnt[i-1][j];
	//2.如果dp[i-1][j] < dp[i-1][j-v]+w 那么cnt[i][j] = cnt[i-1][j-v];
	//3.如果dp[i-1][j] == dp[i-1][j-v]+w 那么cnt[i][j] = cnt[i-1][j] + cnt[i-1][j-v];
	
	//初始化：cnt[0~m] = 1;表示从前0个中选体积为任意值的方案数为1
	
	//cnt[j]初始时就是cnt[i-1][j]，表示前i-1轮体积不超过j的方案数
	public static void main(String[] ss) {
		Scanner sc = new Scanner(System.in);
		int n,m;
		n = sc.nextInt();
		m = sc.nextInt();
		for(int i=1;i<=n;i++) {
			v[i] = sc.nextInt();
			w[i] = sc.nextInt();
		}
		
		//初始化！！表示从前0个物品中选，体积为任意值的方案数都是1
		for(int i=0;i<=m;i++) cnt[i]=1;
		
		for(int i=1;i<=n;i++) {
			for(int j=m;j>=v[i];j--) {
			    //选第i个的最大价值
				int x = dp[j-v[i]]+w[i];
				//如果选择第i个的最大价值比不选时的大
				if(dp[j] < x) {
					dp[j] = x;//更新最大价值
					cnt[j] = cnt[j-v[i]]%MOD;//个数函数就从cnt[j-v[i]]得到
				}
				//如果相等，那么cnt数组就需要加上两部分
				else if(dp[j]==x)
					cnt[j] = (cnt[j] + cnt[j-v[i]])%MOD;
				
			}
		}
// 		System.out.println(dp[m]);
		System.out.println(cnt[m]);
	}
}
