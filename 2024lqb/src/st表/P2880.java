package st±í;

import java.util.*;
import java.io.*;
import java.math.*;

public class P2880 {
	static int INF = 0x3f3f3f3f;
	static int N = 101000,M = 20;
	static int[] arr = new int[N];
	static int[][] ma = new int[N][M],mi = new int[N][M];
	static int n,m;
	static long ans;
	//https://www.luogu.com.cn/problem/P2880
	static void init() {
		for(int i=1;i<=n;i++) {
			Arrays.fill(mi[i],INF);
			ma[i][0] = mi[i][0] = arr[i];
			
		}
		for(int j=1;j<M;j++) {
			for(int i=1;i+(1<<j)-1<=n;i++) {
				mi[i][j] = Math.min(mi[i][j-1], mi[i+(1<<(j-1))][j-1]);
				ma[i][j] = Math.max(ma[i][j-1], ma[i+(1<<(j-1))][j-1]);
			}
		}
			
	}
	static int query(int l,int r,int op) {
		int k = (int)(Math.log(r-l+1)/Math.log(2));
		if(op==1) return Math.max(ma[l][k],ma[r-(1<<k)+1][k]);
		else return Math.min(mi[l][k],mi[r-(1<<k)+1][k]);
	}
	
	public static void main(String[] args) throws IOException {
		Read sc = new Read();
		PrintWriter out = new PrintWriter(System.out);
		
		n = sc.nextInt();
		m = sc.nextInt();
		for(int i=1;i<=n;i++) 
			arr[i] = sc.nextInt();
		init();
		for(int i=1;i<=m;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			out.println(query(a,b,1)-query(a,b,0));
		}
		out.flush();
	}
}
class Read{
	StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
	BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

	int nextInt() throws IOException {
		st.nextToken();
		return (int)st.nval;
	}
	String getLine() throws IOException {
		return r.readLine();
	}
}



