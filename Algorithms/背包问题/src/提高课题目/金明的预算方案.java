package ��߿���Ŀ;
import java.util.*;
public class ������Ԥ�㷽�� {
	static int N =70;
	static int M = 40010;
	static int[][] v = new int[N][N];//��i���j���ļ۸�
	static int[][] w = new int[N][N];//��i���j���Ĵ���
	static int[] cnt = new int[N];//��i��ķ�������
	static int[][] dp = new int[N][M];
	static int idx=1;//�������
	static int[] find = new int[N];//����ʱ�ĵ�i����Ʒ���ڵ����find[i]
	
	static int[][] g = new int[N][N]; //��������룬��ΪҪ�õ������Դ�һ��
	public static void main(String[] ss) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();//��Ǯ��
		int n = sc.nextInt();//�ܸ���
		
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
		idx--;//�����һ��
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
