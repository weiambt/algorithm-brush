package ËÑË÷;

import java.util.*;
import java.math.*;
import java.io.*;
public class _13ÃÔ¹¬ {
	static int INF = 0x3f3f3f3f;
	static int N = 109 , M = 2*N;
	static int n,sx,sy,ex,ey;
	static char[][] g = new char[N][N];
	static int[][] vis = new int[N][N];
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int ans = 0;
	static void dfs(int x,int y) {
		if(x==ex && y==ey) {
			ans=1;
			return;
		}
		
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx>=0 && nx<n && ny>=0 &&ny<n &&vis[nx][ny]==0 && g[nx][ny]=='.') {
				vis[nx][ny] = 1;
				dfs(nx,ny);
				
			}
		}
	}
	
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		while(k-->0) {
			ans = 0;
			for(int i=0;i<n;i++)
				Arrays.fill(vis[i],0);
			n = sc.nextInt();
			for(int i=0;i<n;i++) {
				g[i] = sc.next().toCharArray();
			}
			sx = sc.nextInt();
			sy = sc.nextInt();
			ex = sc.nextInt();
			ey = sc.nextInt();
			if(g[sx][sy]=='#' || g[ex][ey]=='#') {
				System.out.println("NO");
				continue;
			}
			dfs(sx,sy);
			if(ans==1) System.out.println("YES");
			else System.out.println("NO");
		}
		
		
		
	}
}
