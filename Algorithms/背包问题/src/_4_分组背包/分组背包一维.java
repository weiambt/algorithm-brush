package _4_分组背包;
import java.util.*;
/**
 * 分组背包问题是一个比较大的问题，只能三重循环。（多重背包是分组背包问题的特例）
 * @author ZW
 *
 */
public class 分组背包一维 {
	static int N = 110;
	static int[][] v = new int[N][N];
	static int[][] w = new int[N][N];
	static int[] count = new int[N];//第i组有几个
	static int[] dp = new int[N];
	static int n,m;
	
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		for(int i=1;i<=n;i++) {
			count[i] = sc.nextInt();
			for(int j=1;j<=count[i];j++) {
				v[i][j] = sc.nextInt();
				w[i][j] = sc.nextInt();
			}	
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=m;j>0;j--) {
				for(int k=1;k<=count[i];k++) {
					if(j>=v[i][k])
						dp[j]=Math.max(dp[j], dp[j-v[i][k]]+w[i][k]);
				}
			}
		}
		System.out.println(dp[m]);
			
		
	}
}
