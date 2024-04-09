package ËÑË÷;

import java.util.*;
import java.math.*;
import java.io.*;
public class _15Âí×ßÈÕ {
	static int INF = 0x3f3f3f3f;
	static int N = 109 , M = 2*N;
	static int n,m,sx,sy,ans;
	static int[][] vis = new int[N][N];
	static int[] dx = {-2,-1,1,2,-2,-1,1,2};
	static int[] dy = {1,2,2,1,-1,-2,-2,-1};
	static void dfs(int x,int y,int cnt) {
		if(cnt==n*m) {
			ans++;
			return ;
		}
		
		for(int i=0;i<8;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx>=0 && nx<n && ny>=0 &&ny<m && vis[nx][ny]==0) {
				vis[nx][ny] = 1;
				dfs(nx,ny,cnt+1);
				vis[nx][ny] = 0;
			}
		}
	}
	
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		
		while(k-->0) {
			n = sc.nextInt();
			m = sc.nextInt();
			sx = sc.nextInt();
			sy = sc.nextInt();
			ans = 0;
			for(int i=0;i<n;i++)
				Arrays.fill(vis[i],0);
			vis[sx][sy] = 1;
			dfs(sx,sy,1);
			System.out.println(ans);
		}
	}
}
