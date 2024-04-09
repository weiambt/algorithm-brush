package _14拓扑排序;

import java.util.*;
import java.math.*;
import java.io.*;

public class 构造有向无环图 {
	static int INF = 0x3f3f3f3f;
	static int N = 201000 , M = 2*N;
	static int n,m,k,t;
	static int[] h = new int[N],e = new int[M],ne = new int[M],w = new int[M];
	static int idx,cnt;
	static int[] print = new int[N],d = new int[N],pos = new int[N];
	static Edge[] edges = new Edge[M];
	static void add(int a,int b,int c) {
		e[idx] = b;
		w[idx] = c;
		ne[idx] = h[a];
		h[a] = idx++;
	}
	static boolean topSort() {
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=1;i<=n;i++)
			if(d[i]==0)
				q.add(i);
		while(q.size()>0) {
			Integer top = q.poll();
			print[cnt] = top;
			pos[top] = cnt++;
			for(int i=h[top];i!=-1;i=ne[i]) {
				int j = e[i];
				d[j]--;
				if(d[j]==0) q.add(j);
			}
		}
		return n == cnt;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		PrintWriter out = new PrintWriter(System.out);
		t = sc.nextInt();
		while(t-->0) {
			n = sc.nextInt();
			m = sc.nextInt();
			idx = 0;cnt = 0;
			Arrays.fill(h, -1);
			Arrays.fill(d, 0);
			for(int i=1;i<=m;i++) {
				int op = sc.nextInt();
				int a = sc.nextInt();
				int b = sc.nextInt();
				if(op==1) {
					add(a,b,0);
					d[b]++;
				}
				edges[i] = new Edge(a, b);
			}
			boolean ans = topSort();
			if(ans==true) {
				out.println("YES");
				for(int i=1;i<=m;i++) {
					int a = edges[i].x,b = edges[i].y;
					if(pos[a]<=pos[b]) out.println(a+" "+b);
					else out.println(b+" "+a);
				}
			}else out.println("NO");

		}
		out.flush();
	}
}
class Edge{
	int x,y;
	public Edge(int x,int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}
}
