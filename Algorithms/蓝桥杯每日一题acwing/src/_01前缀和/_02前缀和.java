package _01前缀和;

import java.util.*;
import java.math.*;
import java.io.*;

public class _02前缀和 {
	static int INF = 0x3f3f3f3f;
	static int N = 101000 , M = 2*N;
	static int[] sum = new int[N];
	static int n,m;

	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		for(int i=1;i<=n;i++)
			sum[i] = sum[i-1] + sc.nextInt();
		while(m-->0) {
			int l = sc.nextInt();
			int r = sc.nextInt();
			System.out.println(sum[r]-sum[l-1]);
		}
	}
}
