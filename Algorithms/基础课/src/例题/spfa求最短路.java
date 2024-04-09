package 例题;
import java.util.*;
import java.math.*;
import java.io.*;

public class spfa求最短路 {
		static int INF = 0x3f3f3f3f;
		static int N = 101000 , M = 2*N;
		static int n,m;
		static int[] h = new int[N],e = new int[M],w = new int[M],ne = new int[M];
		static int idx;
		static int[] st = new int[N],dist = new int[N];
		static void add(int a,int b,int c) {
			e[idx] = b;
			w[idx] = c;
			ne[idx] = h[a];
			h[a] = idx++;
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
			int ans = spfa();
			if(ans==INF) System.out.println("impossible");
			else
				System.out.println(ans);
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
							st[j]=1;
							q.add(j);
						}
					}
				}
			}
			return dist[n];
		}
}
