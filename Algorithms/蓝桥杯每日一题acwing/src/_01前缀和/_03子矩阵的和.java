package _01前缀和;

import java.util.*;
import java.math.*;
import java.io.*;

public class _03子矩阵的和 {
	static int INF = 0x3f3f3f3f;
	static int N = 1010 , M = 2*N;
	static int[][] sum = new int[N][N];
	static int n,m,q;

	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		q = sc.nextInt();
		for(int i=1;i<=n;i++)
			for(int j=1;j<=m;j++)
				sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + sc.nextInt();
		while(q-->0) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			System.out.println(sum[x2][y2]-sum[x2][y1-1]-sum[x1-1][y2]+sum[x1-1][y1-1]);
		}
	}
}
