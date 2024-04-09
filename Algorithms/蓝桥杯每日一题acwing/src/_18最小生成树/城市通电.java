package _18��С������;

import java.util.*;
import java.math.*;
import java.io.*;

public class ����ͨ�� {
	static int INF = 0x3f3f3f3f;
	static int N = 4010000 , M = 2*N;
	static int n,m;
	static int[] fa = new int[N];
	
	static Edge[] edges = new Edge[N];
	static int idx;
	static int[] c = new int[N];//��������н�����վ�ɱ�
	static int[] k = new int[N];//����������̵��ߵĳɱ�
	static int[] xx = new int[N];//���еĺ�����
	static int[] yy = new int[N];//���е�������
	
	static ArrayList<Integer> fadianzhan = new ArrayList<Integer>();//������еķ���վ
	static ArrayList<String> dianxian = new ArrayList<String>();//������еĵ���
	static int cnt;//������ѡ��ĵ���������
	static long kruskal() {
		Arrays.sort(edges,0,idx);
		cnt = 0;
		long ans = 0;
		for(int i=0;i<idx;i++) {
			int x = edges[i].x;
			int y = edges[i].y;
			long w = edges[i].w;
			int a = find(x),b = find(y);
			if(a!=b) {
				fa[a] = b;
				cnt++;
				ans += w;
				if(x==0) {
					fadianzhan.add(y);
				}else {
					dianxian.add(x+" "+y);
				}

			}
			
		}
//		System.out.println(cnt);
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=1;i<=n;i++) {
			xx[i] = sc.nextInt();
			yy[i] = sc.nextInt();
		}
		for(int i=1;i<=n;i++) {
			c[i] = sc.nextInt();
		}
		for(int i=1;i<=n;i++) {
			k[i] = sc.nextInt();
		}
		
		for(int i=1;i<=n;i++) {
			fa[i] = i;
		}

		//��������ԭ�㣬�ѷ���վת���ɱ�Ȩ
		for(int i=1;i<=n;i++) {
			edges[idx++] = new Edge(0,i,c[i]);
		}
		//��ͼ
		for(int i=1;i<=n;i++) {
			for (int j = i+1; j <= n; j++) {
				edges[idx++] = new Edge(i,j,(long)(k[i]+k[j])*(Math.abs(xx[i]-xx[j]) + Math.abs(yy[i]-yy[j]) ));
			}
		}
		
		long ans = kruskal();
		System.out.println(ans);
		System.out.println(cnt-dianxian.size());
		for(int i=0;i<fadianzhan.size();i++)
			System.out.print(fadianzhan.get(i)+" ");
		System.out.println();
		System.out.println(dianxian.size());
		for(String i:dianxian)
			System.out.println(i);
	}
	static int find(int x) {
		if(fa[x]==x) return x;
		return fa[x] = find(fa[x]);
	}
}
class Edge implements Comparable<Edge>{
	int x;
	int y;
	long w;
	public Edge(int x,int y,long w) {
		this.x = x;
		this.y = y;
		this.w = w;
	}
	@Override
	public int compareTo(Edge o) {
	    //����д�� return (int)(w-o.w),�ᱨ��,������Ϣ���£�
	    //IllegalArgumentException: Comparison method violates its general contract!
		return Long.compare(w, o.w);
	}
}
