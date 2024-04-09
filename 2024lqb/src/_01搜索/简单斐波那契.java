package _01ËÑË÷;

import java.util.*;
import java.io.*;
import java.math.*;

public class ¼òµ¥ì³²¨ÄÇÆõ {
	static int INF = 0x3f3f3f3f;
	static int N = 101000,M = 2*N;
	static int[] dp = new int[N];
	static int n,m;
	static long ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		dp[1]=0;
		dp[2]=1;
		for(int i=3;i<=n;i++) {
			dp[i] = dp[i-1]+dp[i-2];
		}
		for(int i=1;i<=n;i++)
			System.out.println(dp[i]+" ");
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
