package day5_25;

import java.util.*;
import java.io.*;
import java.math.*;


public class Main3 {
	static int INF = Integer.MAX_VALUE;
	static int N = 101000,M = 2*N;
	static long[] a = new long[N];
	static int n,m;
	static long ans;
	
	static void solve() {
		
	}
	
	public static void main(String[] args) throws Exception {
		n = sc.nextInt();
		m = sc.nextInt();
		for(int i=1;i<=n;i++) {
			a[i] = sc.nextInt();
		}
		solve();
		out.flush();
	}
	static Read sc = new Read();
//	static Scanner sc = new Scanner(System.in);
	static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
}
class Read{
	StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
	
	int nextInt() throws Exception {
		st.nextToken();
		return (int)st.nval;
	}
}
