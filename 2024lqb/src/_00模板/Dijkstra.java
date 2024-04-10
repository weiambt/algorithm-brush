package _00Ä£°å;
import java.util.*;

public class Dijkstra {
	static int INF = 0x3f3f3f3f;
	static int N = 101000,M = 2*N;
	static int[] dist = new int[N],st = new int[N];
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
	static int dijkstra(int start) {
		Arrays.fill(dist,INF);
		PriorityQueue<PII> q = new PriorityQueue<>((a,b)->a.dist-b.dist);
		q.add(new PII(start,0));
		st[start] = 0;
		while(q.size()>0) {
			PII top = q.poll();
			if (st[top.v]==1) continue;
			st[top.v] = 1;
			for(int i=h[top.v];i!=-1;i=ne[i]) {
				int j = e[i],val = w[i];
				if(dist[top.v]+val<dist[j]) {
					dist[j] = dist[top.v]+val;
					q.add(new PII(j,dist[j]));
				}
			}
		}
		return dist[n]!=INF?dist[n]:-1;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Arrays.fill(h,-1);
		n = sc.nextInt();
		m = sc.nextInt();
		for(int i=1;i<=n;i++) {
			
		}
	}
	

}
class PII{
	int dist;int v;
	public PII(int v,int dist) {
		// TODO Auto-generated constructor stub
		this.v = v;
		this.dist = dist;
	}
}
