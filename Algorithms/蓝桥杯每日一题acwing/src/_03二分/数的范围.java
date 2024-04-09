package _03二分;

import java.util.*;
import java.math.*;
import java.io.*;

public class 数的范围 {
	static int INF = 0x3f3f3f3f;
	static int N = 201000 , M = 2*N;
	static int n,q;
	static int[] a = new int[N];
	
	static int lowerBound(int l,int r,int x) {
		while(l<r) {
			int mid = l+r>>1;
			if(a[mid] >= x) r = mid;
			else l = mid+1;
		}
		return l;
	}
	static int upperBound(int l,int r,int x) {
		while(l<r) {
			int mid = l+r+1>>1;
			if(a[mid] <= x) l = mid;
			else r = mid-1;
		}
		return l;
	}
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		q = sc.nextInt();
		for(int i=1;i<=n;i++) 
			a[i] = sc.nextInt();
		while(q-->0) {
			int x = sc.nextInt();
			int idx = lowerBound(1,n,x);

			if(a[idx]!=x) {
				System.out.println("-1 -1");
				continue;
			}
			System.out.print(idx-1);

			idx = upperBound(1,n,x);
			idx--;
			System.out.println(" "+idx);
		}
		
	}
}
