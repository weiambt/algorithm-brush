package _00Ä£°å;
import java.util.*;
public class Spfa {
	static int INF = 0x3f3f3f3f;
	static int N = 101000,M = 2*N;
	static int[] st = new int[N],dist = new int[N];
	static int n,m;
	static long ans;
	static int[] h = new int[N],e = new int[M],w = new int[M],ne = new int[M];
	static int idx;
	static void add(int a,int b,int c) {
		e[idx] = b;
		w[idx] = c;
		ne[idx] = h[a];
		h[a] = idx++;
	}
	static int spfa(int start) {
		Arrays.fill(dist,INF);
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		st[start] = 1;
		dist[start] = 0;
		
		while(q.size()>0) {
			int top = q.poll();
			st[top] = 0;
			for(int i=h[top];i!=-1;i=ne[i]) {
				int j = e[i];
				if(dist[top]+w[i]< dist[j]) {
					dist[j] = dist[top]+w[i];
					if(st[j]==0) {
						st[j] = 1;
						q.add(j);
					}	
				}
			}
		}
		return dist[n]!=INF?dist[N]:-1;
		
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
