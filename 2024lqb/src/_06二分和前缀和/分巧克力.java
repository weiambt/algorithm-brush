package _06二分和前缀和;

import java.util.*;
import java.io.*;
import java.math.*;

public class 分巧克力 {
	static int INF = 0x3f3f3f3f;
	static int N = 100050,M = 2*N;
	static int[][] arr = new int[N][2];
	static int n,k;
	static long ans;
	static boolean check(int sz) {
		long s = 0;
		for(int i=1;i<=n;i++) {
			int a = arr[i][0]/sz;
			int b = arr[i][1]/sz;
			s += (long)a*b;
		}
		return s>=k;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		k = sc.nextInt();
		int mx = INF;
		for(int i=1;i<=n;i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		int l = 1,r = N;
		while(l<r) {
			int mid = l+r+1>>1;
			if(check(mid))
				l = mid;
			else
				r = mid-1;
		}
		System.out.println(l);
		
		
	}
	
	
}
