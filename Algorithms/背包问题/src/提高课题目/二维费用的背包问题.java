package ��߿���Ŀ;
import java.util.*;
public class ��ά���õı������� {
	static int N =1010;
	static int[] a = new int[N];//���
	static int[] b = new int[N];//����
	static int[] w = new int[N];
	static int[][] dp = new int[N][N];
	static int n,v,m;
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		 n =sc.nextInt();
		 v = sc.nextInt();
		 m = sc.nextInt();
		 for(int i=1;i<=n;i++) {
			 a[i] = sc.nextInt();
			 b[i] = sc.nextInt();
			 w[i] = sc.nextInt();
			 for(int j=v;j>=a[i];j--)
				 for(int k=m;k>=b[i];k--)
					 dp[j][k]=Math.max(dp[j][k], dp[j-a[i]][k-b[i]]+w[i]);
		 }
		 System.out.println(dp[v][m]);
		 
	}
}
