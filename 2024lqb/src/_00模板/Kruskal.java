package _00Ä£°å;
import java.util.*;

public class Kruskal {
	static int INF = 0x3f3f3f3f;
	static int N = 101000,M = 2*N;
	static Edge[] edges = new Edge[N];
	static int idx;
	static int n,m;
	static long ans;
	static int[] fa = new int[N];
	static void init() {
		for(int i=1;i<=n;i++) {
			fa[i] = i;
		}
	}
	static int find(int x) {
		if(fa[x]==x) return x;
		return fa[x] = find(fa[x]);
	}
	static void union(int a,int b) {
		fa[find(a)] = find(b);
	}
	static int kruskal() {
		Arrays.sort(edges,0,idx,(a,b)->(a.w-b.w));
		int cnt = 0,res = 0;
		for(int i=0;i<m;i++) {
			int a = edges[i].a;
			int b = edges[i].b;
			int w = edges[i].w;
			if(find(a)!=find(b)) {
				union(a,b);
				cnt += 1;
				res += w;
			}
		}
		return cnt==n-1?res:-1;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		for(int i=1;i<=m;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int w = sc.nextInt();
			edges[idx++] = new Edge(a,b,w);
		}
	}
}
class Edge{
	int a,b,w;
	public Edge(int a,int b,int w) {
		// TODO Auto-generated constructor stub
		this.a = a;
		this.b = b;
		this.w = w;
	}
}
