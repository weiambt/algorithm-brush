package 例题;

import java.util.*;
import java.math.*;
import java.io.*;

public class 图中点的层次 {
	static int INF = 0x3f3f3f3f;
	static int N = 101000 , M = 2*N;
	static int[] vis = new int[N],dist = new int[N];
	static int n,m;
	static int[] h = new int[N],e = new int[M],ne = new int[M];
	static int idx;
	static void add(int a,int b,int c) {
		e[idx] = b;
		ne[idx] = h[a];
		h[a] = idx++;
	}
	static int bfs() {
		Arrays.fill(dist, -1);
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		vis[1] = 1;
		dist[1] = 0;
		
		while(q.size()>0){
			Integer top = q.poll();
			for(int i = h[top];i!=-1;i=ne[i]) {
				int j = e[i];
				if(vis[j]==1) continue;
				dist[j] = dist[top]+1;
				vis[j] = 1;
				q.add(j);
			}
		}
		return dist[n];
	}
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		Arrays.fill(h, -1);
		while(m-->0){
			int a,b;
			a = sc.nextInt();
			b = sc.nextInt();
			add(a,b,1);
		}
		System.out.println(bfs());
	}

}
