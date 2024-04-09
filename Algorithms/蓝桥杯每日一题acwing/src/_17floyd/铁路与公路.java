package _17floyd;

import java.util.*;
import java.math.*;
import java.io.*;

public class 铁路与公路 {
	static int INF = 0x3f3f3f3f;
	static int N = 1010 , M = 2*N;
	static int n,m,k,end;
	static int[][] tie = new int[N][N],gong = new int[N][N];

	static int floyd(int[][] g) {
		
		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					g[i][j] = Math.min(g[i][j], g[i][k]+g[k][j]);
				}
			}
		}
		return g[1][n];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		for(int i=0;i<n;i++) {
			Arrays.fill(tie[i], INF);
			Arrays.fill(gong[i], INF);
		}
		for(int i=1;i<=m;i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			tie[u][v]=1;tie[v][u]=1;
		}
		//初始化公路
		for(int i=1;i<=n;i++)
			for(int j=1;j<=n;j++)
				if(i!=j && tie[i][j]==INF)
					gong[i][j] = gong[j][i] = 1;
		int a = floyd(tie);
		int b = floyd(gong);
		int ans = Math.max(a,b);
		System.out.println(ans==INF?-1:ans);
	}

	
}
