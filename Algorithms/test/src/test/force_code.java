package test;

import java.util.*;
import java.io.*;
import java.math.*;

public class force_code {
	static int INF = Integer.MAX_VALUE;
	static int mod = 1000000007 ;
	static int N = 30,M = 2*N;
	static int[] op = new int[N],select = new int[N],vis = new int[N];
	static int n,m;
	static long ans;
	
	static void dfs(int u) {
		if(u>n) {
			for(int i=1;i<=n;i++) System.out.print(select[i]+" ");
			System.out.println();
			ans ++;
			return;
		}
		if(op[u-1]==1) {
			int val = select[u-1]+1;
			if(vis[val]==0 && val<=n) {
				select[u] = val;
				vis[val] = 1;
				dfs(u+1);
				vis[val] = 0;
			}
			
		}else {
			for(int i=1;i<=n;i++) {
				if(vis[i]==1 || select[u-1]+1==i) continue;
				select[u] = i;
				vis[i] = 1;
				dfs(u+1);
				vis[i] = 0;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		
		n = sc.nextInt();
		
		for(int i=1;i<=n-1;i++) {
			op[i] = sc.nextInt();
		}
		for(int i=1;i<=n;i++) {
			Arrays.fill(vis, 0);
			vis[i] = 1;
			select[1] = i;
			dfs(2);
			vis[i] = 0;
		}
		System.out.println(ans);
	}
	static Scanner sc = new Scanner(System.in);

}