package _00Ä£°å;

import java.util.*;
import java.io.*;
import java.math.*;

public class AMain2 {
	static int INF = Integer.MAX_VALUE;
	static int N = 101000,M = 2*N;
	static int[] arr = new int[N];
	static int n,m;
	static long ans;
	
	static void solve() {
		
	}

	public static void main(String[] args) throws IOException {
		
		n = sc.nextInt();
		m = sc.nextInt();
		for(int i=1;i<=n;i++) {
			sc.nextInt();
		}
		solve();
		out.flush();
	}
	static PrintWriter out = new PrintWriter(System.out);
	static Read sc = new Read();

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

class PII{
	int x,y;
	public PII(int x,int y) {
		this.x = x;
		this.y = y;
	}
}
