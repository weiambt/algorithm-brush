package _06二分和前缀和;

import java.util.*;
import java.io.*;
import java.math.*;

public class 激光炸弹 {
	static int INF = 0x3f3f3f3f;
	static int N = 5050,M = 2*N;
	static int[][] s = new int[N][N], arr = new int[N][N];
	static int n,r;
	static long ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		r = sc.nextInt();
		for(int i=1;i<=n;i++) {
			int a,b,w;
			a = sc.nextInt()+1;
			b = sc.nextInt()+1;
			w = sc.nextInt();
			arr[a][b] += w;
		}
		for(int i=1;i<N;i++) {
			for(int j=1;j<N;j++) {
				s[i][j] = s[i-1][j] + s[i][j-1] - s[i-1][j-1] + arr[i][j];
			}
		}
		if(r>5000) {
			System.out.println(s[N-1][N-1]);
		}else {
			for(int i=1;i<N;i++) {
				for(int j=1;j<N;j++) {
					int si = i-r+1;
					int sj = j-r+1;
					if(si<1 || sj<1) continue;
					int val = s[i][j] - s[si-1][j] - s[i][sj-1] + s[si-1][sj-1];
					ans = Math.max(ans,val);
				}
			}
			System.out.println(ans);
		}
		
	}
	
	
}
