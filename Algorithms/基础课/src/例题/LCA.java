package 例题;

import java.util.*;
import java.math.*;
import java.io.*;

public class LCA {
		static int INF = 1000000007;
		static int N = 41000 , M = 2*N;
		static int[] depth = new int[N];
		static int[][] fa = new int[N][20];//最大2^19次方
		static int n,m,start;
		static int[] h = new int[N],e = new int[M],ne = new int[M];
		static int idx;
		static void add(int a,int b) {
			e[idx] = b;
			ne[idx] = h[a];
			h[a] = idx++;
		}
		//st表预处理（计算倍增数组）
		static void dfs(int u,int father) {
			depth[u] = depth[father] + 1;
			fa[u][0] = father;
			for(int k=1;k<=19;k++) {
				fa[u][k] = fa[fa[u][k-1]][k-1];
			}

			for(int i=h[u];i!=-1;i=ne[i]) {
				int j = e[i];
				if(j==father) continue;
				dfs(j,u);
			}
			
		}
		
		//lca求公共祖先
		static int lca(int a,int b) {
			if(depth[a]<depth[b]) {
				int t = a;
				a = b;
				b = t;
			}
			//1.把a和b移到同一层
			for(int i=19;i>=0;i--) {
				if(depth[fa[a][i]]>=depth[b])
					a = fa[a][i];
			}
			if(a==b) return b;
			//2.a和b同时向上找到最近公共祖先的下一个
			for(int i=19;i>=0;i--) {
				if(fa[a][i] != fa[b][i]) {
					a = fa[a][i];
					b = fa[b][i];
				}	
			}
			return fa[a][0];
		}
		
		public static void main(String[] sss) {
			Scanner sc = new Scanner(System.in);
			Arrays.fill(h,-1);
			n = sc.nextInt();
			for(int i=1;i<=n;i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				if(b==-1) {
					start = a;
					continue;
				}
				add(a,b);
				add(b,a);
			}
			dfs(start,0);
			
			
			m = sc.nextInt();
			while(m-->0) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int lcaans = lca(x,y);
				if(lcaans==x) System.out.println(1);
				else if(lcaans==y) System.out.println(2);
				else System.out.println(0);
			}
		}
		
}

