package _2024_5_lqb;

import java.util.*;
import java.io.*;
import java.math.*;

public class A {
	static int INF = Integer.MAX_VALUE;
	static int N = 101000,M = 2*N;
	static int[] arr = new int[N];
	static int n,x,y,a,b,t;
	static long ans;
	
	static void solve() {
		
	}

	public static void main(String[] args) throws IOException {
		t = sc.nextInt();
		while(t-->0) {
			n = sc.nextInt();
			x = sc.nextInt();
			y = sc.nextInt();
			a = sc.nextInt();
			b = sc.nextInt();
			int c2 = Math.min(b/x,n/y);
			if(c2==0) {
				System.out.println("-1");
				return;
			}
			int c1 = Math.min(n/y - c2,a/x);
			c1 = Math.min(c1,c2-1);
			
			System.out.println(c1+c2);
		}
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