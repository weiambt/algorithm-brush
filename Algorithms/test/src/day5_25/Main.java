package day5_25;

import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
	static int INF = Integer.MAX_VALUE;
	static int mod = 1;
	static int N = 101000,M = 2*N;
	static long[] arr = new long[N];
	static int n,m;
	static long ans;
	
	static void solve() {
		
	}
	

	
	public static void main(String[] args) throws Exception {
		n = sc.nextInt();
		m = sc.nextInt();
		for(int i=1;i<=n;i++) {
			arr[i] = sc.nextInt();
		}
		solve();
		out.flush();
	}
	
	static Read sc = new Read();
//	static Scanner sc = new Scanner(System.in);
	static PrintWriter out = new PrintWriter(System.out);
	
	static int[] h = new int[N],e = new int[M],ne = new int[N];
	static int idx;
	static void add(int a,int b) {
		e[idx] = b;
		ne[idx] = h[a];
		h[a] = idx++;
	}
	
}


class Read{
	 StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
	
	 int nextInt() throws IOException {
		st.nextToken();
		return (int)st.nval;
	 }
}

class PII{
	int x,y;
	public PII(int x,int y) {
		this.x = x;
		this.y = y;
	}
}
