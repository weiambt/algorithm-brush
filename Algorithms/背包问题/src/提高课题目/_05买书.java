package 提高课题目;
import java.util.*;

/**
 * 小明手里有n元钱全部用来买书，书的价格为10元，20元，50元，100元。
 * 问小明有多少种买书方案？（每种书可购买多本）
 * 
 * 完全背包的暴力解法
 * dp[i][j]表示恰好能够买到j元钱的方案数
 * dp[i][j] = dp[i-1][j] + dp[i-1][j-k*arr[i]]
 * @author ZW
 *
 */
public class _05买书 {
	static int N =1010;
	static int[] arr = {0,10,20,50,100};
	static int[][] dp = new int[5][N];
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		int m;
		m = sc.nextInt();
		for(int i=0;i<=4;i++) dp[i][0]=1;
		for(int i=1;i<=4;i++) {
			for(int j=1;j<=m;j++) {
				for(int k=0;k*arr[i]<=j;k++) {
					dp[i][j]+=dp[i-1][j-k*arr[i]];
				}
			}
		}
		System.out.println(dp[4][m]);
	}
}
