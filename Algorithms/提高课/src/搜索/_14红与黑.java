package ËÑË÷;

import java.util.*;
import java.math.*;
import java.io.*;
public class _14ºìÓëºÚ {
	static int INF = 0x3f3f3f3f;
	static int N = 109 , M = 2*N;
	static int n,m,sx,sy;
	static char[][] g = new char[N][N];
	static int[][] vis = new int[N][N];
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int ans = 1;
	static void dfs(int x,int y) {
		
		
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx>=0 && nx<n && ny>=0 &&ny<m &&vis[nx][ny]==0 && g[nx][ny]=='.') {
				vis[nx][ny] = 1;
				ans++;
				dfs(nx,ny);
				
			}
		}
	}
	
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			m = sc.nextInt();
			n = sc.nextInt();
			if(n==0 && m==0) break;
			ans = 1;
			for(int i=0;i<n;i++)
				Arrays.fill(vis[i],0);
			for(int i=0;i<n;i++) {
				g[i] = sc.next().toCharArray();
				for(int j=0;j<m;j++)
					if(g[i][j]=='@') {
						sx = i;
						sy = j;
					}	
			}
			dfs(sx,sy);
			System.out.println(ans);
		}
	}
}
