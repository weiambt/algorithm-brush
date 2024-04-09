package _18最小生成树;

import java.util.*;
import java.math.*;
import java.io.*;

public class 城市通电 {
	static int INF = 0x3f3f3f3f;
	static int N = 4010000 , M = 2*N;
	static int n,m;
	static int[] fa = new int[N];
	
	static Edge[] edges = new Edge[N];
	static int idx;
	static int[] c = new int[N];//在这个城市建发电站成本
	static int[] k = new int[N];//在这个城市铺电线的成本
	static int[] xx = new int[N];//城市的横坐标
	static int[] yy = new int[N];//城市的纵坐标
	
	static ArrayList<Integer> fadianzhan = new ArrayList<Integer>();//存放所有的发电站
	static ArrayList<String> dianxian = new ArrayList<String>();//存放所有的电线
	static int cnt;//边数（选择的电线数量）
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

		//建立超级原点，把发电站转换成边权
		for(int i=1;i<=n;i++) {
			edges[idx++] = new Edge(0,i,c[i]);
		}
		//建图
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
	    //不能写成 return (int)(w-o.w),会报错,报错信息如下：
	    //IllegalArgumentException: Comparison method violates its general contract!
		return Long.compare(w, o.w);
	}
}
