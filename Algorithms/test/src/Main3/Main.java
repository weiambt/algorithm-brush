package Main3;

import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
	static int INF = 0x3f3f3f3f;
	static int N = 101000, M = 2*N;
	static int[] a = new int[N];
	static int n,m;
	static long ans;
	
	public static void main(String[] args) throws Exception {
		n = sc.nextInt();
		m = sc.nextInt();
		for(int i=1;i<=n;i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(a[1]);
		out.flush();
	}
	
	static Read sc = new Read();
//	static Scanner sc = new Scanner();
	static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
	static class Read{
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		
		int nextInt() throws Exception {
			st.nextToken();
			return (int)st.nval;
		}
	}
}
