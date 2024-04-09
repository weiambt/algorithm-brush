package Í¼ÂÛ;
import java.util.*;
import java.math.*;
import java.io.*;

public class ¿³Ê÷ {
	static int INF = 0x3f3f3f3f;
	static int N = 101000 , M = 2*N;
	static int[][] fa = new int[N][22];
	static int[] dep = new int[N];
	static int[] chafen = new int[N];
	static int[] h = new int[N],e = new int[M],ne = new int[M],w = new int[M];
	static int idx;
	static int n,m;
	static long ans;
	static void add(int a,int b,int c) {
		e[idx] = b;
		w[idx] = c;
		ne[idx] = h[a];
		h[a] = idx++;
	}
	static void dfs(int u,int father) {
		dep[u] = dep[father]+1;
		fa[u][0] = father;
		for(int i=1;i<=20;i++) {
			fa[u][i] = fa[fa[u][i-1]][i-1];
		}
		for(int i=h[u];i!=-1;i=ne[i]) {
			int j = e[i];
			if(j==father) continue;
			dfs(j,u);
		}
	}
	static int lca(int x,int y) {
		if(dep[x]<dep[y]) {
			int t = x;
			x = y;
			y = t;
		}
		for(int i=20;i>=0;i--) {
			if(dep[fa[x][i]]>=dep[y])
				x = fa[x][i];
		}
		if(x==y) return y;
		for(int i=20;i>=0;i--) {
			if(fa[x][i]!=fa[y][i]) {
				x = fa[x][i];
				y = fa[y][i];
			}
		}
//		System.out.println(x+" "+y+" "+fa[x][0]);
		return fa[x][0];
	}
	static void dfs2(int u,int father) {
		for(int i=h[u];i!=-1;i=ne[i]) {
			int j = e[i];
			if(j==father) continue;
			dfs2(j,u);
			chafen[u]+=chafen[j];
//			System.out.println(j+" "+chafen[j]);
			if(chafen[j]==m) {
				ans = Math.max(ans,w[i]);
			}
		}
	}

	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		Arrays.fill(h,-1);
		n = sc.nextInt();
		m = sc.nextInt();
		for(int i=1;i<=n-1;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			add(a,b,i);
			add(b,a,i);
		}
		dfs(1,0);
		for(int i=1;i<=m;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
//			System.out.println(a+" "+b);
			int lca = lca(a, b);
//			System.out.println(lca);
			chafen[a]++;
			chafen[b]++;
			chafen[lca]-=2;
		}
		dfs2(1,0);
		System.out.println(ans);
	}

}
