package 提高课题目;

import java.util.*;
/**
 * 数组中的第 i 个数字表示一个给定股票在第 i 天的价格。设计一个算法计算出最大利润
 * 	你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
	卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * @author ZW
 *
 */

public class 股票买卖V {
	static int N = 101000;
	static int INF = 0x3f3f3f3f;
	static int w[] = new int[N];
	static int dp[][] = new int[N][3];
	//这题把上一题的空仓状态再分成两个两个状态
	//dp[i][j]表示前i个，第i个的状态是j的最大值
	//0:有货，代表持仓
	//1:空仓第一天，代表冷冻期
	//2:空仓第二天，代表解封后
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int i=1;i<=n;i++) {
			w[i] = sc.nextInt();
		}
		
//      空仓第二天的状态是起点，剩下两个状态是非法状态
//		for(int i=0;i<=n;i++) {
//			Arrays.fill(dp[i],-INF);
//		}
		dp[0][0]=-INF;
 		dp[0][1]=-INF; 
        dp[0][2]=0;

		for(int i=1;i<=n;i++) {
			dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2]-w[i]);
			dp[i][1] = dp[i-1][0]+w[i];
			dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1]);
		}
		
		System.out.println(Math.max(dp[n][1], dp[n][2]));
	}
}
