package 图论;
import java.util.*;
import java.io.*;
public class 松鼠的新家 {
	int INF = 0x3f3f3f3f;
	static int N = 401000 , M = 2*N;
	static int[] chafen = new int[M],order = new int[N];
	static int[][] fa = new int[N][22];
	static int[] dep = new int[N];
	static int[] h = new int[N], e = new int[M],ne = new int[M];
	static int idx;
	static int n,m;
	static long ans;
	static void add(int a,int b) {
		e[idx] = b;
		ne[idx] = h[a];
		h[a] = idx++;
	}
	static void dfs_lca(int u,int father) {
		dep[u] = dep[father] + 1;
		fa[u][0] = father;
		for(int i=1;i<=20;i++) {
			fa[u][i] = fa[fa[u][i-1]][i-1];
		}
		for(int i=h[u];i!=-1;i=ne[i]) {
			int j = e[i];
			if(j==father) continue;
			dfs_lca(j, u);
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
	static void dfs(int u,int father) {
		for(int i=h[u];i!=-1;i=ne[i]) {
			int j = e[i];
			if(j==father) continue;
			dfs(j,u);
			chafen[u]+=chafen[j];
		}
	}
	public static void main(String[] args) throws IOException{
		Read sc = new Read();
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		n = sc.nextInt();
		Arrays.fill(h,-1);
		for(int i=1;i<=n;i++) {
			order[i] = sc.nextInt();
		}
		for(int i=1;i<=n-1;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			add(a,b);
			add(b,a);
		}
		dfs_lca(order[1], 0);

		for(int i=1;i<=n-1;i++) {
			int x = order[i];
			int y = order[i+1];
			int lca = lca(x,y);
			chafen[x]++;
			chafen[y]++;
			chafen[lca]--;
			chafen[fa[lca][0]]--;
		}
		dfs(order[1],0);
		//树上差分
		for(int i=2;i<=n-1;i++)
			chafen[order[i]] --;
		chafen[order[n]]--;
		for(int i=1;i<=n;i++) {
			out.println(chafen[i]);
		}
	}
}
class Read{
	StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
	int nextInt() throws IOException {
		st.nextToken();
		return (int)st.nval;
	}
}
