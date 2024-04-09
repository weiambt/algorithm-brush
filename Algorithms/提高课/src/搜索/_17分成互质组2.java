package 搜索;

import java.util.*;
import java.math.*;
import java.io.*;

public class _17分成互质组2 {
	static int INF = 0x3f3f3f3f;
	static int N = 109 , M = 2*N;
	static int n,m,ans=N;
	static int[] arr = new int[N];
	static ArrayList<Integer>[] group = new ArrayList[N];
	static int groupCnt = 0;
	static int gcd(int a,int b) {
		return b==0?a:gcd(b,a%b);
	}
	static boolean check(int gid,int x) {
		for(int i=0;i<group[gid].size();i++) {
			if(gcd(group[gid].get(i),x)!=1)
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
		
		//选择一个组加进去
		for(int i=0;i<groupCnt;i++) {
			if(check(i,arr[u])) {
				group[i].add(arr[u]);
				dfs(u+1);
				group[i].remove(group[i].size()-1);
			}
		}
		
		//新开一个组
		group[groupCnt] = new ArrayList<Integer>();
		group[groupCnt++].add(arr[u]);
		dfs(u+1);
		--groupCnt;
		group[groupCnt].remove(group[groupCnt].size()-1);
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
