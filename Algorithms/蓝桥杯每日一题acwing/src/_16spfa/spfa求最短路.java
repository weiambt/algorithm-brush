package _16spfa;

import java.util.*;
import java.math.*;
import java.io.*;

public class spfaÇó×î¶ÌÂ· {
	static int INF = 0x3f3f3f3f;
	static int N = 101000 , M = 2*N;
	static int n,m;
	static int[] h = new int[N],e = new int[N],w = new int[N],ne = new int[N];
	static int idx;
	static int[] dist = new int[N],st = new int[N];
	static void add(int a,int b,int c) {
		e[idx] = b;
		w[idx] = c;
		ne[idx] = h[a];
		h[a] = idx++;
	}
	static int spfa() {
		Arrays.fill(dist, INF);
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		st[1] = 1;
		dist[1] = 0;
		while(q.size()>0) {
			Integer top = q.poll();
			st[top] = 0;
			for(int i=h[top];i!=-1;i=ne[i]) {
				int j = e[i];
				if(dist[j] > dist[top] + w[i]) {
					dist[j] = dist[top] + w[i];
					if(st[j]==0) {
						q.add(j);
						st[j]=1;
					}
					
				}
			}
		}
		return dist[n];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Arrays.fill(h, -1);
		n = sc.nextInt();
		m = sc.nextInt();
		while(m-->0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			add(x, y, z);
		}
		int ans = spfa();
		System.out.println(ans!=INF?ans:"impossible");
	}
	
}
