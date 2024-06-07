package st表;

import java.util.*;
import java.io.*;
import java.math.*;

public class st表 {
	static int INF = Integer.MAX_VALUE;
	static int N = 101000,M = 20;
	static int[] arr = new int[N];
	//f[i][j]表示从节点i开始向右2^j个元素的区间的最值：区间[i,i+2^j-1]
	static int[][] f = new int[N][M];
	static int n,m;
	static long ans;
	//https://www.luogu.com.cn/problem/P3865
	//初始化st表，O（nlogn）
	static void init() {
		//长度是1的区间就是本身
		for(int i=1;i<=n;i++)
			f[i][0] = arr[i];
		//分成两个子区间
		for(int j=1;j<M;j++) 
			for(int i=1;i+(1<<j)-1 <= n;i++) 
				f[i][j] = Math.max(f[i][j-1],f[i+(1<<(j-1))][j-1]);
	}
	//查询st表，O（1）
	static int query(int l,int r) {
		//计算区间[l,r]的最大2的幂跨度（l+2^k-1 <= r）
		int k = (int) (Math.log(r-l+1)/Math.log(2));
		//分为两个子区间
		int res = Math.max(f[l][k],f[r-(1<<k)+1][k]);
		return res;
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
			out.println(query(a, b));
		}
		out.flush();
	}
}

class Read{
	StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
	BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
//	
//	
	int nextInt() throws IOException {
		st.nextToken();
		return (int)st.nval;
	}
	String getLine() throws IOException {
		return r.readLine();
	}
}

