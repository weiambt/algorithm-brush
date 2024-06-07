package _2024_5_lqb;

import java.util.*;
import java.io.*;
import java.math.*;

public class C {
	static int INF = Integer.MAX_VALUE;
	static int N = 101000,M = 2*N;
	static int[] arr = new int[N];

	static long ans = INF;
	

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		for(int i=1;i<=n;i++) {
			arr[i] = sc.nextInt();
		}
		HashMap<Integer,Integer> mp = new HashMap<Integer, Integer>();
		for(int i=1;i<=n;i++) {
			if(k-arr[i]>0 && mp.containsKey(k-arr[i])) {
				int last = mp.get(k-arr[i]);
				ans = Math.min(ans,i);
				ans = Math.min(ans,Math.max(last,n-i+1));
				ans = Math.min(ans,n-last+1);
			}
			if(!mp.containsKey(arr[i]))
				mp.put(arr[i],i);
		}
		if(ans==INF) ans = -1;
		System.out.println(ans);
	}
	static PrintWriter out = new PrintWriter(System.out);
//	static Read sc = new Read();

}