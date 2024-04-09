package _26线性dp;


import java.util.*;
import java.math.*;
import java.io.*;

public class 最大的和 {
	static int INF = 0x3f3f3f3f;
	static int Mod = (int) 1e9;
	static int N = 101000 , M = 2*N;
	static int n,t;
	static int[] arr = new int[N];
	static int[] dp1 = new int[N];//dp1[i] = x表示以arr[i]结尾的前缀子数组（1~i）的最大和
	static int[] dp2 = new int[N];//dp2[i] = x表示以arr[i]结尾的后缀子数组（i~n）的最大和
	static int[] ans1 = new int[N];//ans1[i] = x表示从1~i的子数组的最大和
	static int[] ans2 = new int[N];//ans2[i] = x表示从i~n的子数组的最大和

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		while(t-->0) {
			n = sc.nextInt();
			for(int i=1;i<=n;i++)
				arr[i] = sc.nextInt();
			dp1[0] = 0;
			ans1[0] = -INF;
			for(int i=1;i<=n;i++) {
				dp1[i] = Math.max(dp1[i-1]+arr[i], arr[i]);
				ans1[i] = Math.max(ans1[i-1], dp1[i]);
			}
			dp2[n+1] = 0;
			ans2[n+1] = -INF;
			for(int i=n;i>0;i--) {
				dp2[i] = Math.max(dp2[i+1]+arr[i], arr[i]);
				ans2[i] = Math.max(ans2[i+1], dp2[i]);
			}
			int ans = -INF;
			for(int i=1;i<n;i++)
				ans = Math.max(ans,ans1[i]+ans2[i+1]);
			System.out.println(ans);
		}
		
	}
	
}

