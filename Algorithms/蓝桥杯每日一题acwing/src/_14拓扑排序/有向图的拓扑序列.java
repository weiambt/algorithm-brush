package _14ÍØÆËÅÅĞò;

import java.util.*;
import java.math.*;
import java.io.*;

public class ÓĞÏòÍ¼µÄÍØÆËĞòÁĞ {
	static int INF = 0x3f3f3f3f;
	static int N = 101000 , M = 2*N;
	static int n,m,k;
	static int[] h = new int[N],e = new int[M],ne = new int[M],w = new int[M];
	static int idx,cnt;
	static int[] print = new int[N],d = new int[N];
	static void add(int a,int b,int c) {
		e[idx] = b;
		w[idx] = c;
		ne[idx] = h[a];
		h[a] = idx++;
	}
	static boolean topSort() {
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=1;i<=n;i++) {
			if(d[i]==0)
				q.add(i);
		}
		while(q.size()>0) {
			Integer top = q.poll();
			print[cnt++] = top;
			for(int i=h[top];i!=-1;i=ne[i]) {
				int j = e[i];
				d[j]--;
				if(d[j]==0) {
					q.add(j);
				}
			}
		}
		return n==cnt;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		Arrays.fill(h, -1);
		for(int i=1;i<=m;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			add(a,b,0);
			d[b]++;
		}
		boolean ans = topSort();
		if(ans==true) {
			for(int i=0;i<cnt;i++)
				System.out.print(print[i]+" ");
		}else System.out.println(-1);
		
	}

	
}
