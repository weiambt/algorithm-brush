package 提高课题目;
import java.util.*;

public class _03宠物小精灵之收服 {
	static int N = 1010;
	static int[] a = new int[N];//精灵球数
	static int[] b = new int[N];//体力消耗
	static int n,m,k;
	static int[][] dp = new int[N][N];
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		k = sc.nextInt();//初始精灵球数量
		m = sc.nextInt();//初始体力
		n = sc.nextInt();//精灵数量
		
		for(int i=1;i<=n;i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=k;j>=0;j--) {
				for(int t=m;t>=0;t--) {
					if(j>=a[i] && t >= b[i])
						dp[j][t] = Math.max(dp[j][t],dp[j-a[i]][t-b[i]]+1);
				}
			}
		}
		System.out.print(dp[k][m-1]);//体力降为0时，皮卡丘就寄了，就停止工作了，所以最多消耗m-1个体力
		if(dp[k][m-1]==0) System.out.printf(" %d",m);
		else
			for(int i=1;i<=m-1;i++) {
				if(dp[k][i]==dp[k][m-1]) {//从小到大枚举体积，找到第一个抓到的个数等于答案的那个体积
					System.out.printf(" %d",m-i);
					break;
				}
			}
	}
}
