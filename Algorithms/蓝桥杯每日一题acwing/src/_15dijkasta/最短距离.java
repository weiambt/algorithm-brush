package _15dijkasta;

import java.util.*;
import java.math.*;
import java.io.*;

public class ��̾��� {
	static int INF = 0x3f3f3f3f;
	static int N = 101000 , M = 2*N;
	static int n,m;
	static int[] h = new int[N],e = new int[M],ne = new int[M],w = new int[M];
	static int idx;
	static int[] dist = new int[N],st = new int[N];
	static PriorityQueue<PII> q = new PriorityQueue<PII>((a,b)->(a.dist-b.dist));

	static void add(int a,int b,int c) {
		e[idx] = b;
		w[idx] = c;
		ne[idx] = h[a];
		h[a] = idx++;
	}
	static int dijkstra() {
//		q.add(new PII(0,0));
//		dist[0]=0;
		
		while(q.size()>0) {
			PII top = q.poll();
			
			if(st[top.ver]==1)continue;
			st[top.ver]=1;
			
			for(int i=h[top.ver];i!=-1;i=ne[i]) {
				int j = e[i];
				if(dist[j] > top.dist + w[i]) {
					dist[j] = top.dist +w[i];
					q.add(new PII(dist[j],j));
				}
			}
		}
		return dist[n];
	}

	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Arrays.fill(h, -1);
        n = sc.nextInt();
        m = sc.nextInt();
        int a, b, c;
        for (int i = 1; i <=m; i++){
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            add(a, b, c);
            add(b, a, c);
        }
		Arrays.fill(dist, INF);

        int k = sc.nextInt();
        for (int i = 0; i < k; i++){
            int x = sc.nextInt();
            q.add(new PII(0,x));
            dist[x]=0;
        }
        dijkstra();
        int q = sc.nextInt();
        while(q-- > 0){
            System.out.println(dist[sc.nextInt()]);
        }

    }
	
}
//class PII{
//	int dist,ver;
//	
//	public PII(int dist,int ver) {
//		// TODO Auto-generated constructor stub
//		this.dist = dist;
//		this.ver = ver;
//	}
//}
