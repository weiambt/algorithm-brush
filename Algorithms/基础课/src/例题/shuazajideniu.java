package ÀýÌâ;

import java.util.*;
import java.math.*;
import java.io.*;

public class shuazajideniu {
		static int INF = 1000000007;
		static int N = 101000 , M = 2*N;
		static Cow[] cows = new Cow[N];
		static int n,ans=Integer.MIN_VALUE;
		
		public static void main(String[] sss) {
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			for(int i=1;i<=n;i++) {
				cows[i] = new Cow(sc.nextInt(),sc.nextInt());
			}
			Arrays.sort(cows,1,n+1,(a,b)->a.sum-b.sum);
			int sum = 0;
			for(int i=1;i<=n;i++) {
				int w = cows[i].w;
				int s = cows[i].s;
				ans = Math.max(ans,sum-s);
				sum += w;
			}
			System.out.println(ans);
			
		}
		
}
class Cow{
	int sum,w,s;
	public Cow(int w,int s) {
		// TODO Auto-generated constructor stub
		this.w = w;
		this.s = s;
		this.sum = s+w;
	}
}
