package _16spfa;

import java.util.*;
import java.math.*;
import java.io.*;

public class �����ӽ� {
	static int INF = 0x3f3f3f3f;
	static int N = 101000 , M = 2*N;
	static int n,m,k,end;
	static int[] h = new int[N],e = new int[M],ne = new int[M],w = new int[M],limit = new int[M];
	static int idx;
	static int[] time = new int[N], seed = new int[N];
	static int[] st = new int[N],dist = new int[N];
	static void add(int a,int b,int c,int d) {
		e[idx] = b;
		w[idx] = c;
		limit[idx] = d;          
		ne[idx] = h[a];
		h[a] = idx++;
	}
	static int spfa() {
		Arrays.fill(dist, INF);
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=1;i<=m;i++) {
			q.add(seed[i]);
			st[seed[i]]=1;
			dist[seed[i]]=0;
		}
		while(q.size()>0) {
			Integer top = q.poll();
			st[top]=0;
			for(int i=h[top];i!=-1;i=ne[i]) {
				int j = e[i];
				if(dist[j] > Math.max(dist[top], dist[limit[i]]) + w[i]) {
					dist[j] = Math.max(dist[top], dist[limit[i]]) + w[i];
					if(st[j]==0) {
						q.add(j);
						st[j]=1;
					}
				}
			}
		}
		return dist[end];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Arrays.fill(h, -1);
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		end = sc.nextInt();
		for(int i=1;i<=n;i++) 
			time[i] = sc.nextInt();
		for(int i=1;i<=m;i++) 
			seed[i] = sc.nextInt();
		for(int i=1;i<=k;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			add(a, c, Math.max(time[a], time[b]),b);
			add(b, c, Math.max(time[a], time[b]),a);
		}
		System.out.println(spfa());
	}

	
}
