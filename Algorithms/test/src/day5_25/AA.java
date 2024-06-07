package day5_25;

import java.util.*;
import java.io.*;
import java.math.BigDecimal;

public class AA {
	static int INF = 0x3f3f3f3f;
	static int N = 101000,M = 2*N;
	static int[] a = new int[N];
	static int n,m;
	static long ans;
	
	public static void main(String[] args) throws IOException {
		n = sc.nextInt();
		m = sc.nextInt();
		for(int i=1;i<=n;i++) {
			a[i] = sc.nextInt();
		}
		
		
		out.flush();
	}
	static Read sc = new Read();
//	static Scanner sc = new Scanner(System.in);
	static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
	
	static class Read{
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		
		int nextInt() throws IOException {
			st.nextToken();
			return (int)st.nval;
		}
	}

}


