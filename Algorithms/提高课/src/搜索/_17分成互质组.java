package 搜索;

import java.util.*;
import java.math.*;
import java.io.*;

public class _17分成互质组 {
	static int INF = 0x3f3f3f3f;
	static int N = 109 , M = 2*N;
	static int n,m,ans=N;
	static int[] arr = new int[N];
	static int[][] group = new int[N][N];
	static int[] cnt = new int[N];
	static int groupCnt = 0;
	static int gcd(int a,int b) {
		return b==0?a:gcd(b,a%b);
	}
	static boolean check(int gid,int x) {
		for(int i=0;i<cnt[gid];i++) {
			if(gcd(group[gid][i],x)!=1)
				return false;
		}
		return true;
	}
	
	static void dfs(int u) {
		if(groupCnt>=ans) return;
		if(u==n) {
			ans = groupCnt;
			return;
		}
		
		for(int i=0;i<groupCnt;i++) {
			if(check(i,arr[u])) {
				group[i][cnt[i]++] = arr[u];
				dfs(u+1);
				cnt[i]--;		
			}
		}
		
		//新开一个组
		group[groupCnt][0] = arr[u];
		cnt[groupCnt]++;
		groupCnt++;
		dfs(u+1);
		groupCnt--;
		cnt[groupCnt]--;
	}
	
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=0;i<n;i++)
			arr[i] = sc.nextInt();
		dfs(0);
		System.out.println(ans);
	}
}
