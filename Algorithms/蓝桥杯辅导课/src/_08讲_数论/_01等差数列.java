package _08讲_数论;

import java.util.*;
import java.math.*;
import java.io.*;

public class _01等差数列 {
		static int INF = 0x3f3f3f3f;
		static int N = 101000 , M = 2*N;
		static int[] arr = new int[N];
		static int n,m;
		static int gcd(int a,int b) {
			return b==0?a:gcd(b,a%b);
		}
		public static void main(String[] sss) {
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			for(int i=1;i<=n;i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr,1,n+1);
			int d=0;
			for(int i=2;i<=n;i++) {
				d = gcd(d,arr[i]-arr[i-1]);
			}
//			System.out.println(d);
			System.out.println((arr[n]-arr[1])/d+1);
		}
}
