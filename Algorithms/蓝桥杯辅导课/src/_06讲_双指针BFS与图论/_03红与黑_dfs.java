package _06讲_双指针BFS与图论;

import java.util.*;
import java.math.*;
import java.io.*;

public class _03红与黑_dfs {

		static int INF = 0x3f3f3f3f;
		static int N = 210 , M = 2*N;
		static char[][] arr = new char[N][N];
		static int n,m,sx,sy,ans=1;
		static int[] dx = {1,0,-1,0};
		static int[] dy = {0,1,0,-1};
		
		static void dfs(int x,int y) {
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(check(nx, ny)==1) {
					ans++;
					arr[nx][ny]='#';
					dfs(nx, ny);
				}
			}
		}
			
		static int check(int x,int y) {
			if(x>=1 && x<=n && y>=1 && y<=m && arr[x][y]=='.')
				return 1;
			return 0;
		}
		public static void main(String[] sss) {
			Scanner sc = new Scanner(System.in);
			while(sc.hasNext()) {
				m = sc.nextInt();
				n = sc.nextInt();
				ans = 1;
				if(n==0 && m==0) break;
				for(int i=1;i<=n;i++) {
					char[] s = sc.next().toCharArray();
					for(int j=1;j<=m;j++) {
						arr[i][j] = s[j-1];
						if(arr[i][j]=='@') {
							sx = i;
							sy = j;
						}
					}
				}
				dfs(sx, sy);
				System.out.println(ans);	
			}
		}

}
