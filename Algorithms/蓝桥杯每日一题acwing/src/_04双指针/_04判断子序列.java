package _04Ë«Ö¸Õë;

import java.util.*;
import java.math.*;
import java.io.*;

public class _04ÅÐ¶Ï×ÓÐòÁÐ {
	static int INF = 0x3f3f3f3f;
	static int N = 101000 , M = 2*N;
	static int[] a = new int[N],b = new int[N];
	static int n,m,x;
	
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		for(int i=1;i<=n;i++) {
			a[i] = sc.nextInt();
		}
		for(int i=1;i<=m;i++) {
			b[i] = sc.nextInt();
		}
		for(int i=1,j=1;i<=n;i++) {
			while(j<=m && b[j]!=a[i]) j++;
			if(j>m) {
				System.out.println("No");
				return;
			}
			j++;
		}
		System.out.println("Yes");
	}
}
