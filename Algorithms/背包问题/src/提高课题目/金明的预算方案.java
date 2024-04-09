package 提高课题目;
import java.util.*;
public class 金明的预算方案 {
	static int N =70;
	static int M = 40010;
	static int[][] v = new int[N][N];//第i组第j个的价格
	static int[][] w = new int[N][N];//第i组第j个的代价
	static int[] cnt = new int[N];//第i组的方案个数
	static int[][] dp = new int[N][M];
	static int idx=1;//组数编号
	static int[] find = new int[N];//输入时的第i个商品所在的组号find[i]
	
	static int[][] g = new int[N][N]; //输入的输入，因为要用到，所以存一下
	public static void main(String[] ss) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();//总钱数
		int n = sc.nextInt();//总个数
		
		int vv,p,q;
		for(int i=1;i<=n;i++) {
			g[i][0] = sc.nextInt();
			g[i][1] = sc.nextInt();
			g[i][2] = sc.nextInt();
		}
		
		for(int i=1;i<=n;i++) {
			if(g[i][2]==0) {
				w[idx][cnt[idx]] = g[i][0]*g[i][1];
				v[idx][cnt[idx]] = g[i][0];
				find[i]=idx;
				cnt[idx]++;
				idx++;
				
			}else {
				int pa = g[i][2];
				int zuHao = find[pa];
				
				w[zuHao][cnt[zuHao]] = w[zuHao][0] + g[i][0] * g[i][1];
				v[zuHao][cnt[zuHao]] = g[i][0] + g[pa][0];
				cnt[zuHao]++;
				
				if(cnt[zuHao]==3) {
					for(int k=1;k<i;k++) {
						if(g[k][2]==g[i][2]) {
							w[zuHao][cnt[zuHao]] = w[zuHao][cnt[zuHao]-1] + g[k][0] * g[k][1];
							v[zuHao][cnt[zuHao]] = v[zuHao][cnt[zuHao]-1] + g[k][0];
							cnt[zuHao]++;
							break;
						}
					}
				}
			}
		}
		idx--;//多加了一个
//		System.out.println(idx);
//		for(int i=1;i<=idx;i++) {
//			for(int k=0;k<cnt[i];k++)
//				System.out.print(v[i][k]+" ");
//			System.out.println();
//		}
		
		for(int i=1;i<=idx;i++) {
			for(int j=1;j<=m;j++) {
				dp[i][j] = dp[i-1][j];
				for(int k=0;k<cnt[i] && v[i][k]<=j;k++) {
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-v[i][k]]+w[i][k]);
				}
			}
		}
		System.out.println(dp[idx][m]);
		
		

	}
}
