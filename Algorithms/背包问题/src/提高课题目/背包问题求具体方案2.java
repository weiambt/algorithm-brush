package ��߿���Ŀ;
import java.util.*;
/**
 * WA����
 * �����Ŵ��յ�����㣬���Ǻ��񲻶�
 * �Ӻ���ѡ�����˼·���ԣ�������ܲ�ѡ�Ͳ�ѡ������
 * @author ZW
 *
 */
public class ������������巽��2 {
	static int[] v = new int[1010];
	static int[] w = new int[1010];
	static int[][] dp = new int[1010][1010];
	
	public static void main(String[] ss) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		for(int i=1;i<=n;i++) {
			v[i] = sc.nextInt();
			w[i] = sc.nextInt();
		}
		
		for(int i=1;i<=n;i++)
			for(int j=1;j<=m;j++) {
				dp[i][j] = dp[i-1][j];
				if(j>=v[i])
					dp[i][j]=Math.max(dp[i][j], dp[i-1][j-v[i]]+w[i]);
			}
		
		int[] vis = new int[n+1];
		for(int i=n,j=m;i>0;i--) {
			if(j>=v[i] && dp[i-1][j]==dp[i-1][j-v[i]]+w[i]) {
				//��ѡ
				vis[i]=1;
			}
			else if(j>=v[i] && dp[i][j] == dp[i-1][j-v[i]]+w[i]) {
				j -= v[i];
			}
			else {
				//��ѡ
				vis[i]=1;
			}
		}
		
		for(int i=1;i<=n;i++) 
			if(vis[i]==0)
				System.out.print(i+" ");
		
		
		
	

	}
}
