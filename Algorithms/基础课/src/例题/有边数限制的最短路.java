package ����;
import java.util.*;
import java.math.*;
import java.io.*;

public class �б������Ƶ����· {
		static int INF = 0x3f3f3f3f;
		static int N = 101000 , M = 2*N;
		static int n,m,k,idx;
		static Edge[] edges = new Edge[N];
		static int[] dist = new int[N],tmp = new int[N];

		public static void main(String[] sss) {
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			m = sc.nextInt();
			k = sc.nextInt();
			for(int i=0;i<m;i++) {
				int a,b,c;
				a = sc.nextInt();
				b = sc.nextInt();
				c = sc.nextInt();
				edges[i] = new Edge(a, b, c);
			}
			bellmanFord();
			if(dist[n]>INF/2) System.out.println("impossible");
			else System.out.println(dist[n]);
		}

		 static void bellmanFord() {
			Arrays.fill(dist,INF);
			dist[1]=0;
			for(int i=0;i<k;i++) {//ѭ��k��
				tmp = dist.clone();//���Ƶ�ǰ��dist����ʾ��һ�ֵ�dist��������������ҵ�����<=k��
				for(int j=0;j<m;j++) {
					Edge e = edges[j];
					dist[e.b] = Math.min(dist[e.b], tmp[e.a]+e.c);
				}
			}
			
		}
}
class Edge{
	int a,b,c;
	public Edge(int a,int b,int c) {
		// TODO Auto-generated constructor stub
		this.a = a;
		this.b = b;
		this.c = c;
	}
}
