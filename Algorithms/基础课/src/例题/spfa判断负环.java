package ¿˝Ã‚;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class spfa≈–∂œ∏∫ª∑ {
	static int INF = 0x3f3f3f3f;
	static int N = 101000 , M = 2*N;
	static int n,m;
	static int[] h = new int[N],e = new int[M],w = new int[M],ne = new int[M];
	static int idx;
	static int[] st = new int[N],dist = new int[N],cnt = new int[N];
	static void add(int a,int b,int c) {
		e[idx] = b;
		w[idx] = c;
		ne[idx] = h[a];
		h[a] = idx++;
	}
	static boolean spfa() {
		Arrays.fill(dist, INF);
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 1;i <= n;i++)
        {
            q.add(i);
            st[i] = 1;
        }
		while(q.size()>0) {
			Integer top = q.poll();
			st[top] = 0;
			for(int i=h[top];i!=-1;i=ne[i]) {
				int j = e[i];
				if(dist[j]>dist[top]+w[i]) {
					dist[j] = dist[top]+w[i];
					cnt[j] = cnt[top]+1;
					if(cnt[j]>=n) return true;
					if(st[j]==0) {
						q.add(j);
						st[j]=1;
					}
				}
			}
		}
		return false;
	}
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		Arrays.fill(h, -1);
		while(m-->0) {
			int a= sc.nextInt();
			int b =sc.nextInt();
			int c =sc.nextInt();
			add(a,b,c);
		}
		boolean ans = spfa();
		if(ans==true) System.out.println("Yes");
		else
			System.out.println("No");
	}
}
