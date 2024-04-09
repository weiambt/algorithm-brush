package _01搜索;

import java.util.*;
import java.io.*;
import java.math.*;

public class 费解的开关 {
	static int INF = 0x3f3f3f3f;
	static int N = 10,M = 2*N;
	static int[][] g = new int[N][N],tmp = new int[N][N];
	static int n=5,m=5,k;
	static long ans;
	//向下更新
	static void toggle(int i,int j) {
		g[i][j] ^= 1;
		if(i+1<n)
			g[i+1][j] ^= 1;
		if(j-1>=0)
			g[i][j-1] ^= 1;
		if(j+1<m)
			g[i][j+1] ^= 1;
	}
	static void solve() {
		for(int st=0;st<(1<<m);st++) {
			int cnt = 0;
			for(int i=0;i<n;i++)
				for(int j=0;j<m;j++)
					g[i][j] = tmp[i][j];
			for(int i=0;i<m;i++) {
				if((st>>i&1)==1) {
					toggle(0,i);
					cnt += 1;
				}
			}
			for(int i=1;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(g[i-1][j]==0) {
						toggle(i,j);
						cnt += 1;
					}
				}
			}
			int flag = 1;
			for(int i=0;i<m;i++)
				if(g[n-1][i]==0) 
					flag = 0;
			if(flag==1)
				ans = Math.min(ans,cnt);
		}
		if(ans<=6)
			System.out.println(ans);
		else
			System.out.println(-1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		k = sc.nextInt();
		while(k-->0) {
			for(int i=0;i<n;i++) {
				String val = sc.next();
				for(int j=0;j<m;j++) {
					g[i][j] = val.charAt(j)-'0';
					tmp[i][j] = g[i][j];
				}
			}
			ans = INF;
			solve();
		}
		
	}
	
	
	static int[] h = new int[N],e = new int[M],ne = new int[M],w = new int[M];
	static int idx;
	static void add(int a,int b,int c) {
		e[idx] = b;
		w[idx] = c ;
		ne[idx] = h[a];
		h[a] = idx++;
	}
	static void init(){
		Arrays.fill(h,-1);
	}


	class Read{
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
	//	PrintWriter out = new PrintWriter(System.out);
	//	out.flush();
		int nextInt() throws IOException {
			st.nextToken();
			return (int)st.nval;
		}
		String getLine() throws IOException {
			return r.readLine();
		}
	}
}