package _01前缀和;

import java.util.*;
import java.math.*;
import java.io.*;

public class _05激光炸弹 {
	static int INF = 0x3f3f3f3f;
	static int N = 10010 , M = 2*N;
	static int[][] sum = new int[N][N];
	static int n,r;

	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		r = sc.nextInt();

		r = Math.min(r,5001);//防止越界
		for(int i=1;i<=n;i++) {
			int a,b,c;
			a = sc.nextInt()+1;
			b = sc.nextInt()+1;
			c = sc.nextInt();
			sum[a][b] += c;
		}

		int ans=0;
		for(int i=1;i<=5001;i++) {
			for(int j=1;j<=5001;j++) {
				sum[i][j] += sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
			}
		}
		
	    for (int i = r; i <= 5001; i++) {
	        for (int j = r; j <= 5001; j++) {
				int x1 = i-r+1,y1 = j-r+1;
				ans = Math.max(ans, sum[i][j]-sum[i][y1-1]-sum[x1-1][j]+sum[x1-1][y1-1]);
	        }
	    }
		System.out.println(ans);
		
	}
}
