package _202302.acwing._96;


import java.util.*;
import java.io.*;
import java.math.*;
public class B {
	static int INF = 0x3f3f3f3f;
	static int N = 100100,M = 2*N;
	static int n,m,v0,w0;
	static int[] v = new int[N];
	static int[] w = new int[N];
	static int[] cnt = new int[N];
	static int[] dp = new int[N];
	
	public static void main(String[] args) {
		Scanner sc =  new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		n = sc.nextInt();
		m = sc.nextInt();
		v0 = sc.nextInt();
		w0 = sc.nextInt();
		
		v[1] = v0;
		w[1] = w0;
		cnt[1] = n/v0;
		

		for(int i=2;i<=m+1;i++) {
			int l = sc.nextInt();
			int h = sc.nextInt();
			v[i] = sc.nextInt();
			w[i] = sc.nextInt();
			cnt[i] = Math.min(l/h, n/v[i]);
		}
		
		for(int i=1;i<=m+1;i++) {
			for(int j=n;j>=0;j--) {
				for(int k=0;k<=cnt[i] && k*v[i]<=j;k++) {
					dp[j] = Math.max(dp[j], dp[j-k*v[i]]+k*w[i]);
				}
			}
		}
		System.out.println(dp[n]);
	}
}
