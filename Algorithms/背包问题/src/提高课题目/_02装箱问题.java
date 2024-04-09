package 提高课题目;
import java.util.*;
/**
 * 价值函数是体积的01背包问题
 * @author ZW
 *
 */
public class _02装箱问题 {
	static int N = 50;
	static int M = 20200;
	static int[] v = new int[N];
	static int[] dp = new int[M];
	static int m,n;
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		
		for(int i=1;i<=n;i++) {
			v[i] = sc.nextInt();
		}
		
		for(int i=1;i<=n;i++)
			for(int j=m;j>=v[i];j--)
				dp[j]=Math.max(dp[j], dp[j-v[i]]+v[i]);
		//dp[m]表示体积为m的背包最多装下的物品的总体积
		//m-dp[m]就是升序的最小的空间
		System.out.println(m-dp[m]);
	}
}
