package _2024_5_lqb;

import java.util.*;
import java.io.*;
import java.math.*;

public class B2 {
	static int INF = Integer.MAX_VALUE;
	static int N = 101000,M = 2*N;
	static int[] arr = new int[N];

	static long ans;
	
	
	static Integer[] a = new Integer[N];
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			a[i] = sc.nextInt();
		}
		Arrays.sort(a,0,n);
		for(int i=0;i<n;i++) {
			System.out.print(a[i]);
		}
		
		
		
	}
	static PrintWriter out = new PrintWriter(System.out);
//	static Read sc = new Read();

}