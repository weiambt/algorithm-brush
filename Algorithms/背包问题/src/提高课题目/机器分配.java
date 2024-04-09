package 提高课题目;
import java.util.*;
/**
 * 分组背包最大值、并求方案
 * @author ZW
 *
 */
public class 机器分配 {
	static int N =20;
	static int[][] v = new int[N][N];
	static int[][] w = new int[N][N];
	static int[][] dp = new int[N][N];
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				v[i][j] = j;
				w[i][j] = sc.nextInt();
				dp[i][j] = dp[i-1][j];
				for(int k=1;k<=m;k++) {
					dp[i][j]=Math.max(dp[i][j], dp[i-1][j-v[i][k]]+w[i][k]);
				}
			}
		}
		System.out.println(dp[n][m]);
		
		for(int i=n,j=m;i>0;i--) {
			int k,flag=0;
			for(k=1;k<=m;k++) {
				if(j>=v[i][k] && dp[i][j]==dp[i-1][j-v[i][k]]+w[i][k]) {
					j -= v[i][k];
					flag=1;
					//val[i] = v[i][k];//第i个公司选择的数量
					break;
				}
			}
			if(flag==1)
				System.out.println(i+" "+ v[i][k]);
			else
				System.out.println(i+" 0");

		}
	}
}
