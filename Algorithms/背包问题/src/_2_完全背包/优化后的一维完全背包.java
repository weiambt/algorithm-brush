package _2_完全背包;

import java.util.Scanner;

public class 优化后的一维完全背包 {
	static int N = 10100;
	static int[] v = new int[N];
	static int[] w = new int[N];
	static int[] dp = new int[N];
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
		
		for(int i=1;i<=n;i++)
			for(int j=v[i];j<=m;j++)
				dp[j]=Math.max(dp[j], dp[j-v[i]]+w[i]);
		cout(dp[m]);
		
	}
}
