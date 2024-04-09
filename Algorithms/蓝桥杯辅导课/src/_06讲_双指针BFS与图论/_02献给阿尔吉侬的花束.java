package _06��_˫ָ��BFS��ͼ��;

import java.util.*;
import java.math.*;
import java.io.*;

public class _02�׸�������ٯ�Ļ��� {
	static int INF = 0x3f3f3f3f;
	static int N = 210 , M = 2*N;
	static char[][] arr = new char[N][N];
	static int[][] vis = new int[N][N];
	static int[][] cen = new int[N][N];
	static int t,r,c,sx,sy,ex,ey;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	static int bfs() {
		for(int i=0;i<N;i++) {
			Arrays.fill(cen[i], INF);
			Arrays.fill(vis[i], 0);
		}

		Queue<Integer[]> q = new LinkedList<>();
		q.add(new Integer[]{sx,sy});
		cen[sx][sy] = 0;
		vis[sx][sy] = 1;
		while(q.size()>0) {
			Integer[] top = q.poll();
			int x = top[0], y = top[1];
			for(int i=0;i<4;i++) {
				int nx = x + dx[i],ny = y + dy[i];
				if(check(nx,ny)==1) {
					q.add(new Integer[] {nx,ny});
					vis[nx][ny] = 1;
					cen[nx][ny] = cen[x][y]+1;
				}
			}
		}
		return cen[ex][ey];
	}
	static int check(int x,int y) {
		if(x>=1 && x<=r && y>=1 && y<=c && vis[x][y]==0 && arr[x][y]=='.')
			return 1;
		return 0;
	}
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		while(t-->0) {

			r = sc.nextInt();
			c = sc.nextInt();
			for(int i=1;i<=r;i++) {
				char[] s = sc.next().toCharArray();
//				System.out.println(s);
				for(int j=1;j<=c;j++) {
					arr[i][j] = s[j-1];
					if(arr[i][j]=='S') {
						sx = i;sy = j;
					}
					if(arr[i][j]=='E') {
						ex = i;ey = j;
						arr[i][j]='.';
					}
				}
			}
			
			int ans = bfs();
			if(ans!=INF)
				System.out.println(ans);
			else System.out.println("oop!");
		}
		
		
	}
}
