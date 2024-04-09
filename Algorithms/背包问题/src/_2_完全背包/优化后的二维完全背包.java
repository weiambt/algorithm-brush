package _2_��ȫ����;

import java.util.Scanner;

public class �Ż���Ķ�ά��ȫ���� {
	static int N = 10100;
	static int[] v = new int[N];
	static int[] w = new int[N];
	static int[][] dp = new int[N][N];
	static int n,m;
	
	public static void cout(Object obj){
		String s = obj.toString();
		System.out.println(s);
	}
	
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		for(int i=1;i<=n;i++) {
			v[i] = sc.nextInt();
			w[i] = sc.nextInt();
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				dp[i][j]=dp[i-1][j];
				if(j>=v[i])
					dp[i][j]=Math.max(dp[i][j], dp[i][j-v[i]]+w[i]);
			}
		}
		cout(dp[n][m]);
		
	}
}
