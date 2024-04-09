package _06二分和前缀和;

import java.util.*;
import java.io.*;
import java.math.*;

public class 数的三次方根 {
	static int INF = 0x3f3f3f3f;
	static int N = 101000,M = 2*N;
	static long ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double n = sc.nextDouble();
		double l = -1e4, r = 1e4;
		while (r-l>1e-7) {
			double mid = (l+r)/2;
			if (mid * mid * mid >= n)
				r = mid;
			else
				l = mid;	
		}
		System.out.printf("%.6f",l);
		
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
