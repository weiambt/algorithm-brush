package _12BFS;
import java.util.*;
import java.math.*;
import java.io.*;

public class È«Çò±äÅ¯ {
		static int INF = 0x3f3f3f3f;
		static int N = 1010 , M = 2*N;
		static int[] dx = {1,0,-1,0};
		static int[] dy = {0,1,0,-1};
		static char[][] g = new char[N][N];
		static int[][] st = new int[N][N];
		static int n,m,ans,flag;
		static void dfs(int x,int y) {

			if(g[x-1][y]=='#' && g[x+1][y]=='#' && g[x][y+1]=='#' && g[x][y-1]=='#' )
				flag=1;
			

			for(int k=0;k<4;k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				if(check(nx,ny) && g[nx][ny]=='#' && st[nx][ny]==0) {
					st[nx][ny]=1;
					dfs(nx, ny);
				}
			}
		}
		static boolean check(int x,int y) {
			return x>=0 && x<n && y>=0 && y<n;
		}

		public static void main(String[] sss) {
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			for(int i=0;i<n;i++) {
				String s = sc.next();
				g[i] = s.toCharArray();
			}
				
			for(int i=0;i<n;i++) 
				for(int j=0;j<n;j++) {
					if(g[i][j]=='.' || st[i][j]==1) continue;
						st[i][j]=1;
						flag=0;
						dfs(i,j);
						if(flag==0) ans++;
					
				}
			System.out.println(ans);
					
		}
}
