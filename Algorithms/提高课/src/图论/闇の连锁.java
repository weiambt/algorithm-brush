package 图论;
import java.util.*;

public class 闇の连锁 {
	int INF = 0x3f3f3f3f;
	static int N = 101000 , M = 2*N;
	static int[] chafen = new int[M];
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
			chafen[u] += chafen[j];
		}
	}
	
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		Arrays.fill(h,-1);
		//1.输入主要边
		for(int i=1;i<=n-1;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			add(a,b);
			add(b,a);
		}
		//2.初始化lca倍增数组
		dfs_lca(1,0);
		
		//3.输入附加边（树上差分+1）
		for(int i=1;i<=m;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			chafen[a]++;
			chafen[b]++;
			chafen[lca(a,b)]-=2;
		}
		//4.树上差分数组求和dfs
		dfs(1,0);
		//5.枚举所有节点，如果节点i
				//1.存在0条环 ans+=m
				//2.存在1条环 ans++
				//3.存在两条以上的环 不满足
		for(int i=2;i<=n;i++) {
			if(chafen[i]==0) ans += m;
			else if(chafen[i]==1) ans++;
		}
		System.out.println(ans);
	}

}
