package _99备战国赛;

import java.util.*;
import java.math.*;
import java.io.*;

public class 完美牛棚 {
	static int INF = 0x3f3f3f3f;
	static int N = 1010 , M = 80100;
	static long[] arr = new long[N],tree = new long[N];
	static int n,m,ans;
	static int[] match = new int[N],vis = new int[N];
	static int[] h = new int[N],e = new int[M],ne = new int[M];
	static int idx;
	static void add(int a,int b) {
		e[idx] = b;
		ne[idx] = h[a];
		h[a] = idx++;
	}
	//奶牛向右匹配是否成功
	static boolean find(int u) {
		for(int i=h[u];i!=-1;i=ne[i]) {
			int j = e[i];
			if(vis[j]==0) {
				vis[j] = 1;
				if(match[j]==0 || find(match[j])) {
					match[j] = u;
					return true;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		Arrays.fill(h,-1);
		for(int i=1;i<=n;i++) {
			int cnt = sc.nextInt();
			while(cnt-->0) {
				int j = sc.nextInt()+300;
				add(i,j);
				add(j,i);
			}
		}
		for(int i=1;i<=n;i++) {
			Arrays.fill(vis,0);
			if(find(i))
				ans++;
		}
		System.out.println(ans);
		
	}
	
}

