package _12BFS;

import java.util.*;
import java.math.*;
import java.io.*;

public class 微博转发 {
	static int INF = 0x3f3f3f3f;
	static int N = 10100 , M = 2*N;
	static int n,l,k;
	static int[] h = new int[N],e = new int[M],ne = new int[M];
	static int idx,cnt;
	static int[] st = new int[N];
	static void add(int a,int b) {
		e[idx] = b;
		ne[idx] = h[a];
		h[a] = idx++;
	}
	static void init() {
		Arrays.fill(h, -1);
	}

	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		l = sc.nextInt();
		init();
		for(int i=1;i<=n;i++){
			int m = sc.nextInt(),x;
			while(m-->0) {
				x = sc.nextInt();
				if(x!=i)
					add(x, i);
			}
		}
		k = sc.nextInt();
		while(k-->0) {
			int x = sc.nextInt();
			int ans = bfs(x);
			System.out.println(ans);
		}
	}
	static int bfs(int u) {
		Queue<Integer> q = new LinkedList<Integer>();
		Arrays.fill(st, 0);
		q.add(u);
		st[u] = 1;
		int ans = 0;//答案不算起点
		
		for(int level = 0;level < l;level++) {//BFS最多l层
			
			int sz = q.size();//获得当前这一层的所有节点个数
			while(sz-->0) {//把当前这层的所有节点出队
				Integer top = q.poll();
				for(int i=h[top];i!=-1;i=ne[i]) {
					int j = e[i];
					if(st[j]==1) continue;
					q.add(j);
					st[j]=1;
					ans++;
				}
			}
		}
		return ans;
	}
}
