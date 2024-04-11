package _00模板;
import java.util.*;

public class lca {
	static int INF = 0x3f3f3f3f;
	static int N = 101000,M = 20;
	static int[][] fa = new int[N][M];//2^20 = 1e6
	static int[] dep = new int[N];
	static int n,m;
	static long ans;
	static void dfs(int u,int father) {
		dep[u] = dep[father]+1;
		fa[u][0] = father;
		for(int i=1;i<M;i++) {
			fa[u][i] = fa[fa[u][i-1]][i-1];
		}
		for(int i=h[u];i!=-1;i=ne[i]) {
			int j = e[i];
			if(j!=father) {
				dfs(j,u);
			}
		}
	}
	static int lca(int a,int b) {
		if(dep[a]<dep[b]) {
			int t = a;
			a = b;
			b = t;
		}
		//a,b同一行
		for(int i=M-1;i>=0;i--) {
			if (dep[fa[a][i]]>=dep[b])
				a = fa[a][i];
		}
		if(a==b) return a;
		//一起跳
		for(int i=M-1;i>=0;i--) {
			if(fa[a][i] != fa[b][i]) {
				a = fa[a][i];
				b = fa[b][i];
			}
		}
		return fa[a][0];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		for(int i=1;i<=n;i++) {
			
		}
	}
	static int[] h = new int[N],e = new int[M],ne = new int[M],w = new int[M];
	static int idx;
	static void add(int a,int b,int c) {
		e[idx] = b;
		w[idx] = c ;
		ne[idx] = h[a];
		h[a] = idx++;
	}
	static void init(){
		Arrays.fill(h,-1);
	}
}
