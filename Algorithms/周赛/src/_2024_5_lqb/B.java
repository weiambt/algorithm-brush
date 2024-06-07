package _2024_5_lqb;

import java.util.*;
import java.io.*;
import java.math.*;

public class B {
	static int INF = Integer.MAX_VALUE;
	static int N = 101000,M = 2*N;
	static int[] arr = new int[N];

	static long ans;
	
	static void solve() {
		
	}
	static Integer[] a = new Integer[N];
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		char[] ss = sc.next().toCharArray();
		int n = ss.length;
		for(int i=0;i<n;i++) {
			a[i] = ss[i]-'0';
		}
		Arrays.sort(a,0,n,(a,b)->(b-a));
		for(int i=0;i<n;i++) {
			System.out.print(a[i]);
		}
		System.out.print(" ");
		int s = -1;
		for(int i=n-1;i>=0;i--) {
			if(a[i]!=0) {
				s = i;
				break;
			}
		}
		System.out.print(a[s]);
		for(int i=n-1;i>=0;i--) {
			if(i!=s) {
				System.out.print(a[i]);
			}
		}
		
		
	}
	static PrintWriter out = new PrintWriter(System.out);
//	static Read sc = new Read();

}