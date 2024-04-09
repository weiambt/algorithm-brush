package _18最小生成树;

import java.util.*;
import java.math.*;
import java.io.*;

public class 最小生成树 {
	static int INF = 0x3f3f3f3f;
	static int N = 101000 , M = 2*N;
	static int n,m;
	static int[] p = new int[N];
	static Edge[] edges = new Edge[M];

	static int find(int x) {
		if(x==p[x]) return x;
		return p[x] = find(p[x]);
	}
	static int kruskal() {
		Arrays.sort(edges,1,m+1);
		int cnt = 0,ans = 0;

		for(int i=1;i<=m;i++) {
			int x = edges[i].x;
			int y = edges[i].y;
			int w = edges[i].w;
			int a = find(x),b = find(y);
			if(a!=b) {
				p[a] = b;
				cnt++;
				ans += w;
			}
		}
		return cnt==n-1?ans:INF;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		for(int i=1;i<=n;i++)
			p[i] = i;
		for(int i=1;i<=m;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			edges[i] = new Edge(a, b, c);
		}
		int ans = kruskal();
		System.out.println(ans!=INF?ans:"impossible");
	}
	
}
class Edge implements Comparable<Edge>{
	int x;
	int y;
	int w;
	public Edge(int x,int y,int w) {
		this.x = x;
		this.y = y;
		this.w = w;
	}
	@Override
	public int compareTo(Edge o) {
	    return Integer.compare(w, o.w);
	}
}
