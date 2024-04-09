package 提高课题目;
import java.util.*;
/**
 *  * 三维写法会TLE
 * 给定一个长度为 N 的数组，数组中的第 i 个数字表示一个给定股票在第 i 天的价格。
	设计一个算法来计算你所能获取的最大利润，你最多可以完成 k 笔交易。
		注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。一次买入卖出合为一笔交易。
 * @author ZW
 *
 */
public class 股票买卖IV {
	static int N = 101000;
	static int INF = 0x3f3f3f3f;
	static int w[] = new int[N];
	static int dp[][][] = new int[N][110][2];
	
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		for(int i=1;i<=n;i++) {
			w[i] = sc.nextInt();
		}
		
		//三维数组初始化
		for(int i=1;i<=n;i++) {
			for(int j=0;j<110;j++) {
				Arrays.fill(dp[i][j],-INF);
			}
		}
		
		//将所有从前i天中，一次也不交易，手中无货的情况初始化成0，因为这种状态，肯定是一点收益没有
        for(int i = 0 ; i <= n ; i ++ ) 
            dp[i][0][0] = 0;

		for(int i=1;i<=n;i++) {
			for(int j=1;j<=k;j++) {
				dp[i][j][0]= Math.max(dp[i-1][j][0], dp[i-1][j][1]+w[i]);
				dp[i][j][1]= Math.max(dp[i-1][j][1], dp[i-1][j-1][0]-w[i]);
			}
		}
		int ans=0;
		for(int j=1;j<=k;j++) {
			ans = Math.max(ans, dp[n][j][0]);
		}
		System.out.println(ans);
	}
}
