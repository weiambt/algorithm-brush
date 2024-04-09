package _9½²;
import java.util.*;
import java.math.*;
import java.io.*;

public class _01±³°üÎÊÌâ {
		static int INF = 0x3f3f3f3f;
		static int N = 110 , M = 20010;
		static int[] dp = new int[M+1];
		static int[] arr = new int[N];
		static int n,ans;

		public static void main(String[] sss) {
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			int flag = 0;
			for(int i=1;i<=n;i++) {
				arr[i] = sc.nextInt();
				if(arr[i]%2==1) flag = 1;
				dp[arr[i]] = 1;
			}
			if(flag==0) {
				System.out.println("INF");
				return;
			}
			for(int i=1;i<=M;i++) {
				for(int j=1;j<=n;j++) {
					if(i-arr[j]>0 && dp[i-arr[j]]==1) {
						dp[i]=1;
						break;
					}
				}
				if(dp[i]==0)ans++;
			}
			System.out.println(ans);
			
		}
}
