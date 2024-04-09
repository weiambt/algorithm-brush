package _06讲_双指针BFS与图论;

import java.util.*;
import java.math.*;
import java.io.*;

public class _06地牢大师 {
	static int INF = 0x3f3f3f3f;
	static int N = 110 , M = 2*N;
	static char[][][] g = new char[N][N][N];
	static int[][][] vis = new int[N][N][N];
	static int[][][] cen = new int[N][N][N];
	static int n,m,k;
	static int scen,sx,sy,ecen,ex,ey;
	static int[] dc = {0,0,0,0,1,-1};
	static int[] dx = {1,0,-1,0,0,0};
	static int[] dy = {0,1,0,-1,0,0};
	
	static boolean check(int c,int x,int y) {
		if(c>=1 && c<=k && x >=1 && x<=n && y>=1 && y<=m && g[c][x][y]=='.' && vis[c][x][y]==0)
			return true;
		return false;
	}
	
	static int bfs() {
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++) {
				Arrays.fill(vis[i][j], 0);
				Arrays.fill(cen[i][j], INF);
			}
		Queue<PIII> q = new LinkedList<>();
		q.add(new PIII(scen,sx,sy));
		vis[scen][sx][sy] = 1;
		cen[scen][sx][sy] = 0;
		
		while(q.size()>0) {
			PIII top = q.poll();
			for(int i=0;i<6;i++) {
				int nc = top.c+dc[i];
				int nx = top.x+dx[i];
				int ny = top.y+dy[i];
				if(check(nc,nx,ny)) {
					q.add(new PIII(nc,nx,ny));
					vis[nc][nx][ny] = 1;
					cen[nc][nx][ny] = cen[top.c][top.x][top.y]+1;
				}
			}
		}
		
		return cen[ecen][ex][ey];
	}

	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			k = sc.nextInt();
			n = sc.nextInt();
			m = sc.nextInt();
			if(n==0 && m==0 && k==0) break;
			for(int c=1;c<=k;c++) {
				for(int i=1;i<=n;i++) {
					char[] s = sc.next().toCharArray();
					for(int j=1;j<=m;j++) {
						g[c][i][j] = s[j-1];
						if(g[c][i][j]=='S') {
							scen = c;
							sx = i;
							sy = j;
						}
						if(g[c][i][j]=='E') {
							g[c][i][j]='.';
							ecen = c;
							ex = i;
							ey = j;
						}
					}
				}
			}
			int ans = bfs();
			if(ans!=INF) System.out.printf("Escaped in %d minute(s).\n",ans);
			else System.out.println("Trapped!");
		}
	}
}
class PIII{
	int c;
	int x;
	int y;
	public PIII(int c,int x,int y) {
		// TODO Auto-generated constructor stub
		this.c = c;
		this.x = x;
		this.y = y;
	}
}
