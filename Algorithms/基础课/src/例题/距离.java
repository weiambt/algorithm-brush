package ¿˝Ã‚;
import java.util.*;

public class æ‡¿Î {
	static int INF = 0x3f3f3f3f;
	static int N = 10100 , M = 2*N;
	static long ans;
	static int[] dep = new int[N],dist = new int[N];
	static int[][] fa = new int[N][20];
	static int n,m,k;
	static int[] h = new int[N],e = new int[M],ne = new int[M],w = new int[M];
	static int idx;
	static void add(int a,int b,int c) {
		e[idx] = b;
		ne[idx] = h[a];
		w[idx] = c;
		h[a] = idx++;
	}
	static void init() {
		Arrays.fill(h,-1);
	}
	static void dfs(int u,int father) {
		dep[u] = dep[father]+1;
		fa[u][0] = father;
		for(int i=1;i<19;i++)
			fa[u][i] = fa[fa[u][i-1]][i-1];
		for(int i=h[u];i!=-1;i=ne[i]) {
			int j = e[i];
			if(j==father) continue;
			dist[j] = dist[u] + w[i];
			dfs(j,u);
		}
	}
	static int lca(int x,int y) {
		if(dep[x] < dep[y]) {
			int t = x;
			x = y;
			y = t;
		}
		for(int i=19;i>=0;i--) {
			if(dep[fa[x][i]] >= dep[y])
				x = fa[x][i];
		}
		if(x==y) return y;
		for(int i=19;i>=0;i--) {
			if(fa[x][i] != fa[y][i]) {
				x = fa[x][i];
				y = fa[y][i];
			}
		}
		return fa[x][0];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		init();
		for(int i=1;i<=n-1;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			add(a,b,c);
			add(b,a,c);
		}
		dfs(1,0);
		while(m-->0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			ans = dist[x] + dist[y] - 2*dist[lca(x,y)];
			System.out.println(ans);
		}
		
	}
}
