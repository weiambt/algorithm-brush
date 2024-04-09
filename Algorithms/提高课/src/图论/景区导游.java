package 图论;
import java.util.*;
import java.math.*;
import java.io.*;

public class 景区导游 {
	static int INF = 0x3f3f3f3f;
	static int N = 101000 , M = 2*N;
	static int[][] fa = new int[N][22];
	static int[] dep = new int[N],order = new int[N];
	static long[] dist = new long[N];
	static int[] h = new int[N],e = new int[M],ne = new int[M],w = new int[N];
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
			dist[j] = dist[u] + w[i];
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
		return fa[x][0];
	}
	static long getDist(int x,int y) {
		if(x==0 || y==0) return 0;
		int lca = lca(x,y);
		return dist[x]+dist[y]-2*dist[lca];
	}

	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		Arrays.fill(h,-1);
		n = sc.nextInt();
		m = sc.nextInt();
		for(int i=1;i<=n-1;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			add(a,b,c);
			add(b,a,c);
		}
		dfs(1,0);
		for(int i=1;i<=m;i++) {
			order[i] = sc.nextInt();
			if(i>1) {
				ans += getDist(order[i],order[i-1]);
			}
		}
		for(int i=1;i<=m;i++) {
			System.out.print(ans - getDist(order[i-1],order[i]) - getDist(order[i],order[i+1]) + getDist(order[i-1],order[i+1])+" ");
		}
	}

}
