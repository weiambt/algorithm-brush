package _25背包DP;
import java.util.*;
import java.math.*;
import java.io.*;

public class 最长上升子序列 {
		static int INF = 0x3f3f3f3f;
		static int N = 1010 , M = 2*N;
		static int[] arr = new int[N];
		static int[] dp = new int[N];

		static int n,m,ans = -INF;

		public static void main(String[] sss) {
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();

			for(int i=1;i<=n;i++) 
				arr[i] = sc.nextInt();
			for(int i=1;i<=n;i++) {
				dp[i] = 1;
				for(int j=1;j<i;j++)
					if(arr[i]>arr[j]) 
						dp[i] = Math.max(dp[i], dp[j]+1);	
				ans = Math.max(ans, dp[i]);
			}

			System.out.println(ans);
	
			
		}
}
